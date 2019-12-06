package ru.job4j.tracker;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSqlTest {

    public Connection init() {
        try (InputStream in = TrackerSql.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void whenCheckConnection() {
        TrackerSql sql = new TrackerSql();
        assertNotNull(sql.init());
    }

    @Test
    public void whenAddItem() throws Exception {
        try (TrackerSql trackerSql = new TrackerSql(ConnectionRollback.create(this.init()))) {
            trackerSql.add(new Item("name", "Description"));
            assertThat(trackerSql.findByName("name").get(0).getName(), is("name"));
        }
    }

    @Test
    public void whenFindByNameItem() throws Exception {
        try (TrackerSql trackerSql = new TrackerSql(ConnectionRollback.create(this.init()))) {
            String id = trackerSql.add(new Item("name", "Description")).getId();
            String id1 = trackerSql.add(new Item("name", "Description1")).getId();
            String id2 = trackerSql.add(new Item("name2", "Description2")).getId();
            String id3 = trackerSql.add(new Item("name", "Description3")).getId();
            assertThat(trackerSql.findByName("name").size(), is(3));

        }
    }

    @Test
    public void whenReplaceItem() throws Exception {
        try (TrackerSql trackerSql = new TrackerSql(ConnectionRollback.create(this.init()))) {
            String id = trackerSql.add(new Item("name", "Description")).getId();
            boolean isQuery = trackerSql.replace(id, new Item("newName", "newDescription"));
            assertTrue(isQuery);
            assertThat(trackerSql.findByName("newName").get(0).getName(), is("newName"));
        }
    }

    @Test
    public void whenDeleteItem() throws Exception {
        try (TrackerSql trackerSql = new TrackerSql(ConnectionRollback.create(this.init()))) {
            String id = trackerSql.add(new Item("name", "Description")).getId();
            String id1 = trackerSql.add(new Item("name1", "Description1")).getId();
            assertThat(trackerSql.findAll().size(), is(2));
            assertTrue(trackerSql.delete(id));
            assertThat(trackerSql.findAll().size(), is(1));
            assertThat(trackerSql.findByName("name").size(), is(0));
        }
    }

    @Test
    public void whenFindAllItem() throws Exception {
        try (TrackerSql trackerSql = new TrackerSql(ConnectionRollback.create(this.init()))) {
            String id = trackerSql.add(new Item("name", "Description")).getId();
            String id1 = trackerSql.add(new Item("name1", "Description1")).getId();
            String id2 = trackerSql.add(new Item("name2", "Description2")).getId();
            String id3 = trackerSql.add(new Item("name3", "Description3")).getId();
            assertThat(trackerSql.findAll().size(), is(4));
        }
    }

    @Test
    public void whenFindByIdItem() throws Exception {
        try (TrackerSql trackerSql = new TrackerSql(ConnectionRollback.create(this.init()))) {
            String id = trackerSql.add(new Item("name", "Description")).getId();
            String id1 = trackerSql.add(new Item("name1", "Description1")).getId();
            String id2 = trackerSql.add(new Item("name2", "Description2")).getId();
            String id3 = trackerSql.add(new Item("name3", "Description3")).getId();
            assertThat(trackerSql.findById(id).getName(), is("name"));
            assertThat(trackerSql.findById(id1).getName(), is("name1"));
            assertThat(trackerSql.findById(id2).getName(), is("name2"));
            assertThat(trackerSql.findById(id3).getName(), is("name3"));
        }
    }
}
