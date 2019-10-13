package ru.job4j;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DiapasonTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = Diapason.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenSquareResults() {
        List<Double> result = Diapason.diapason(5, 8, x -> x * x + 2 * x + 1);
        List<Double> expected = Arrays.asList(36D, 49D, 64D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenLogResults() {
        List<Double> result = Diapason.diapason(8, 9, x -> (Math.log(x) / Math.log(2) + x));
        List<Double> expected = Arrays.asList(11D);
        assertThat(result, is(expected));
    }
}