package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class EditActionTest {

    @Test
    public void whenItemReplace() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        tracker.add(first);
        List<String> answers = Arrays.asList("Second", first.getId());
        new EditAction(0, "Replace item.", System.out::print).execute(tracker, new StubInput(answers));
        Item second = tracker.findById(first.getId());
        Assert.assertThat(second.getName(), Is.is("Second"));

    }
}
