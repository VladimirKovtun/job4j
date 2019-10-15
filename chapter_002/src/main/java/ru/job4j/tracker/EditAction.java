package ru.job4j.tracker;

public class EditAction extends BaseAction {

    public EditAction(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Tracker tracker, Input input) {
        String name = input.askStr("Enter name: ");
        String id = input.askStr("Enter ID item: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            output.accept("Item replace.");
        } else {
            output.accept("Item not replace.");
        }
        return true;
    }
}
