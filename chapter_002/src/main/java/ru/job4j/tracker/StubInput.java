package ru.job4j.tracker;

public class StubInput implements Input {
    private String[] answers;
    private int positions;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String askStr(String question) {
        return answers[positions++];
    }

    @Override
    public long askLong(String question, int max) {
        return Long.valueOf(askStr(question));
    }
}
