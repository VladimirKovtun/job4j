package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction extends BaseAction {

    public FindByNameAction(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Tracker tracker, Input input) {
        String name = input.askStr("Enter name: ");
        List<Item> byName = tracker.findByName(name);
        if (byName != null) {
            System.out.print(byName);
        } else {
            System.out.println("Null.");
        }
        return true;
    }
}
