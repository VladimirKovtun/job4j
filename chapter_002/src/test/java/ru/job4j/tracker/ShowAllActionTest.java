package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class ShowAllActionTest {

    @Test
    public void whenShowAll() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        PrintStream stdOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new ShowAllAction().execute(tracker, new StubInput(new String[0]));
        Assert.assertThat(new String(out.toByteArray()), Is.is(Arrays.toString(tracker.findAll())));
        System.setOut(stdOut);
    }
}
