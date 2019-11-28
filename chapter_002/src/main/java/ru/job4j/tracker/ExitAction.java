package ru.job4j.tracker;

public class ExitAction extends BaseAction {

    public ExitAction(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(ITracker tracker, Input input) {
        return false;
    }
}
