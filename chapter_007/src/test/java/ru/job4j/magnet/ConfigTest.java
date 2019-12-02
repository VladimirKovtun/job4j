package ru.job4j.magnet;

import org.junit.Test;

import java.sql.Connection;
import static org.junit.Assert.*;

public class ConfigTest {
    Config config = new Config();

    @Test
    public void whenStartBDinMemory() {
        Connection url = config.init("url");
        assertNotNull(url);
    }

    @Test
    public void whenStartBDonHard() {
        Connection url = config.init("urlPathDbTest");
        assertNotNull(url);
    }
}