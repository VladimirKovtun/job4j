package ru.job4j.condition;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class MaxTest {

    @Test
    public void whenLeftMax(){
        Assert.assertThat(Max.max(5,2), Is.is(5));
    }

    @Test
    public void whenRightMax(){
        Assert.assertThat(Max.max(2,5), Is.is(5));
    }

    @Test
    public void whenLeftEqualsRight(){
        Assert.assertThat(Max.max(5,5), Is.is(5));
    }
}
