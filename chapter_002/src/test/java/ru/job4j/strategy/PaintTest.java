package ru.job4j.strategy;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PaintTest {
    private final PrintStream stdOut = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOut() {
        System.setOut(new PrintStream(out));
    }
    @After
    public void backOutput() {
        System.setOut(stdOut);
    }

    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        Assert.assertThat(new String(out.toByteArray()), Is.is(
                new StringBuilder().append(" ______\n")
                                   .append("|      |\n")
                                   .append("|      |\n")
                                   .append("|______|\n")
                                   .append(System.lineSeparator())
                                   .toString())
        );
    }

    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle());
        Assert.assertThat(new String(out.toByteArray()), Is.is(
                new StringBuilder().append("   /\\\n")
                                   .append("  /  \\\n")
                                   .append(" /    \\\n")
                                   .append("/______\\\n")
                                   .append(System.lineSeparator())
                                   .toString())
        );
    }
}
