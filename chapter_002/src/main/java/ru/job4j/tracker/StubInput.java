package ru.job4j.tracker;

import java.util.List;

public class StubInput implements Input {
    private List<String> answers;
    private int index;

    public StubInput(List<String> answers) {
        this.answers = answers;
    }

    @Override
    public String askStr(String question) {
        return answers.get(index++);
    }

    @Override
    public long askLong(String question, int max) {
        return Long.valueOf(askStr(question));
    }
}
