package ru.job4j.loop;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class FactorialTest {

    @Test
    public void whenCalculateFactorialForFiveThenOneHundredTwenty(){
        Factorial factorial = new Factorial();
        int expect = factorial.calc(5);
        Assert.assertThat(expect, Is.is(120));
    }

    @Test
    public void whenCalculateFactorialForZeroThenOne(){
        Factorial factorial = new Factorial();
        int expect = factorial.calc(0);
        Assert.assertThat(expect, Is.is(1));
    }

    @Test
    public void whenCalculateFactorialForOneThenOne(){
        Factorial factorial = new Factorial();
        int expect = factorial.calc(1);
        Assert.assertThat(expect, Is.is(1));
    }
}
