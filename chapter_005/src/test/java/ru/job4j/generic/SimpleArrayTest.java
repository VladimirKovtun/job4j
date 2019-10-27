package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void whenAddHello() {
        SimpleArray<String> arrayString = new SimpleArray<>(1);
        arrayString.add("Hello");
        assertThat(arrayString.get(0), is("Hello"));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void invocationOfAddElementShouldThrowArrayIndexOutOfBoundsException() {
        SimpleArray<String> arrayString = new SimpleArray<>(1);
        arrayString.add("Hello");
        arrayString.add("Hello");
    }

    @Test
    public void whenSetReplaceElementOnZeroPosition() {
        SimpleArray<String> arrayString = new SimpleArray<>(1);
        arrayString.add("Hello");
        arrayString.set(0, "World");
        assertThat(arrayString.get(0), is("World"));
    }

    @Test
    public void whenInvocationGetReturnSecondElement() {
        SimpleArray<String> arrayString = new SimpleArray<>(2);
        arrayString.add("Hello");
        arrayString.add("World");
        String result = arrayString.get(1);
        assertThat(result, is("World"));
    }

    @Test(expected = NoSuchElementException.class)
    public void invocationOfNextMethodShouldThrowNoSuchElementException() {
        SimpleArray<Integer> arrayString = new SimpleArray<>(3);
        arrayString.add(1);
        arrayString.add(2);
        arrayString.add(3);
        Iterator<Integer> iterator = arrayString.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
    }

    @Test()
    public void whenNextReturnSingleElement() {
        SimpleArray<Integer> arrayString = new SimpleArray<>(1);
        arrayString.add(1);
        Iterator<Integer> iterator = arrayString.iterator();
        Integer result = iterator.next();
        assertThat(result, is(1));
    }

    @Test()
    public void hasNextShouldReturnFalse() {
        SimpleArray<Integer> arrayString = new SimpleArray<>(1);
        arrayString.add(1);
        Iterator<Integer> iterator = arrayString.iterator();
        iterator.next();
        boolean result = iterator.hasNext();
        assertThat(result, is(false));
    }

    @Test()
    public void hasNextShouldReturnTrue() {
        SimpleArray<Integer> arrayString = new SimpleArray<>(1);
        arrayString.add(1);
        Iterator<Integer> iterator = arrayString.iterator();
        boolean result = iterator.hasNext();
        assertThat(result, is(true));
    }

    @Test
    public void whenRemoved3ThenOnThisPosition4() {
        SimpleArray<Integer> arrayString = new SimpleArray<>(4);
        arrayString.add(1);
        arrayString.add(2);
        arrayString.add(3);
        arrayString.add(4);
        arrayString.remove(2);
        assertThat(arrayString.get(2), is(4));
    }

    @Test
    public void whenRemovedSingleElementThenShouldReturnNull() {
        SimpleArray<Integer> arrayString = new SimpleArray<>(1);
        arrayString.add(1);
        arrayString.remove(0);
        assertNull(arrayString.get(0));
    }

}