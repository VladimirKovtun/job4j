package ru.job4j.tracker;


import java.util.function.Consumer;

public class FindByIdAction extends BaseAction {

    public FindByIdAction(int key, String name, Consumer<String> output) {
        super(key, name, output);
    }

    @Override
    public boolean execute(ITracker tracker, Input input) {
        String id = input.askStr("Enter ID item: ");
        Item item = tracker.findById(id);
        if (item != null) {
            output.accept(String.format("Item ID %s, Item name %s, Item description %s, Item create_date %tF",
                                        item.getId(), item.getName(), item.getDescription(), item.getCreateDate()));
        } else {
            output.accept("Null.");
        }
        return true;
    }
}
