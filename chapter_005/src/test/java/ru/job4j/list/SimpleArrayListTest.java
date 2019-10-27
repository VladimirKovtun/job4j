package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayListTest {
    private SimpleArrayList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenDeleteTwoElementsThenSizeOne() {
        list.delete();
        list.delete();
        assertThat(list.getSize(), is(1));
    }

    @Test
    public void whenDeleteAllElementsThenSizeZero() {
        list.delete();
        list.delete();
        list.delete();
        assertThat(list.getSize(), is(0));
    }

    @Test
    public void whenDeleteFirstElementsThenReturnThree() {
        Integer delete = list.delete();
        assertThat(delete, is(3));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }
}