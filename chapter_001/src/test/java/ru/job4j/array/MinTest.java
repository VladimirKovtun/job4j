package ru.job4j.array;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class MinTest {

    @Test
    public void whenMinLast() {
        int[] array = {3, 5, 4, 7, 2};
        int result = Min.findMin(array);
        Assert.assertThat(result, Is.is(2));
    }

    @Test
    public void whenMinMiddle() {
        int[] array = {3, 5, 1, 7, 2};
        int result = Min.findMin(array);
        Assert.assertThat(result, Is.is(1));
    }

    @Test
    public void whenMinFirst() {
        int[] array = {0, 5, 1, 7, 2};
        int result = Min.findMin(array);
        Assert.assertThat(result, Is.is(0));
    }
}
