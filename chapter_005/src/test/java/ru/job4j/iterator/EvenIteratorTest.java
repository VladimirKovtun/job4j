package ru.job4j.iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class EvenIteratorTest {

    @Test(expected = NoSuchElementException.class)
    public void shouldReturnEvenNumbersSequentially () {
        EvenIterator et = new EvenIterator(new int[]{1, 2, 3, 4, 5, 6, 7});
        Iterator it = et.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder () {
        EvenIterator et = new EvenIterator(new int[]{1, 2, 3, 4, 5, 6, 7});
        Iterator it = et.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(6));
    }

    @Test
    public void  shouldReturnFalseIfNoAnyEvenNumbers(){
        EvenIterator et = new EvenIterator(new int[]{1});
        Iterator it = et.iterator();
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void allNumbersAreEven(){
        EvenIterator et = new EvenIterator(new int[]{2,4,6,8});
        Iterator it = et.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(8));
    }

}