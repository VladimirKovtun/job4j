package ru.job4j.tracker;

import java.util.function.Consumer;

public class DeleteAction extends BaseAction {

    public DeleteAction(int key, String name, Consumer<String> output) {
        super(key, name, output);
    }

    @Override
    public boolean execute(ITracker tracker, Input input) {
        String id = input.askStr("Enter ID item which be delete: ");
        if (tracker.delete(id)) {
            output.accept("Item delete.");
        } else {
            output.accept("Item not delete");
        }
        return true;
    }
}
