package ru.job4j.tracker;

import java.util.Arrays;

public class FindByNameAction extends BaseAction {

    public FindByNameAction(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Tracker tracker, Input input) {
        String name = input.askStr("Enter name: ");
        Item[] byName = tracker.findByName(name);
        if (byName != null) {
            System.out.print(Arrays.toString(byName));
            /*for (Item item : byName) {
                System.out.printf("Item ID %s, Item name %s%n", item.getId(), item.getName());
            }*/
        } else {
            System.out.println("Null.");
        }
        return true;
    }
}
