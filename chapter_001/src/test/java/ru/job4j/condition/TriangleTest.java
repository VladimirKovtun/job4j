package ru.job4j.condition;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

    @Test
    public void whenExist(){
        boolean result = Triangle.exist(2.0, 2.0, 2.0);
        Assert.assertThat(result, Is.is(true));
    }

    @Test
    public void whenNotExist(){
        boolean result = Triangle.exist(1.0,1.0,3.0);
        Assert.assertThat(result, Is.is(false));
    }
}
