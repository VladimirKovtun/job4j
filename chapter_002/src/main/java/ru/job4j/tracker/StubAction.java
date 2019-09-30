package ru.job4j.tracker;

public class StubAction extends BaseAction {
    private boolean call = false;

    public StubAction(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Tracker tracker, Input input) {
        call = true;
        return false;
    }

    public boolean isCall() {
        return call;
    }
}
