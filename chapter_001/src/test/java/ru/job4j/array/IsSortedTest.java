package ru.job4j.array;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class IsSortedTest {

    @Test
    public void whenArrayRandomNotSortedThenFalse() {
        int[] input = {2, 1, 4, 1, 6};
        boolean result = IsSorted.isSorted(input);
        Assert.assertThat(result, Is.is(false));
    }

    @Test
    public void whenArrayStartNotSortedThenFalse() {
        int[] input = {2, 1, 3, 4, 5};
        boolean result = IsSorted.isSorted(input);
        Assert.assertThat(result, Is.is(false));
    }

    @Test
    public void whenArrayEndNotSortedThenFalse() {
        int[] input = {0, 1, 4, 5, 4};
        boolean result = IsSorted.isSorted(input);
        Assert.assertThat(result, Is.is(false));
    }

    @Test
    public void whenArraySortedThenTrue() {
        int[] input = {0, 2, 5, 7, 9};
        boolean result = IsSorted.isSorted(input);
        Assert.assertThat(result, Is.is(true));
    }
}
