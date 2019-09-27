package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

public class DeleteActionTest {

    @Test
    public void whenItemDelete() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {item.getId()};
        new DeleteAction().execute(tracker, new StubInput(answers));
        Item[] newItems = tracker.findByName("new item");
        Assert.assertNull(newItems);
    }
}
