package ru.job4j.tracker;

public class FindByIdAction extends BaseAction {

    public FindByIdAction(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Tracker tracker, Input input) {
        String id = input.askStr("Enter ID item: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.printf("Item ID %s, Item name %s", item.getId(), item.getName());
        } else {
            System.out.println("Null.");
        }
        return true;
    }
}
