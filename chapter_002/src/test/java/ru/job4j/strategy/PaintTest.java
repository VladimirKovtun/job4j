package ru.job4j.strategy;

import org.hamcrest.core.Is;
import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PaintTest {

    @Test
    public void whenDrawSquare() {
        PrintStream stdOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        Assert.assertThat(new String(out.toByteArray()), Is.is(
                new StringBuilder().append(" ______\n")
                                   .append("|      |\n")
                                   .append("|      |\n")
                                   .append("|______|\n")
                                   .append(System.lineSeparator())
                                   .toString())
        );
        System.setOut(stdOut);
    }
}
