package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find item by ID.";
    }

    @Override
    public boolean execute(Tracker tracker, Input input) {
        String id = String.valueOf(input.askLong("**Find item by ID**\nEnter ID item: "));
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.printf("Item ID %s, Item name %s", item.getId(), item.getName());
        } else {
            System.out.println("Null.");
        }
        return true;
    }
}
