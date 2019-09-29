package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {

    @Override
    public long askLong(String question) {
        long result = -1;
        boolean inValid = true;
        do {
           try {
               result = super.askLong(question);
               inValid = false;
           } catch (NumberFormatException nfe) {
               System.out.println("Please enter validate format data.");
           }
        }while (inValid);
        return result;
    }

    @Override
    public long askLong(String question, int max) {
        boolean inValid = true;
        long result = -1;
        do {
            try {
                result = super.askLong(question, max);
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
