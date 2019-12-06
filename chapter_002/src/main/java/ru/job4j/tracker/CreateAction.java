package ru.job4j.tracker;

import java.util.Date;

public class CreateAction extends BaseAction {

    public CreateAction(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(ITracker tracker, Input input) {
        String name = input.askStr("Enter name: ");
        String desc = input.askStr("Enter description: ");
        Item item = new Item(name, desc, new Date());
        tracker.add(item);
        return true;
    }
}
