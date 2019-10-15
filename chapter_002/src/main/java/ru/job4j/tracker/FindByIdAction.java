package ru.job4j.tracker;


import java.util.function.Consumer;

public class FindByIdAction extends BaseAction {

    public FindByIdAction(int key, String name, Consumer<String> output) {
        super(key, name, output);
    }

    @Override
    public boolean execute(Tracker tracker, Input input) {
        String id = input.askStr("Enter ID item: ");
        Item item = tracker.findById(id);
        if (item != null) {
            output.accept(String.format("Item ID %s, Item name %s", item.getId(), item.getName()));
        } else {
            output.accept("Null.");
        }
        return true;
    }
}
