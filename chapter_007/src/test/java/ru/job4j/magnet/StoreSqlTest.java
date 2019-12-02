package ru.job4j.magnet;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StoreSqlTest {
    Connection config = new Config().init("url");
    StoreSql storeSql = new StoreSql(config);

    @Test
    public void whenGenerateOneThen1() throws SQLException {
        storeSql.generate(1);
        int res = config.createStatement().executeQuery("SELECT * from entity;").getInt(1);
        assertThat(res, is(0));
    }

    @Test
    public void whenAdd2ThenListSize2() {
        storeSql.generate(2);
        List<Entity> res = storeSql.load();
        Iterator<Entity> iterator = res.iterator();
        assertThat(iterator.next().getField(), is(0));
        assertThat(iterator.next().getField(), is(1));
    }

}