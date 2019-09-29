package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete item.";
    }

    @Override
    public boolean execute(Tracker tracker, Input input) {
        String id = input.askStr("**Delete item**\nEnter ID item which be delete: ");
        if (tracker.delete(id)) {
            System.out.println("Item delete.");
        } else {
            System.out.println("Item not delete");
        }
        return true;
    }
}
