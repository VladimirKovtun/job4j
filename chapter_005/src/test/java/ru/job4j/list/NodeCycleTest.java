package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NodeCycleTest {
    NodeCycle<Integer> first = new NodeCycle<>(1);
    NodeCycle<Integer> two = new NodeCycle<>(2);
    NodeCycle<Integer> third = new NodeCycle<>(3);
    NodeCycle<Integer> four = new NodeCycle<>(4);

    @Test
    public void whenFourNextFirstThenTrue() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;

        assertThat(NodeCycle.hasCycle(first), is(true));
    }

    @Test
    public void whenThirdNextTwoThenTrue() {
        first.next = two;
        two.next = third;
        third.next = two;
        four.next = null;

        assertThat(NodeCycle.hasCycle(first), is(true));
    }

    @Test
    public void whenListNasNotCycleThenFalse() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;

        assertThat(NodeCycle.hasCycle(first), is(false));
    }
}