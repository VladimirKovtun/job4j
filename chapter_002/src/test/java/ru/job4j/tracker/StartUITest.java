package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class StartUITest {

    @Test
    public void whenItemAdd() {
        String[] answer = {"Test"};
        StubInput stubInput = new StubInput(answer);
        Tracker tracker = new Tracker();
        StartUI.createItem(stubInput, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Test");
        Assert.assertThat(created.getName(), Is.is(expected.getName()));
    }
}
