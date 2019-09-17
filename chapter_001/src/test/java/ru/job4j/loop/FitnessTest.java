package ru.job4j.loop;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class FitnessTest {

    @Test
    public void whenIvanGreatNik() {
        Fitness fitness = new Fitness();
        int expected = fitness.calc(95, 90);
        Assert.assertThat(expected, Is.is(0));
    }

    @Test
    public void whenIvanLessByOneNik() {
        Fitness fitness = new Fitness();
        int expected = fitness.calc(90, 95);
        Assert.assertThat(expected, Is.is(1));
    }

    @Test
    public void whenIvanLessByTwoNik() {
        Fitness fitness = new Fitness();
        int expected = fitness.calc(50, 90);
        Assert.assertThat(expected, Is.is(2));
    }
}
