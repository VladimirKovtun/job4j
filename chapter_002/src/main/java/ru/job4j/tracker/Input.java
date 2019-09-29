package ru.job4j.tracker;

public interface Input {

    String askStr(String question);

    long askLong(String question);

    long askLong(String question, int max);
}
