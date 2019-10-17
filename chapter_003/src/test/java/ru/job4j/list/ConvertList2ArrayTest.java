package ru.job4j.list;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ConvertList2ArrayTest {

    @Test
    public void when7ElementsThen9() {
        ConvertList list = new ConvertList();
        int[][] result = list.toArray(
                List.of(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, Is.is(expect));
    }

    @Test
    public void when9ElementThen12() {
        ConvertList convert = new ConvertList();
        int[][] result = convert.toArray(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9), 4);
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {0, 0, 0}
        };
        assertThat(result, Is.is(expect));
    }

    @Test
    public void whenListMassToListOfInteger() {
        List<int[]> arrays = new ArrayList<>(List.of(
                new int[]{1, 2}, new int[]{3, 4, 5, 6}));
        List<Integer> result = new ConvertList().convert(arrays);
        assertThat(result, Is.is(List.of(1, 2, 3, 4, 5, 6)));

    }
}