package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FindByIdActionTest {

    @Test
    public void whenSeekById() {
        Tracker tracker = new Tracker();
        Item item = new Item("Test");
        tracker.add(item);
        String[] answers = {item.getId()};
        PrintStream stdOut = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new FindByIdAction().execute(tracker, new StubInput(answers));
        Assert.assertThat(new String(out.toByteArray()),
                          Is.is("Item ID " + item.getId() + ", Item name " + item.getName()));
        System.setOut(stdOut);
    }
}
