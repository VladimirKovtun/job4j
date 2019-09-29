package ru.job4j.tracker;

public class ValidateInput implements Input {
    private Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }

    @Override
    public String askStr(String question) {
        return input.askStr(question);
    }

    public long askLong(String question, int max) {
        boolean inValid = true;
        long result = -1;
        do {
            try {
                result = input.askLong(question, max);
                inValid = false;
            } catch (IllegalStateException ise) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe){
                System.out.println("Please enter validate data.");
            }
        } while (inValid);

        return result;
    }
}
