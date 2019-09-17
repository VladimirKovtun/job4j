package ru.job4j.array;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class CheckTest {

    @Test
    public void whenDataMonoTrueThenTrue() {
        Check check = new Check();
        boolean[] input = {true, true, true, true};
        boolean rst = check.mono(input);
        Assert.assertThat(rst, Is.is(true));
    }

    @Test
    public void whenDataNotMonoTrueThenTrue() {
        Check check = new Check();
        boolean[] input = {false, false, true, true};
        boolean rst = check.mono(input);
        Assert.assertThat(rst, Is.is(false));
    }
}
