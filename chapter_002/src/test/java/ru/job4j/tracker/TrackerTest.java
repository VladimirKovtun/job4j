package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSomeItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        Assert.assertThat(result.getName(), Is.is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1");
        tracker.add(previous);
        Item next = new Item("test2");
        tracker.replace(previous.getId(), next);
        Assert.assertThat(tracker.findById(previous.getId()).getName(), Is.is("test2"));
    }

    @Test
    public void whenReplaceItemNullThenReturnFalse() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1");
        tracker.add(previous);
        Item next = null;
        boolean result = tracker.replace(previous.getId(), next);
        Assert.assertThat(result, Is.is(false));
    }

    @Test
    public void whenFirstDeleteThenSecond() {
        Tracker tracker = new Tracker();
        Item first = new Item("first");
        tracker.add(first);
        Item second = new Item("second");
        tracker.add(second);
        tracker.delete(first.getId());
        Item[] expect = {second};
        Assert.assertThat(tracker.findAll(), Is.is(expect));
    }

    @Test
    public void whenSecondDeleteThenFirstAndThird() {
        Tracker tracker = new Tracker();
        Item first = new Item("first");
        tracker.add(first);
        Item second = new Item("second");
        tracker.add(second);
        Item third = new Item("third");
        tracker.add(third);
        tracker.delete(second.getId());
        Item[] expect = {first, third};
        Assert.assertThat(tracker.findAll(), Is.is(expect));
    }

    @Test
    public void whenThirdItemsFindAll() {
        Tracker tracker = new Tracker();
        Item first = new Item("first");
        tracker.add(first);
        Item second = new Item("second");
        tracker.add(second);
        Item third = new Item("third");
        tracker.add(third);
        Item[] expect = {first, second, third};
        Assert.assertThat(tracker.findAll(), Is.is(expect));
    }

    @Test
    public void whenTwoItemSameNameThenFindTwo() {
        Tracker tracker = new Tracker();
        Item first = new Item("first");
        tracker.add(first);
        Item second = new Item("second");
        tracker.add(second);
        Item third = new Item("second");
        tracker.add(third);
        Item[] expect = {second, third};
        Assert.assertThat(tracker.findByName("second"), Is.is(expect));
    }

    @Test
    public void whenNoMatches() {
        Tracker tracker = new Tracker();
        Item first = new Item("first");
        tracker.add(first);
        Item second = new Item("second");
        tracker.add(second);
        Item third = new Item("third");
        tracker.add(third);
        Assert.assertNull(tracker.findByName("forth"));
    }

    @Test
    public void whenFindByIdThenTrue() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        Assert.assertThat(result, Is.is(item));
    }

    @Test
    public void whenNotFindByIdThenNull() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1");
        tracker.add(first);
        Item second = new Item("test2");
        tracker.add(second);
        tracker.delete(first.getId());
        Item result = tracker.findById(first.getId());
        Assert.assertNull(result);
    }

}
