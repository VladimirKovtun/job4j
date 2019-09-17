package ru.job4j.condition;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class SqMaxTest {

    @Test
    public void whenFirstMax() {
        int result = SqMax.max(5, 3, 4, 1);
        Assert.assertThat(result, Is.is(5));
    }

    @Test
    public void whenSecondMax() {
        int result = SqMax.max(4, 6, 4, 1);
        Assert.assertThat(result, Is.is(6));
    }

    @Test
    public void whenThirdMax() {
        int result = SqMax.max(5, 3, 7, 2);
        Assert.assertThat(result, Is.is(7));
    }

    @Test
    public void whenForthMax() {
        int result = SqMax.max(3, 5, 2, 9);
        Assert.assertThat(result, Is.is(9));
    }

    @Test
    public void whenNumbersEquals() {
        int result = SqMax.max(5, 5, 5, 5);
        Assert.assertThat(result, Is.is(5));
    }
}
