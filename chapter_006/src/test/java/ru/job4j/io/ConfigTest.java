package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        Config config = new Config("./data/pair_without_comment.properties");
        config.load();
        assertThat(
                config.value("name"),
                is("Vladimir Kovtun")
        );
        assertThat(
                config.value("first"),
                is("second")
        );
    }

    @Test
    public void whenPairWithComment() {
        Config config = new Config("./data/pair_with_comment.properties");
        config.load();
        assertThat(
                config.value("first"),
                is("second")
        );
        assertThat(
                config.value("name"),
                is("Vladimir Kovtun")
        );
        assertThat(
                config.value("One"),
                is("Two")
        );
        assertThat(
                config.value("red"),
                is("green")
        );
    }
}