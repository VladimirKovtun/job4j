package ru.job4j.parsersqlru;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.IParserDAO;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ParserSqlRuRepository implements IParserDAO<Vacancy>, AutoCloseable {
    private final Logger logger = LogManager.getLogger(ParserSqlRuRepository.class.getName());
    private final Connection connection;

    public ParserSqlRuRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Vacancy create(Vacancy vacancy) {
        String query = "INSERT INTO vacancy(title, message, link, create_time) VALUES(?, ?, ?, ?)"
                + " ON CONFLICT (title) DO NOTHING ;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             PreparedStatement selectStatement =
                     connection.prepareStatement("SELECT id FROM vacancy WHERE title = ?")) {
            preparedStatement.setString(1, vacancy.getTitle());
            preparedStatement.setString(2, vacancy.getMessage());
            preparedStatement.setString(3, vacancy.getLink());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(vacancy.getCreateTime()));
            preparedStatement.execute();
            selectStatement.setString(1, vacancy.getTitle());
            ResultSet resultSet = selectStatement.executeQuery();
            resultSet.next();
            vacancy.setId(resultSet.getInt("id"));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return vacancy;
    }

    @Override
    public void createAll(List<Vacancy> list) {
        String query = "INSERT INTO vacancy(title, message, link, create_time) VALUES(?, ?, ?, ?)"
                        + "ON CONFLICT (title) DO NOTHING ;";
        int pcs = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            for (Vacancy vacancy : list) {
                preparedStatement.setString(1, vacancy.getTitle());
                preparedStatement.setString(2, vacancy.getMessage());
                preparedStatement.setString(3, vacancy.getLink());
                preparedStatement.setTimestamp(4, Timestamp.valueOf(vacancy.getCreateTime()));
                preparedStatement.addBatch();
                pcs++;
            }
            preparedStatement.executeBatch();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        logger.info("Vacancy was added to database {}", pcs);
    }

    @Override
    public Vacancy getId(int id) {
        Vacancy vacancy = null;
        String query = "SELECT * FROM vacancy WHERE id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            vacancy = getResult(preparedStatement.executeQuery()).get(0);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return vacancy;
    }

    @Override
    public List<Vacancy> getAll() {
        List<Vacancy> vacancyList = null;
        String query = "SELECT * FROM vacancy;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            vacancyList = getResult(preparedStatement.executeQuery());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return vacancyList;
    }

    @Override
    public boolean update(int id, Vacancy vacancy) {
        int row = 0;
        String query = "UPDATE vacancy SET title = ?, message = ?, link = ?, create_time = ? WHERE id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, vacancy.getTitle());
            preparedStatement.setString(2, vacancy.getMessage());
            preparedStatement.setString(3, vacancy.getLink());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(vacancy.getCreateTime()));
            preparedStatement.setInt(5, id);
            row = preparedStatement.executeUpdate();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return row > 0;
    }

    public LocalDateTime getLastTime() {
        logger.info("Try get create_time last added vacancy");
        Vacancy vacancy = null;
        String quantityQuery = "SELECT COUNT(*) FROM vacancy;";
        String queryNewVacancy = "SELECT * FROM vacancy ORDER BY create_time DESC LIMIT 1;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(quantityQuery);
             PreparedStatement prStat = connection.prepareStatement(queryNewVacancy);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            resultSet.next();
            if (resultSet.getInt(1) > 0) {
                vacancy = getResult(prStat.executeQuery()).get(0);
                logger.info("Find last added vacancy create_date.");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return vacancy == null ? null : vacancy.getCreateTime();
    }

    private List<Vacancy> getResult(ResultSet resultSet) {
        List<Vacancy> vacancyList = new ArrayList<>();
        Vacancy vacancy;
        try {
            while (resultSet.next()) {
                vacancy = new Vacancy(resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("message"),
                        resultSet.getString("link"),
                        resultSet.getTimestamp("create_time").toLocalDateTime());
                vacancyList.add(vacancy);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return vacancyList;
    }

    @Override
    public void close() {
        try {
            logger.info("Connection closed {}", connection.toString());
            connection.close();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
