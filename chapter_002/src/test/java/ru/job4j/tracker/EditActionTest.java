package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class EditActionTest {

    @Test
    public void whenItemReplace() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        tracker.add(first);
        String[] answers = {"Second", first.getId()};
        new EditAction().execute(tracker, new StubInput(answers));
        Item second = tracker.findById(first.getId());
        Assert.assertThat(second.getName(), Is.is("Second"));

    }
}
