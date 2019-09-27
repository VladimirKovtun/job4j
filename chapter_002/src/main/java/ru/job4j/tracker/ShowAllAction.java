package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "Show all items.";
    }

    @Override
    public boolean execute(Tracker tracker, Input input) {
        System.out.println("**Show all items**");
        Item[] allItems = tracker.findAll();
        for (Item item : allItems) {
            System.out.printf("Item ID %s, Item name %s", item.getId(), item.getName());
        }
        return true;
    }
}
