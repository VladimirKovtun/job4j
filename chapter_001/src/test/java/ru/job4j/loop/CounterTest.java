package ru.job4j.loop;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class CounterTest {

    @Test
    public  void whenSummEvenNumbersFromOneToTenThenThirty() {
        Counter counter = new Counter();
        int expected = counter.add(0, 10);
        Assert.assertThat(expected, Is.is(30));
    }
}
