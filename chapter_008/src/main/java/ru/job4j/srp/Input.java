package ru.job4j.srp;

/**
 * An interface that defines an input stream.
 */
public interface Input {

    /**
     * Method for determining the data used in the calculator.
     *
     * @param question info for user.
     * @return string.
     */
    String askStr(String question);

    /**
     * Method for getting double used in a calculator.
     *
     * @param question info for user.
     * @return double for calculator operation.
     */
    Double askDouble(String question);

    /**
     *To determine the action.
     *
     * @param question info for user.
     * @param size The number of actions.
     * @return The sequence number of the action.
     */
    int askInt(String question, int size);

    /**
     *Definition for reusing the previous result.
     *
     * @param question info for user.
     * @return result from input.
     */
    boolean askReUse(String question);
}
