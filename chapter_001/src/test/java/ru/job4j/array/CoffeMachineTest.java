package ru.job4j.array;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class CoffeMachineTest {

    @Test
    public void when60RubAndCoffee35ThenChangeIsAll5Rub() {
        int[] result = CoffeMachine.changes(60, 35);
        int[] expect = {5, 5, 5, 5, 5};
        Assert.assertThat(result, Is.is(expect));
    }

    @Test
    public void when60RubAndCoffee34ThenChangeIsOne1RubAndFive5Rub() {
        int[] result = CoffeMachine.changes(60, 34);
        int[] expect = {1, 5, 5, 5, 5, 5};
        Assert.assertThat(result, Is.is(expect));
    }

    @Test
    public void when60RubAndCoffee33ThenChangeIsOne2RubAndFive5Rub() {
        int[] result = CoffeMachine.changes(60, 33);
        int[] expect = {2, 5, 5, 5, 5, 5};
        Assert.assertThat(result, Is.is(expect));
    }

    @Test
    public void when60RubAndCoffee32ThenChangeIsOne1RubAndOne2RubAndFive5Rub() {
        int[] result = CoffeMachine.changes(60, 32);
        int[] expect = {1, 2, 5, 5, 5, 5, 5};
        Assert.assertThat(result, Is.is(expect));
    }

    @Test
    public void when60RubAndCoffee31ThenChangeIsTwo2RubAndFive5Rub() {
        int[] result = CoffeMachine.changes(60, 31);
        int[] expect = {2, 2, 5, 5, 5, 5, 5};
        Assert.assertThat(result, Is.is(expect));
    }

    @Test
    public void when30RubAndCoffee34ThenChangeIsOne1RubAndFive5Rub() {
        int[] result = CoffeMachine.changes(30, 34);
        int[] expect = {-1};
        Assert.assertThat(result, Is.is(expect));
    }
}
