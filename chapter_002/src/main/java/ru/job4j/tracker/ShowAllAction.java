package ru.job4j.tracker;

import java.util.List;

public class ShowAllAction extends BaseAction {

    public ShowAllAction(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Tracker tracker, Input input) {
        List<Item> allItems = tracker.findAll();
        System.out.print(allItems);
        return true;
    }
}
