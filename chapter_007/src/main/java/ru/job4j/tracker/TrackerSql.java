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
    private Statement statement;
    private ResultSet resultSet;

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
            ResultSet rs = connection.getMetaData()
                    .getTables(null, null, TABLE_NAME, null);
            while (rs.next()) {
                String tName = rs.getString("TABLE_NAME");
                if (TABLE_NAME.equals(tName)) {
                    res = true;
                    break;
                }
            }
            if (!res) {
                query = "CREATE TABLE items (id serial primary key, name varchar(100));";
                exUpdate(query);
                res = true;
                System.out.println("Table " + TABLE_NAME + " created.");
            }
        }
        return res;
    }

    @Override
    public Item add(Item item) {
        query = String.format("INSERT into items(id, name) VALUES (%s), (%s);",
                item.getId(), item.getName());
        exUpdate(query);
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        query = String.format("UPDATE items SET id = %s, name = %s WHERE id = %s;",
                item.getId(), item.getName(), id);
        return exUpdate(query);
    }

    @Override
    public boolean delete(String id) {
        query = String.format("DELETE FROM items WHERE id = %s;", id);
        return exUpdate(query);
    }

    @Override
    public List<Item> findAll() {
        query = "SELECT id, name FROM items;";
        resultSet = exQuery(query);
        return getResult(resultSet);
    }

    @Override
    public List<Item> findByName(String key) {
        query = String.format("SELECT id, name FROM items WHERE name = %s;", key);
        resultSet = exQuery(query);
        return getResult(resultSet);
    }

    @Override
    public Item findById(String id) {
        query = String.format("SELECT id, name FROM items WHERE id = %s;", id);
        resultSet = exQuery(query);
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

    private ResultSet exQuery(String query) {
        try {
            statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException exc) {
            throw new IllegalStateException();
        }
    }

    private boolean exUpdate(String query) {
        try {
            statement = connection.createStatement();
            statement.execute(query);
            return true;
        } catch (SQLException exc) {
            return false;
        }
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
