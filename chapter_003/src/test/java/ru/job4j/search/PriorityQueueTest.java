package ru.job4j.search;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

public class PriorityQueueTest {

    @Test
    public void whenTakePriorityTask() {
        var queue = new PriorityQueue();
        queue.put(new Task("Drink Tea", 3));
        queue.put(new Task("Watch TV", 3));
        queue.put(new Task("Write code", 1));
        queue.put(new Task("Sleep", 5));
        var task = queue.take();
        assertThat(task.getDesc(), Is.is("Write code"));
    }

}