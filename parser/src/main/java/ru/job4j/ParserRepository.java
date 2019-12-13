package ru.job4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class ParserRepository implements IParser<Vacancy>, AutoCloseable {
    private final Logger logger = LogManager.getLogger(ParserRepository.class.getName());
    private final Connection connection;

    public ParserRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Vacancy create(Vacancy vacancy) {
        String query = "INSERT INTO vacancy(title, message, link, create_time) VALUES(?, ?, ?, ?)"
                                            + " ON CONFLICT (title, link) DO NOTHING ;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
              PreparedStatement selectStatement =
                      connection.prepareStatement("SELECT id FROM vacancy WHERE title = ?")) {
            preparedStatement.setString(1, vacancy.getTitle());
            preparedStatement.setString(2, vacancy.getMessage());
            preparedStatement.setString(3, vacancy.getLink());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(vacancy.getCreateTime()));
            preparedStatement.execute();
            selectStatement.setString(1, vacancy.getTitle());
            vacancy.setId(selectStatement.executeQuery().getInt("id"));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return vacancy;
    }

    @Override
    public void createAll(List<Vacancy> list) {
        String query = "INSERT INTO vacancy(title, message, link, create_time) VALUES(?, ?, ?, ?);";
        try {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                for (Vacancy vacancy : list) {
                    preparedStatement.setString(1, vacancy.getTitle());
                    preparedStatement.setString(2, vacancy.getMessage());
                    preparedStatement.setString(3, vacancy.getLink());
                    preparedStatement.setTimestamp(4, Timestamp.valueOf(vacancy.getCreateTime()));
                    preparedStatement.executeUpdate();
                    //preparedStatement.addBatch();
                }
                //preparedStatement.executeBatch();
                //connection.commit();
            } catch (Exception e) {
                connection.rollback();
                logger.error(e.getMessage(), e);
            }
        } catch (SQLException e) {
            logger.info(e.getMessage(), e);
        }
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

    @Override
    public boolean delete(int id) {
        int row = 0;
        String query = "DELETE FROM vacancy WHERE id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
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
        String query = "SELECT * FROM vacancy ORDER BY create_time DESC LIMIT 1;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(quantityQuery);
             PreparedStatement prStat = connection.prepareStatement(query);
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

    /*private Timestamp ldtToTimeStamp(LocalDateTime ldt) {
        //Timestamp timestamp = new Timestamp(ldt.toInstant(ZoneOffset.UTC).toEpochMilli());
        return Timestamp.valueOf(ldt);
    }

    private LocalDateTime tsToLocalDateTime(Timestamp ts) {
        //LocalDateTime.ofInstant(Instant.ofEpochSecond(ts.getTime()), ZoneOffset.UTC);
        return ts.toLocalDateTime();
    }*/

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
