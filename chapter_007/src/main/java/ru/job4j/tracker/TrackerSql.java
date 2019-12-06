package ru.job4j.tracker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TrackerSql implements ITracker, AutoCloseable {
    private final Logger logger = LogManager.getLogger(TrackerSql.class.getName());
    private static final String TABLE_NAME = "items";
    private Connection connection;

    public TrackerSql() {
    }

    public TrackerSql(Connection connection) {
        this.connection = connection;
    }


    public Connection init() {
        Connection connection;
        try (InputStream in = TrackerSql.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password"));
        } catch (Exception exc) {
            logger.error(exc.getMessage(), exc);
            throw new IllegalStateException();
        }
        if (!tableExist(connection)) {
            logger.error("Can't create table");
            throw new IllegalStateException();
        }
        return connection;
    }

    private boolean tableExist(Connection connection) {
        boolean res = false;
        if (connection != null) {
            try (ResultSet rs = connection.getMetaData()
                    .getTables(null, null, TABLE_NAME, null)) {
                while (rs.next()) {
                    String tName = rs.getString("TABLE_NAME");
                    if (TABLE_NAME.equals(tName)) {
                        res = true;
                        break;
                    }
                }
            } catch (SQLException exc) {
                logger.error(exc.getMessage(), exc);
                throw new IllegalStateException();
            }
            if (!res) {
                try (Statement statement = connection.createStatement()) {
                    statement.execute("CREATE TABLE items (id serial primary key, name varchar(100), description text);");
                } catch (SQLException exc) {
                    logger.error(exc.getMessage(), exc);
                    throw new IllegalStateException();
                }
                res = true;
            }
        }
        return res;
    }

    @Override
    public Item add(Item item) {
        Item resultItem = null;
        try (PreparedStatement insertStatement =
                                         connection.prepareStatement("INSERT into items(name, description) VALUES (?, ?);");
             PreparedStatement selectStatement = connection.prepareStatement("SELECT * from items where name = ?;")) {
            insertStatement.setString(1, item.getName());
            insertStatement.setString(2, item.getDescription());
            insertStatement.execute();
            selectStatement.setString(1, item.getName());
            ResultSet resultSet = selectStatement.executeQuery();
            resultItem = getResult(resultSet).get(0);
        } catch (SQLException exc) {
            logger.error(exc.getMessage(), exc);
        }
        return resultItem;
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean res;
        try (PreparedStatement prStatement =
                     connection.prepareStatement("UPDATE items SET name = ?, description = ?, createDate = ? WHERE id = ?;")) {
            prStatement.setString(1, item.getName());
            prStatement.setString(2, item.getDescription());
            prStatement.setTime(3, (Time) item.getCreateDate());
            prStatement.setInt(4, Integer.valueOf(id));
            prStatement.execute();
            res = true;
        } catch (SQLException exc) {
            logger.error(exc.getMessage(), exc);
            res = false;
        }
        return res;
    }

    @Override
    public boolean delete(String id) {
        boolean res;
        try (PreparedStatement prStatement =
                     connection.prepareStatement("DELETE FROM items WHERE id = ?;")) {
            prStatement.setInt(1, Integer.valueOf(id));
            prStatement.execute();
            res = true;
        } catch (SQLException exc) {
            logger.error(exc.getMessage(), exc);
            res = false;
        }
        return res;
    }

    @Override
    public List<Item> findAll() {
        List<Item> resultList = null;
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM items;");
            resultList = getResult(resultSet);
        } catch (SQLException exc) {
            logger.error(exc.getMessage(), exc);
        }
        return resultList;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> resultList = null;
        try (PreparedStatement prStatement =
                     connection.prepareStatement("SELECT * FROM items WHERE name = ?;")) {
            prStatement.setString(1, key);
            ResultSet resultSet = prStatement.executeQuery();
            resultList = getResult(resultSet);
        } catch (SQLException exc) {
            logger.error(exc.getMessage(), exc);
        }
        return resultList;
    }

    @Override
    public Item findById(String id) {
        Item resItem = null;
        try (PreparedStatement prStatement =
                     connection.prepareStatement("SELECT * FROM items WHERE id = ?;")) {
            prStatement.setInt(1, Integer.valueOf(id));
           ResultSet resultSet = prStatement.executeQuery();
           resItem = getResult(resultSet).get(0);
        } catch (SQLException exc) {
            logger.error(exc.getMessage(), exc);
        }
        return resItem;
    }

    private List<Item> getResult(ResultSet resultSet) {
        List<Item> resultList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Item newItem = new Item(resultSet.getString("name"));
                newItem.setId(String.valueOf(resultSet.getInt("id")));
                resultList.add(newItem);
            }
        } catch (SQLException exc) {
            logger.error(exc.getMessage(), exc);
        }
        return resultList;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
    }
}
