package ru.job4j.loop;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class PrimeNumberTest {

    @Test
    public void when5(){
        PrimeNumber primeNumber = new PrimeNumber();
        int result = primeNumber.calc(5);
        Assert.assertThat(result, Is.is(3));
    }

    @Test
    public void when11(){
        PrimeNumber primeNumber = new PrimeNumber();
        int result = primeNumber.calc(11);
        Assert.assertThat(result, Is.is(5));
    }

    @Test
    public void when1(){
        PrimeNumber primeNumber = new PrimeNumber();
        int result = primeNumber.calc(2);
        Assert.assertThat(result, Is.is(1));
    }
}
