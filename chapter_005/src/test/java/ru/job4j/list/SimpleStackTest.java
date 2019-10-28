package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleStackTest {
    private SimpleStack<Integer> stack;

    @Before
    public void prepareForTest() {
        stack = new SimpleStack<>();
    }

    @Test
    public void whenAddElementAndChangeStackSize() {
        stack.push(1);
        assertThat(stack.getSize(), is(1));
        stack.push(2);
        assertThat(stack.getSize(), is(2));
        stack.push(3);
        assertThat(stack.getSize(), is(3));
        stack.push(4);
        assertThat(stack.getSize(), is(4));
    }

    @Test
    public void whenAddFourElementAndPollFourElement() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertThat(stack.poll(), is(4));
        assertThat(stack.getSize(), is(3));
        assertThat(stack.poll(), is(3));
        assertThat(stack.getSize(), is(2));
        assertThat(stack.poll(), is(2));
        assertThat(stack.getSize(), is(1));
        assertThat(stack.poll(), is(1));
        assertThat(stack.getSize(), is(0));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenAddOneElementAndPollTwoElementThenEnvokeExcaption() {
        stack.push(1);
        stack.poll();
        stack.poll();
    }

}