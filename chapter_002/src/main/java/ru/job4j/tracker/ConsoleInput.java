package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {

    @Override
    public String askStr(String question) {
        System.out.printf("%s", question);
        return new Scanner(System.in).nextLine();
    }

    @Override
    public long askLong(String question) {
        System.out.printf("%s", question);
        return new Scanner(System.in).nextLong();
    }
}
