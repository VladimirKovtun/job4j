package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSetTest {
    private SimpleSet<String> set;
    private Iterator<String> itr;

    @Before
    public void prepareForTest() {
        set = new SimpleSet<>();
    }

    @Test
    public void whenAddFourElemeneWithOneDuplicateThenReturnSizeThree() {
        set.add("sorry");
        set.add("orry");
        set.add("sorry");
        set.add("rry");
        assertThat(set.getSize(), is(3));
    }

    @Test
    public void whenIteratorReturnOnlyUniqueElement() {
        set.add("sorry");
        set.add("orry");
        set.add("sorry");
        set.add("rry");
        set.add("sorry");
        set.add("ry");
        itr = set.iterator();
        assertThat(itr.next(), is("sorry"));
        assertThat(itr.next(), is("orry"));
        assertThat(itr.next(), is("rry"));
        assertThat(itr.next(), is("ry"));
    }
}