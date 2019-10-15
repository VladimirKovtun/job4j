package ru.job4j.tracker;

import java.util.function.Consumer;

public class EditAction extends BaseAction {

    public EditAction(int key, String name, Consumer<String> output) {
        super(key, name, output);
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
