package ru.job4j.tracker;

import java.util.function.Consumer;

public class StartUI {
    private final Input input;
    private final Tracker tracker;
    private final Consumer<String> output;

    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(input, tracker, output);
        menu.fillActions();
        do {
            menu.show();
            menu.select((int) input.askLong("Select: ", menu.actionSize()));
        }while (!"y".equalsIgnoreCase(input.askStr("Exit?(y): ")));
    }

    public static void main(String[] args) {
        Input input = new ValidateInput(new ConsoleInput());
        new StartUI(input, new Tracker(), System.out::println).init();
    }
}
