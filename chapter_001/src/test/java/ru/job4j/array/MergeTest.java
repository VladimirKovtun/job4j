package ru.job4j.array;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class MergeTest {

    @Test
    public void whenMerge2Array() {
        int[] first = {5, 3, 2, 8};
        int[] second = {1, 4, 9};
        int[] expect = {5, 3, 2, 8, 1, 4, 9};
        int[] result = Merge.merge(first, second);
        Assert.assertThat(result, Is.is(expect));
    }
    @Test
    public void whenMerge2ArrayAgain() {
        int[] first = {5, 1, 2, 8, 1, 4};
        int[] second = {1, 4};
        int[] expect = {5, 1, 2, 8, 1, 4, 1, 4};
        int[] result = Merge.merge(first, second);
        Assert.assertThat(result, Is.is(expect));
    }
    @Test
    public void whenMerge2ArrayAndAgain() {
        int[] first = {8, 1, 4};
        int[] second = {1, 4, 2, 4, 5};
        int[] expect = {8, 1, 4, 1, 4, 2, 4, 5};
        int[] result = Merge.merge(first, second);
        Assert.assertThat(result, Is.is(expect));
    }
}
