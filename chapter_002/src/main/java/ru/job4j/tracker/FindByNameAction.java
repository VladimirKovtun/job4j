package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find items by name.";
    }

    @Override
    public boolean execute(Tracker tracker, Input input) {
        String name = input.askStr("**Find items by name**\nEnter name: ");
        Item[] byName = tracker.findByName(name);
        if (byName != null) {
            for (Item item : byName) {
                System.out.printf("Item ID %s, Item name %s", item.getId(), item.getName());
            }
        } else {
            System.out.println("Null.");
        }
        return true;
    }
}
