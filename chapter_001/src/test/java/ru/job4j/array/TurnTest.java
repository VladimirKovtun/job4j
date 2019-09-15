package ru.job4j.array;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class TurnTest {

    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedAway(){
        Turn turn = new Turn();
        int[] input = {4, 1, 6, 2};
        int[] expect = {2, 6, 1, 4};
        int[] rst = turn.back(input);
        Assert.assertThat(rst, Is.is(expect));
    }

    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedAway(){
        Turn turn = new Turn();
        int[] input = {2, 5, 3, 6, 2};
        int[] expect = {2, 6, 3, 5, 2};
        int[] rst = turn.back(input);
        Assert.assertThat(rst, Is.is(expect));
    }
}
