package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ValidateInputTest {
    private PrintStream stdOut = System.out;
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOut() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOutPut() {
        System.setOut(stdOut);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[]{
            "invalid", "1"}));
        input.askLong("Enter", 1);
        Assert.assertThat(new String(out.toByteArray()), Is.is(String.format("Please enter validate data.%n")));
    }
}
