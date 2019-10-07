package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DeleteActionTest {

    @Test
    public void whenItemDelete() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        List<String> answers = Arrays.asList(item.getId());
        new DeleteAction(0, "Delete item.").execute(tracker, new StubInput(answers));
        List<Item> newItems = tracker.findByName("new item");
        Assert.assertNull(newItems);
    }
}
