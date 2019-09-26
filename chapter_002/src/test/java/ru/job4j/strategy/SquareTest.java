package ru.job4j.strategy;

import org.hamcrest.core.Is;
import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.junit.Test;

public class SquareTest {

    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        Assert.assertThat(square.draw(), Is.is(
                new StringBuilder().append(" ______\n")
                                   .append("|      |\n")
                                   .append("|      |\n")
                                   .append("|______|\n")
                                   .toString()));
    }
}
