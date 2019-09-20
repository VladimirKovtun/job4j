package ru.job4j.condition;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class MaxTest {

    @Test
    public void whenLeftMax() {
        Assert.assertThat(Max.max(5, 2), Is.is(5));
    }

    @Test
    public void whenRightMax() {
        Assert.assertThat(Max.max(2, 5), Is.is(5));
    }

    @Test
    public void whenLeftEqualsRight() {
        Assert.assertThat(Max.max(5, 5), Is.is(5));
    }

    @Test
    public void whenThirdMax() {
        Assert.assertThat(Max.max(2, 5, 7), Is.is(7));
    }

    @Test
    public void whenSecongMax() {
        Assert.assertThat(Max.max(2, 19, 7), Is.is(19));
    }

    @Test
    public void whenForthMax() {
        Assert.assertThat(Max.max(2, 5, 7, 9), Is.is(9));
    }

    @Test
    public void whenFirstMax() {
        Assert.assertThat(Max.max(8, 5, 7, 2), Is.is(8));
    }
}
