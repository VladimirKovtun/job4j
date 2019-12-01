package ru.job4j.magnet;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Config {
    private final Map<String, String> pathToDb = new HashMap<>();
    private final Properties values = new Properties();
    Connection connection;
    Statement statement;

    {
        pathToDb.put("temp", System.getProperty("java.io.tmpdir") + "name.db");
        pathToDb.put("notTemp", "chapter_007/data/name.db");
    }

    public Connection init(String key) {
        String URL;
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("appSqlLite.properties")) {
            values.load(in);
            //Class.forName(get("driver-class-name"));
            URL = get("url");
            URL = key != null ?
                    URL.substring(0, URL.lastIndexOf(":memory:")) + pathToDb.get(key) : URL;
            connection = DriverManager.getConnection(URL);
        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }
        createDB();
        return connection;
    }

    private String get(String key) {
        return values.getProperty(key);
    }

    /*public boolean checkBD(String key) {
        boolean res = false;
        if (key != null) {
            res = new File(pathToDb.get(key)).exists();
        }
        return res;
    }*/

    public void createDB() {
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
