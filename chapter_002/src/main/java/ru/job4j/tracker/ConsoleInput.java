package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {

    @Override
    public String askStr(String question) {
        return new Scanner(System.in).nextLine();
    }

    @Override
    public long askLong(String question) {
        return new Scanner(System.in).nextLong();
    }
}
