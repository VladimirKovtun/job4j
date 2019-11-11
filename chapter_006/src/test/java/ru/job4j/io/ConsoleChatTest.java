package ru.job4j.io;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConsoleChatTest {
    private final PrintStream stdOut = System.out;
    private final InputStream stdIn = System.in;
    private final byte[] bytes = "привет\r\nзакончить".getBytes();
    private final ByteArrayInputStream in = new ByteArrayInputStream(bytes);
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOut() {
        System.setIn(in);
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOutput() {
        System.setIn(stdIn);
        System.setOut(stdOut);
    }

    @Test
    public void when() {
        new ConsoleChat("./data/dialog.txt", "./data/phrase.txt").init();
        assertThat(new String(out.toByteArray()), is("Bot: Привет!\r\n"));
    }
}