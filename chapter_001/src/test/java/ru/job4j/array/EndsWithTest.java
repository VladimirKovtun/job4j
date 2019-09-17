package ru.job4j.array;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class EndsWithTest {

    @Test
    public void whenWordEndsWithPrefixThenTrue() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] pref = {'l', 'o'};
        boolean result = EndsWith.endsWith(word, pref);
        Assert.assertThat(result, Is.is(true));
    }

    @Test
    public void whenWordNotEndsWithPrefixThenTrue() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] pref = {'l', 'a'};
        boolean result = EndsWith.endsWith(word, pref);
        Assert.assertThat(result, Is.is(false));
    }
}
