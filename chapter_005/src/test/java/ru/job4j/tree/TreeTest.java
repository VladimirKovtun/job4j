package ru.job4j.tree;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TreeTest {

    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(new Node<>(1));
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void whenCreateNewRoot() {
        Tree<Integer> tree = new Tree<>(new Node<>(1));
        tree.add(1, 2);
        tree.add(7, 3);
        tree.add(3, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(3).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(new Node<>(1));
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIteratorReturnExpect() {
        Tree<Integer> tree = new Tree<>(new Node<>(1));
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        Iterator<Integer> itr = tree.iterator();
        assertThat(itr.next(), is(1));
        assertThat(itr.next(), is(2));
        assertThat(itr.next(), is(3));
        assertThat(itr.next(), is(4));
        assertThat(itr.next(), is(5));
        assertThat(itr.next(), is(6));
        assertThat(itr.hasNext(), is(false));
        itr.next();
    }

    @Test
    public void when3ChildrenThenTreeNotBinary() {
        Tree<Integer> tree = new Tree<>(new Node<>(1));
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.isBinary(),
                is(false)
        );
    }

    @Test
    public void when2ChildrenThenTreeIsBinary() {
        Tree<Integer> tree = new Tree<>(new Node<>(1));
        tree.add(1, 2);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.isBinary(),
                is(true)
        );
    }
}