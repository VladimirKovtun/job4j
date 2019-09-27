package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FindByIdActionTest {
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
    public void whenSeekById() {
        Tracker tracker = new Tracker();
        Item item = new Item("Test");
        tracker.add(item);
        String[] answers = {item.getId()};
        new FindByIdAction().execute(tracker, new StubInput(answers));
        Assert.assertThat(new String(out.toByteArray()),
                          Is.is("Item ID " + item.getId() + ", Item name " + item.getName()));
    }
}
