package ru.job4j.array;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class SquareTest {

    @Test
    public void whenBound3(){
        int bound = 3;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expected = {1, 4, 9};
        Assert.assertThat(rst, Is.is(expected));
    }

    @Test
    public void whenBound5(){
        int bound = 5;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expected = {1, 4, 9, 16, 25};
        Assert.assertThat(rst, Is.is(expected));
    }

    @Test
    public void whenBound1(){
        int bound = 1;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expected = {1};
        Assert.assertThat(rst, Is.is(expected));
    }
}
