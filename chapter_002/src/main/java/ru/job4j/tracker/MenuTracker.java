package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<BaseAction> actions = new ArrayList<>();
    private Consumer<String> output;

    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void fillActions() {
        actions.add(new CreateAction(0, "Create item."));
        actions.add(new ShowAllAction(1, "Show all items."));
        actions.add(new DeleteAction(2, "Delete item."));
        actions.add(new EditAction(3, "Replace item."));
        actions.add(new FindByNameAction(4, "Find items by name."));
        actions.add(new FindByIdAction(5, "Find item by ID."));
        actions.add(new ExitAction(6, "Exit program."));
    }

    public int actionSize() {
        return actions.size();
    }

    public void select(int key) {
        this.actions.get(key).execute(this.tracker, this.input);
    }

    public void show() {
        for (BaseAction action : actions) {
            if (action != null) {
                output.accept(action.info());
            }
        }
    }

    public void addAction(BaseAction action) {
        actions.add(action);
    }
}
