package ru.job4j.srp;

/**
 * Class for checking input.
 */
public class ValidateInput implements Input {
    /**
     * Stream input.
     */
    private Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }

    /**
     * Delegate console input to get the string.
     *
     * @param question Information for the user.
     * @return The result of user input.
     */
    @Override
    public String askStr(String question) {
        return input.askStr(question);
    }

    /**
     * Call and validate console input to get the double.
     *
     * @param question Information for the user.
     * @return User input for calculator operations.
     */
    @Override
    public Double askDouble(String question) {
        Double result = 0.0;
        boolean inValid = true;
        do {
            try {
                result = input.askDouble(question);
                inValid = false;
            } catch (IllegalStateException e) {
                System.out.println("Input correct number");
            }
        } while (inValid);
        return result;
    }

    /**
     * Call and validate console input to get the int.
     *
     * @param question Information for the user.
     * @param max The number of operations of the calculator.
     * @return User input to select calculator operation from the menu.
     */
    @Override
    public int askInt(String question, int max) {
        int result = -1;
        boolean inValid = true;
        do {
            try {
                result = input.askInt(question, max);
                inValid = false;
            } catch (IllegalStateException ise) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data.");
            }
        } while (inValid);
        return result;
    }

    /**
     *Input to determine the reuse of the previous result.
     *
     * @param question Information for the user.
     * @return The result of checking user input to determine for reuse.
     */
    @Override
    public boolean askReUse(String question) {
        return input.askReUse(question);
    }
}
