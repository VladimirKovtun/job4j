package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

public class ShowAllAction extends BaseAction {

    public ShowAllAction(int key, String name, Consumer<String> output) {
        super(key, name, output);
    }

    @Override
    public boolean execute(Tracker tracker, Input input) {
        List<Item> allItems = tracker.findAll();
        output.accept(allItems.toString());
        return true;
    }
}
