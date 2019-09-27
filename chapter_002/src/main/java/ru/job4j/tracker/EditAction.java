package ru.job4j.tracker;

public class EditAction implements UserAction {
    @Override
    public String name() {
        return "Edit item.";
    }

    @Override
    public boolean execute(Tracker tracker, Input input) {
        String name = input.askStr("**Edit item**\nEnter name: ");
        String id = String.valueOf(input.askLong("Enter ID item: "));
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Item replace.");
        } else {
            System.out.println("Item not replace.");
        }
        return true;
    }
}
