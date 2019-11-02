package ru.job4j.map;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleHashMapTest {
    private SimpleHashMap<String, String> map;

    @Test
    public void whenAdd3ThenSize3() {
        map = new SimpleHashMap<>();
        map.insert("one", "1");
        map.insert("three", "3");
        map.insert("two", "2");
        assertThat(map.size(), is(3));
    }

    @Test
    public void whenAddOneAnd3DuplicateThenSizeOne() {
        map = new SimpleHashMap<>();
        map.insert("one", "1");
        map.insert("one", "2");
        map.insert("one", "3");
        map.insert("one", "4");
        assertThat(map.size(), is(1));
        assertThat(map.get("one"), is("4"));
    }

    @Test
    public void whenAdd4AndRemove4ThenSizeZero() {
        map = new SimpleHashMap<>();
        map.insert("one", "1");
        map.insert("two", "2");
        map.insert("three", "3");
        map.insert("four", "4");
        assertThat(map.remove("one"), is(true));
        assertThat(map.remove("two"), is(true));
        assertThat(map.remove("three"), is(true));
        assertThat(map.remove("four"), is(true));
        assertThat(map.size(), is(0));
    }

    @Test
    public void whenAdd3AndGet3() {
        map = new SimpleHashMap<>();
        map.insert("one", "1");
        map.insert("three", "3");
        map.insert("two", "2");
        assertThat(map.get("three"), is("3"));
        assertThat(map.get("one"), is("1"));
        assertThat(map.get("two"), is("2"));
    }

    @Test
    public void whenIsResize() {
        map = new SimpleHashMap<>(4);
        map.insert("1", "1");
        map.insert("2", "2");
        map.insert("3", "3");
        map.insert("4", "4");
        map.insert("5", "5");
        map.insert("6", "6");
        assertThat(map.size(), is(6));
        assertThat(map.get("3"), is("3"));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenAllIteratorActionWork() {
        map = new SimpleHashMap<>();
        map.insert("one", "1");
        map.insert("three", "3");
        map.insert("two", "2");
        Iterator<SimpleHashMap.Node<String, String>> iterator = map.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next().getValue(), is("1"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next().getValue(), is("2"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next().getValue(), is("3"));
        assertThat(iterator.hasNext(), is(false));
        iterator.next();
    }
}