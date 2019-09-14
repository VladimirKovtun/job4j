package ru.job4j.loop;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class MortgageTest {

    @Test
    public void when1Year(){
        Mortgage mortgage = new Mortgage();
        int result = mortgage.year(100, 100, 1);
        Assert.assertThat(result, Is.is(1));
    }

    @Test
    public void when2Year(){
        Mortgage mortgage = new Mortgage();
        int result = mortgage.year(100, 100, 50);
        Assert.assertThat(result, Is.is(2));
    }
}
