package ru.job4j.tracker;

public interface UserAction {

    int key();

    String info();

    boolean execute(ITracker tracker, Input input);
}
