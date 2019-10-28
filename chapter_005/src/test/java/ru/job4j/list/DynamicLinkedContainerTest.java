package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DynamicLinkedContainerTest {
    private DynamicLinkedContainer<Integer> container;
    @Before
    public void prepareToTest() {
        container = new DynamicLinkedContainer<>();
    }

    @Test
    public void whenAddThreeElementAndReturnSize3() {
        container.add(1);
        container.add(2);
        container.add(3);
        assertThat(container.getSize(), is(3));
    }

    @Test
    public void whenAddThreeElementAndGetIndex2Then3() {
        container.add(1);
        container.add(2);
        container.add(3);
        assertThat(container.get(2), is(3));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenGetNotExistElementThenInvokeException() {
        container.add(1);
        assertThat(container.get(0), is(1));
        container.get(1);
    }

    @Test
    public void whenHasNextReturnFalse() {
        container.add(1);
        Iterator<Integer> itr = container.iterator();
        assertThat(itr.next(), is(1));
        assertThat(itr.hasNext(), is(false));
    }

    @Test
    public void whenNextReturnExpectedResult() {
        container.add(1);
        container.add(2);
        container.add(3);
        Iterator<Integer> itr = container.iterator();
        assertThat(itr.next(), is(1));
        assertThat(itr.next(), is(2));
        assertThat(itr.next(), is(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmptyContainerAndNextInvokeNoSuchException() {
        Iterator<Integer> itr = container.iterator();
        itr.next();
    }



}