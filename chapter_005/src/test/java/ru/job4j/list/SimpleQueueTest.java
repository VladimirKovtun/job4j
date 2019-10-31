package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleQueueTest {
    public SimpleQueue<Integer> queue;

    @Before
    public void prepareForTest() {
        queue = new SimpleQueue<>();
    }

    @Test
    public void whenPushInARowAndSamePoll() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
        assertThat(queue.poll(), is(3));
        assertThat(queue.poll(), is(4));
    }

    @Test
    public void whenPushedAndPolledOneAfterAnother() {
        queue.push(1);
        assertThat(queue.poll(), is(1));
        queue.push(2);
        assertThat(queue.poll(), is(2));
        queue.push(3);
        assertThat(queue.poll(), is(3));
        queue.push(4);
        assertThat(queue.poll(), is(4));
    }

    @Test()
    public void whenAfterPushAndPollQueue() {
        queue.push(1);
        queue.push(2);
        assertThat(queue.poll(), is(1));
        assertThat(queue.poll(), is(2));
        queue.push(4);
        assertThat(queue.poll(), is(4));
    }

}