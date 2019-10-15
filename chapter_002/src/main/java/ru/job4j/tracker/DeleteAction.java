package ru.job4j.tracker;

public class DeleteAction extends BaseAction {

    public DeleteAction(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Tracker tracker, Input input) {
        String id = input.askStr("Enter ID item which be delete: ");
        if (tracker.delete(id)) {
            output.accept("Item delete.");
        } else {
            output.accept("Item not delete");
        }
        return true;
    }
}
