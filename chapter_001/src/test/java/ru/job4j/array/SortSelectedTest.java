package ru.job4j.array;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class SortSelectedTest {

    @Test
    public void whenSort3(){
        int[] input = {4, 2, 3};
        int[] result = SortSelected.sort(input);
        int[] expect = {2, 3, 4};
        Assert.assertThat(result, Is.is(expect));
    }

    @Test
    public void whenSort5(){
        int[] input = {4, 7, 3, 1, 6};
        int[] result = SortSelected.sort(input);
        int[] expect = {1, 3, 4, 6, 7};
        Assert.assertThat(result, Is.is(expect));
    }
}
