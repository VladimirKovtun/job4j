package ru.job4j.calculate;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalculateTest {

    @Test
    public void whenTwoNumbersAddition() {
        assertThat(new Calculate().add(2, 5), is(7.0));
    }

    @Test
    public void whenTwoNumbersSubtraction() {
        assertThat(new Calculate().subTract(10, 5), is(5.0));
    }

    @Test
    public void whenTwoNumbersDivision() {
        assertThat(new Calculate().divide(15, 5), is(3.0));
    }

    @Test
    public void whenTwoNumbersMultiplication() {
        assertThat(new Calculate().multiply(3, 5), is(15.0));
    }

}