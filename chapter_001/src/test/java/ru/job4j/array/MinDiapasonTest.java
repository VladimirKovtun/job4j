package ru.job4j.array;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class MinDiapasonTest {

    @Test
    public void whenMinInSetRangeLast(){
        int[] array = {3, 4, 2, 6, 2, 5, 1, 2};
        int start = 2;
        int finish = 6;
        int result = MinDiapason.findMin(array, start, finish);
        Assert.assertThat(result, Is.is(1));
    }

    @Test
    public void whenMinInSetRangeMiddle(){
        int[] array = {3, 4, 2, 6, 2, 5, 1, 2};
        int start = 1;
        int finish = 3;
        int result = MinDiapason.findMin(array, start, finish);
        Assert.assertThat(result, Is.is(2));
    }

    @Test
    public void whenMinInSetRangeFirst(){
        int[] array = {0, 4, 2, 6, 2, 5, 1, 2};
        int start = 0;
        int finish = 6;
        int result = MinDiapason.findMin(array, start, finish);
        Assert.assertThat(result, Is.is(0));
    }
}
