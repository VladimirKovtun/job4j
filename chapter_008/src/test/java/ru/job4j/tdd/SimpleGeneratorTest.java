package ru.job4j.tdd;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class SimpleGeneratorTest {

    @Test
    public void whenReplaceTwoKey() {
        String template = "I am ${name}, Who are ${subject}?";
        Map<String, String> keyValue = new HashMap<>();
        keyValue.put("name", "Petr");
        keyValue.put("subject", "you");
        SimpleGenerator simpleGenerator = new SimpleGenerator();
        String result = simpleGenerator.generate(template, keyValue);
        assertThat(result, is("I am Petr, Who are you?"));
    }

    @Test
    public void whenReplaceOneKey() {
        String template = " Help, ${sos}, ${sos}, ${sos}";
        Map<String, String> keyValue = new HashMap<>();
        keyValue.put("sos", "Aaa");
        SimpleGenerator simpleGenerator = new SimpleGenerator();
        String result = simpleGenerator.generate(template, keyValue);
        assertThat(result, is(" Help, Aaa, Aaa, Aaa"));
    }

    @Test(expected = RuntimeException.class)
    public void whenNotFoundKeyThenCatchException() {
        String template = "I am ${name}, Who are ${subject}?";
        Map<String, String> keyValue = new HashMap<>();
        keyValue.put("name", "Petr");
        SimpleGenerator simpleGenerator = new SimpleGenerator();
        String result = simpleGenerator.generate(template, keyValue);
        assertThat(result, is("I am Petr, Who are you?"));
    }

    @Test(expected = IllegalStateException.class)
    public void whenLeftUselessKeyThenCatchException() {
        String template = " Help, ${sos}, ${sos}, ${sos}";
        Map<String, String> keyValue = new HashMap<>();
        keyValue.put("sos", "Aaa");
        keyValue.put("name", "Petr");
        SimpleGenerator simpleGenerator = new SimpleGenerator();
        String result = simpleGenerator.generate(template, keyValue);
        assertThat(result, is(" Help, Aaa, Aaa, Aaa"));
    }
}
