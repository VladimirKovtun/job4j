package ru.job4j.array;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class FindLoopTest {

    @Test
    public void whenArrayHas5Then0(){
        FindLoop findLoop = new FindLoop();
        int[] input = {5, 10, 3};
        int value = 5;
        int rst = findLoop.indexOf(input, value);
        Assert.assertThat(rst, Is.is(0));
    }

    @Test
    public void whenArrayHas25ThenMinus1(){
        FindLoop findLoop = new FindLoop();
        int[] input = {5, 10, 3};
        int value = 25;
        int rst = findLoop.indexOf(input, value);
        Assert.assertThat(rst, Is.is(-1));
    }
}
