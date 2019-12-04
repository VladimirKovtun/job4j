package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TrackerSql implements ITracker, AutoCloseable {
    private static final String TABLE_NAME = "items";
    private String query;
    private Connection connection;


    public boolean init() {
        boolean isExist = false;
        try (InputStream in = TrackerSql.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password"));
            isExist = tableExist();
        } catch (SQLException exc) {
            throw new IllegalStateException();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return connection != null && isExist;
    }

    public boolean tableExist() throws SQLException {
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
            }
            if (!res) {
                try (Statement statement = connection.createStatement()) {
                    statement.execute("CREATE TABLE items (id serial primary key, name varchar(100));");
                } catch (SQLException exc) {
                    throw new IllegalStateException(exc);
                }
                res = true;
                System.out.println("Table " + TABLE_NAME + " created.");
            }

        }
        return res;
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement prStatement =
                     connection.prepareStatement("INSERT into items(id, name) VALUES (?, ?);");) {
            prStatement.setInt(1, Integer.valueOf(item.getId()));
            prStatement.setString(2, item.getName());
            prStatement.execute();
        } catch (SQLException exc) {
            throw new IllegalStateException(exc);
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        boolean res;
        try (PreparedStatement prStatement =
                     connection.prepareStatement("UPDATE items SET id = ?, name = ? WHERE id = ?;")) {
            prStatement.setInt(1, Integer.valueOf(item.getId()));
            prStatement.setString(2, item.getName());
            prStatement.setInt(2, Integer.valueOf(id));
            prStatement.execute();
            res = true;
        } catch (SQLException exc) {
            throw new IllegalStateException(exc);
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
            throw new IllegalStateException(exc);
        }
        return res;
    }

    @Override
    public List<Item> findAll() {
        ResultSet resultSet;
        try (Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery("SELECT id, name FROM items;");
        } catch (SQLException exc) {
            throw new IllegalStateException();
        }
        return getResult(resultSet);
    }

    @Override
    public List<Item> findByName(String key) {
        ResultSet resultSet;
        try (PreparedStatement prStatement =
                     connection.prepareStatement("SELECT id, name FROM items WHERE name = ?;")) {
            prStatement.setString(1, key);
            resultSet = prStatement.executeQuery();
        } catch (SQLException exc) {
            throw new IllegalStateException();
        }
        return getResult(resultSet);

    }

    @Override
    public Item findById(String id) {
        ResultSet resultSet;
        try (PreparedStatement prStatement =
                     connection.prepareStatement("SELECT id, name FROM items WHERE id = ?;")) {
            prStatement.setInt(1, Integer.valueOf(id));
            resultSet = prStatement.executeQuery();
        } catch (SQLException exc) {
            throw new IllegalStateException();
        }
        return getResult(resultSet).get(0);
    }

    private List<Item> getResult(ResultSet resultSet) {
        Item item;
        List<Item> res = new ArrayList<>();
        try {
            while (resultSet.next()) {
                String itemId = String.valueOf(resultSet.getInt("id"));
                String name = resultSet.getString("name");
                item = new Item(name);
                item.setId(itemId);
                res.add(item);
            }
        } catch (SQLException exc) {
            throw new IllegalStateException();
        }
        return res;
    }

    public void closeCon() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new IllegalStateException();
            }
        }
    }

    @Override
    public void close() throws Exception {
    }
}
