package ru.job4j.list;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ConvertMatrix2ListTest {

    @Test
    public void whenMatrix2x2ThenList4() {
        List<Integer> result = new ConvertMatrix2List().toList(new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        });
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(result, Is.is(expect));
    }

}