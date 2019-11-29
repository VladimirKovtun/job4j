package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSqlTest {

    @Test
    public void checkConnection() {
        TrackerSql sql = new TrackerSql();
        assertThat(sql.init(), is(true));
    }
}