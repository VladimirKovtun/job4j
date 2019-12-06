package ru.job4j.magnet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StoreSql {
    private final Connection connection;
    private final String sqlInsert = "INSERT into entity(field) values(?);";

    public StoreSql(Connection connection) {
        this.connection = connection;
    }

    public void generate(int size) {
        try {
            PreparedStatement prSt = connection.prepareStatement(sqlInsert);
            connection.setAutoCommit(false);
            for (int i = 0; i < size; i++) {
                prSt.setInt(1, i);
                prSt.addBatch();
            }
            prSt.executeBatch();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }
    }

    public List<Entity> load() {
        List<Entity> entityList = new ArrayList<>();
        try (ResultSet resultSet = connection.createStatement().executeQuery("SELECT * from entity;")) {
            while (resultSet.next()) {
                entityList.add(new Entity(resultSet.getInt(1)));
            }
        } catch (Exception exc) {
            throw new RuntimeException(exc);
        }
        closeCon();
        return entityList;
    }

    private void closeCon() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
