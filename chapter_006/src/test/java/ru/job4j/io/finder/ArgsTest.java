package ru.job4j.io.finder;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ArgsTest {
    private final PrintStream stdOut = System.out;
    private final ByteArrayOutputStream baos = new ByteArrayOutputStream();

    @Before
    public void before() {
        System.setOut(new PrintStream(baos));
    }

    @After
    public void after() {
        System.setOut(stdOut);
    }

    @Test
    public void whenInputValidExpectTrue() {
        Args args = new Args(new String[]{"-d", "C:/Users/User/AppData/Local/Temp/main", "-n", "example.zip", "-f", "-o", "log.txt"});
        assertThat(args.validateKey(), is(true));
    }

    @Test
    public void whenForgetFilenameThenFalse() {
        Args args = new Args(new String[]{"-d", "C:/Users/User/AppData/Local/Temp/main", "-n", "example.zip", "-f"});
        assertThat(args.validateKey(), is(false));
        assertThat(new String(baos.toByteArray()), is("Input fileName for save result search." + System.lineSeparator()));
    }

    @Test
    public void whenForgetFlagThenFalse() {
        Args args = new Args(new String[]{"-d", "C:/Users/User/AppData/Local/Temp/main", "-n", "example.zip", "-o", "log.txt"});
        assertThat(args.validateKey(), is(false));
        assertThat(new String(baos.toByteArray()), is("You forget type flag." + System.lineSeparator()));
    }

    @Test
    public void whenForgetCriteriaThenFalse() {
        Args args = new Args(new String[]{"-d", "C:/Users/User/AppData/Local/Temp/main", "-f", "-o", "log.txt"});
        assertThat(args.validateKey(), is(false));
        assertThat(new String(baos.toByteArray()), is("You forget type criteria for search." + System.lineSeparator()));
    }

    @Test
    public void whenForgetPathThenFalse() {
        Args args = new Args(new String[]{"-n", "example.zip", "-f", "-o", "log.txt"});
        assertThat(args.validateKey(), is(false));
        assertThat(new String(baos.toByteArray()), is("Input name directory and restart for start search." + System.lineSeparator()));
    }
}