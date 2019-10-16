package ru.job4j;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ConvertTest {

    @Test
    public void whenConvert() {
        List<Integer> result = new Convert().matrixToList(new Integer[][] {
                {2, 3, 5, 6},
                {1, 3, 2, 5},
                {2, 4, 6, 2}});
        assertThat(result.toString(), Is.is(List.of(2, 3, 5, 6, 1, 3, 2, 5, 2, 4, 6, 2).toString()));
    }

}