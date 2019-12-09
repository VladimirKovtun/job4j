package ru.job4j.tracker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public final class TrackerSqlConnection {
    private static final Logger LOGGER = LogManager.getLogger(TrackerSqlConnection.class.getName());
    private static final String TABLE_NAME = "items";
    private static Connection connection;

    private TrackerSqlConnection() {

    }

    public static Connection getConnection() {
        if (connection == null) {
            connection = init();
        }
        return connection;
    }

    private static Connection init() {
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
            LOGGER.error(exc.getMessage(), exc);
            throw new IllegalStateException();
        }
        if (!tableExist(connection)) {
            LOGGER.error("Can't create table");
            throw new IllegalStateException();
        }
        return connection;
    }

    private static boolean tableExist(Connection connection) {
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
                LOGGER.error(exc.getMessage(), exc);
                throw new IllegalStateException();
            }
            if (!res) {
                try (Statement statement = connection.createStatement()) {
                    statement.execute("CREATE TABLE items (id serial primary key, name varchar(100), description text);");
                } catch (SQLException exc) {
                    LOGGER.error(exc.getMessage(), exc);
                    throw new IllegalStateException();
                }
                res = true;
            }
        }
        return res;
    }
}