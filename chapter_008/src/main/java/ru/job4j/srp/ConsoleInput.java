package ru.job4j.srp;

import java.util.Scanner;

/**
 * Class for console input.
 */
public class ConsoleInput implements Input {
    /**
     * Input stream from console.
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Call console input to get the string.
     *
     * @param question info for user.
     * @return The result of user input.
     */
    @Override
    public String askStr(String question) {
        System.out.printf("%s", question);
        return scanner.nextLine();
    }

    /**
     * Call console input to get the double.
     *
     * @param question info for user.
     * @return User input for calculator operations.
     */
    @Override
    public Double askDouble(String question) {
        String doubleInput = askStr(question);
        if (!doubleInput.matches("^(0|[1-9]\\d*)([.,]\\d+)?")) {
            throw new IllegalStateException();
        }
        return Double.parseDouble(doubleInput);
    }

    /**
     * Callconsole input to get the int.
     *
     * @param question info for user.
     * @param max The number of operations of the calculator.
     * @return User input to select calculator operation from the menu.
     */
    @Override
    public int askInt(String question, int max) {
        int select = Integer.parseInt(askStr(question));
        if (select < 0 || select >= max) {
            throw new IllegalStateException(String.format("Out of about %s > [0, %s]", select, max));
        }
        return select;
    }

    /**
     * Input to determine the reuse of the previous result.
     *
     * @param question info for user.
     * @return The result of checking user input to determine for reuse.
     */
    @Override
    public boolean askReUse(String question) {
        String bool = askStr(question);
        return !"c".equals(bool.toLowerCase());
    }
}
