package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class FindByNameActionTest {
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
    public void whenSeekByName() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("Second"));
        String[] answers = {"Second"};
        new FindByNameAction().execute(tracker, new StubInput(answers));
        Assert.assertThat(new String(out.toByteArray()), Is.is(Arrays.toString(tracker.findByName("Second"))));
    }
}
