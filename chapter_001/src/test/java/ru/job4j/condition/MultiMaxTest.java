package ru.job4j.condition;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class MultiMaxTest {

    @Test
    public void whenSecondMax(){
        MultiMax check = new MultiMax();
        int result = check.max(1,5,3);
        Assert.assertThat(result, Is.is(5));
    }

    @Test
    public void whenFirstMax(){
        MultiMax check = new MultiMax();
        int result = check.max(5,3,2);
        Assert.assertThat(result, Is.is(5));
    }

    @Test
    public void whenThirdMax(){
        MultiMax check = new MultiMax();
        int result = check.max(1,5,8);
        Assert.assertThat(result, Is.is(8));
    }

    @Test
    public void whenNumbersEquals(){
        MultiMax check = new MultiMax();
        int result = check.max(5,5,5);
        Assert.assertThat(result, Is.is(5));
    }
}
