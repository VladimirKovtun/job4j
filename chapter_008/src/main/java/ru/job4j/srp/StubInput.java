package ru.job4j.srp;

import java.util.List;

/**
 * The class is a stub for input for tests.
 */
public class StubInput implements Input {
    /**
     * A list that simulates user responses.
     */
    private final List<String> answers;
    /**
     * A list index.
     */
    private int index;

    public StubInput(List<String> answers) {
        this.answers = answers;
    }

    /**
     *Stub input method.
     *
     * @param question This is not important here.
     * @return String taken from the list.
     */
    @Override
    public String askStr(String question) {
        return answers.get(index++);
    }

    /**
     *Numbers for calculator operations.
     *
     * @param question This is not important here.
     * @return double taken from the list.
     */
    @Override
    public Double askDouble(String question) {
        return Double.parseDouble(answers.get(index++));
    }

    /**
     *To select an action from the menu.
     *
     * @param question This is not important here.
     * @param index in test usually 0.
     * @return int taken from the list.
     */
    @Override
    public int askInt(String question, int index) {
        return Integer.parseInt(askStr(question));
    }

    /**
     *Definition of reuse.
     *
     * @param question This is not important here.
     * @return always false.
     */
    @Override
    public boolean askReUse(String question) {
        return false;
    }
}
