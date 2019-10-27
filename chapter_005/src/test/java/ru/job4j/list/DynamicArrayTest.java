package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DynamicArrayTest {
    private DynamicArray<Integer> array;

    @Before
    public void prepareForTest() {
        array = new DynamicArray<>(1);
    }

    @Test
    public void whenAddFourElementThenListSizeExtendTo4() {
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        assertThat(array.getSize(), is(4));
    }

    @Test
    public void whenAdd4ElementAndGet2Then3() {
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        assertThat(array.get(2), is(3));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenAddElementAndInvokeConcurrentException() {
        array.add(1);
        for (Integer i : array) {
            array.add(4);
        }
    }

    @Test
    public void whenListIsEmptyThenHasNextFalse() {
        assertThat(array.iterator().hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIteratorInvokeNoSuchException() {
        array.add(1);
        Iterator<Integer> itr = array.iterator();
        itr.next();
        itr.next();
    }

    @Test()
    public void whenIteratorReturnOne() {
        array.add(1);
        assertThat(array.iterator().next(), is(1));
    }

}