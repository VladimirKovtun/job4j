package ru.job4j;


import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayStreamTest {

    @Test
    public void whenStreamSum() {
        int result = new ArrayStream().arrayCombo(new int[]{1, 2, 5, 6, 2});
        assertThat(result, Is.is(44));
    }

}