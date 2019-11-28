package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

public class FindByNameAction extends BaseAction {

    public FindByNameAction(int key, String name, Consumer<String> output) {
        super(key, name, output);
    }

    @Override
    public boolean execute(ITracker tracker, Input input) {
        String name = input.askStr("Enter name: ");
        List<Item> byName = tracker.findByName(name);
        if (byName != null) {
            output.accept(byName.toString());
        } else {
            output.accept("Null.");
        }
        return true;
    }
}
