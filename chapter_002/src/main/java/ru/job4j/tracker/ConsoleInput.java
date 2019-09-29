package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {

    @Override
    public String askStr(String question) {
        System.out.printf("%s", question);
        return new Scanner(System.in).nextLine();
    }

    @Override
    public long askLong(String question, int max) {
        long select = Long.valueOf(askStr(question));
        if (select < 0 || select >= max) {
            throw new IllegalStateException(String.format("Out of about %s > [0, %s]", select, max));
        }
        return select;
    }
}
