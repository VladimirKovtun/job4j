package ru.job4j.dbconfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public final class ParserDbConnection {
    private static final Logger LOGGER = LogManager.getLogger(ParserDbConnection.class.getName());
    private static Properties prop = new Properties();
    private static Connection connection;

    private ParserDbConnection() {

    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = config();
        }
        LOGGER.info("connection - {}", connection.toString());
        return connection;
    }

    private static Connection config() {
        LOGGER.info("Connecting to database.");
        Connection connection;
        try (InputStream in = ParserDbConnection.class
                              .getClassLoader().getResourceAsStream("app.properties")) {
            prop.load(in);
            Class.forName(prop.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(prop.getProperty("url.jdbc"),
                                                     prop.getProperty("username.jdbc"),
                                                     prop.getProperty("password.jdbc"));
        } catch (Exception exc) {
            LOGGER.error(exc.getMessage(), exc);
            throw new IllegalStateException();
        }
        if (!dbExist(connection)) {
            createDB(connection);
        }
        LOGGER.info("Create connection {}", connection.toString());
        return connection;
    }

    private static void createDB(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(String.format("CREATE TABLE " + "%s ("
                    + "id serial primary key,"
                    + "title text NOT NULL UNIQUE,"
                    + "message text NOT NULL,"
                    + "link text NOT NULL,"
                    + "create_time TIMESTAMP NOT NULL);", prop.getProperty("table.name")));
        } catch (Exception exc) {
            LOGGER.error(exc.getMessage(), exc);
        }
    }

    private static boolean dbExist(Connection connection) {
        boolean exists = false;
        try (ResultSet tables = connection.getMetaData().
                getTables(null, null,
                        prop.getProperty("table.name"), null)) {
            String tName;
            while (tables.next()) {
                tName = tables.getString("TABLE_NAME");
                if (prop.getProperty("table.name").equals(tName)) {
                    LOGGER.info("Database and table exists.");
                    exists = true;
                    break;
                }
            }
        } catch (Exception exc) {
            LOGGER.error(exc.getMessage(), exc);
        }
        return exists;
    }
}
