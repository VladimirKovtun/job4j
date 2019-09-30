package ru.job4j.tracker;

import java.util.Arrays;

public class ShowAllAction extends BaseAction {

    public ShowAllAction(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Tracker tracker, Input input) {
        Item[] allItems = tracker.findAll();
        System.out.print(Arrays.toString(allItems));
        /*for (Item item : allItems) {
            System.out.printf("Item ID %s, Item name %s%n", item.getId(), item.getName());
        }*/
        return true;
    }
}
