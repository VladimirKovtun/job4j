package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class CreateActionTest {

    @Test
    public void whenItemCreate() {
        String[] answer = {"Test"};
        Input input = new StubInput(answer);
        Tracker tracker = new Tracker();
        new CreateAction(0, "Create item.").execute(tracker, input);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Test");
        Assert.assertThat(created.getName(), Is.is(expected.getName()));
    }
}
