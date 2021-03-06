package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CreateActionTest {

    @Test
    public void whenItemCreate() {
        List<String> answer = Arrays.asList("Test", "Description");
        Input input = new StubInput(answer);
        Tracker tracker = new Tracker();
        new CreateAction(0, "Create item.").execute(tracker, input);
        Item created = tracker.findAll().get(0);
        Item expected = new Item("Test", "Description");
        Assert.assertThat(created.getName(), Is.is(expected.getName()));
    }
}
