package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

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

    @Test
    public void whenHasNextReturnFalse() {
        Iterator<Integer> itr = list.iterator();
        assertThat(itr.next(), is(3));
        assertThat(itr.hasNext(), is(true));
    }

    @Test
    public void whenNextReturnExpectedResult() {
        Iterator<Integer> itr = list.iterator();
        assertThat(itr.next(), is(3));
        assertThat(itr.next(), is(2));
        assertThat(itr.next(), is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmptyContainerAndNextInvokeNoSuchException() {
        Iterator<Integer> itr = list.iterator();
        itr.next();
        itr.next();
        itr.next();
        itr.next();
    }
}