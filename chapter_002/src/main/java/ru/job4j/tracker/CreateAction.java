package ru.job4j.tracker;

public class CreateAction implements UserAction {
    @Override
    public String name() {
        return "Add new item.";
    }

    @Override
    public boolean execute(Tracker tracker, Input input) {
        String name = input.askStr("**Add new item**\nEnter name: ");
        Item item = new Item(name);
        tracker.add(item);
        return true;
    }
}
