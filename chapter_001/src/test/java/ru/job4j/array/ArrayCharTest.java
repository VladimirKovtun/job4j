package ru.job4j.array;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class ArrayCharTest {

    @Test
    public void whenStartsWithPrefixThenTrue(){
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] pref = {'H', 'e'};
        boolean rst = ArrayChar.startsW(word, pref);
        Assert.assertThat(rst, Is.is(true));
    }

    @Test
    public void whenNotStartsWithPrefixThenTrue(){
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] pref = {'H', 'i'};
        boolean rst = ArrayChar.startsW(word, pref);
        Assert.assertThat(rst, Is.is(false));
    }
}
