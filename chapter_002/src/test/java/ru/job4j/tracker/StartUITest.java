package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class StartUITest {

    /*@Test
    public void whenItemAdd() {
        String[] answer = {"Test"};
        StubInput stubInput = new StubInput(answer);
        Tracker tracker = new Tracker();
        StartUI.createItem(stubInput, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Test");
        Assert.assertThat(created.getName(), Is.is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {"replaced item", item.getId()};
        StartUI.editItem(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        Assert.assertThat(replaced.getName(), Is.is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {item.getId()};
        StartUI.deleteItem(new StubInput(answers), tracker);
        Item[] newItems = tracker.findByName("new item");
        Assert.assertNull(newItems);
    }*/
}
