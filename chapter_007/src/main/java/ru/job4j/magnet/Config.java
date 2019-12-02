package ru.job4j.magnet;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Config {
    private final Properties values = new Properties();
    private Connection connection;
    private Statement statement;

    public Connection init(String url) {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("appSqlLite.properties")){
            values.load(in);
            connection = DriverManager.getConnection(get(url));
        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }
        createDB();
        return connection;
    }

    public String get(String key) {
        return values.getProperty(key);
    }

    private void createDB() {
        if (connection != null) {
            try {
                statement = connection.createStatement();
                statement.execute("DROP table if exists entity;");
                statement.execute("CREATE table entity (field integer);");
            } catch (SQLException exc) {
                throw new IllegalStateException();
            }
        }
    }
}
