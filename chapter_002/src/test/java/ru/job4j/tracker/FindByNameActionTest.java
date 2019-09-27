package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class FindByNameActionTest {

    @Test
    public void whenSeekByName() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("Second"));
        PrintStream stdOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        String[] answers = {"Second"};
        new FindByNameAction().execute(tracker, new StubInput(answers));
        Assert.assertThat(new String(out.toByteArray()), Is.is(Arrays.toString(tracker.findByName("Second"))));
        System.setOut(stdOut);
    }
}
