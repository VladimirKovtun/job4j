package ru.job4j.tracker;

public interface UserAction {

    public int key();

    public String info();

    public boolean execute(Tracker tracker, Input input);
}
