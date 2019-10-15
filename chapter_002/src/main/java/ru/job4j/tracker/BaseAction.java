package ru.job4j.tracker;

import java.util.function.Consumer;

public abstract class BaseAction implements UserAction {
    private final int key;
    private final String name;
    protected Consumer<String> output;

    protected BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }

    protected BaseAction(final int key, final String name, final Consumer<String> output) {
        this.key = key;
        this.name = name;
        this.output = output;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%s : %s", this.key, this.name);
    }
}
