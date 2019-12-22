package ru.job4j.srp;

import ru.job4j.calculate.Calculate;

/**
 * Action multiply class.
 */
public class MultiplyAction extends BaseCalcAction {

    public MultiplyAction(String number, String text) {
        super(number, text);
    }

    /**
     *Execution of multiply.
     *
     * @param calculate Class object with calculator methods.
     * @param calcHandler A class object that defines behavior.
     * @return The result of the multiply.
     */
    @Override
    public double execute(Calculate calculate, CalcHandler calcHandler) {
        double result = calcHandler.executeTwoVar(calculate::multiply);
        System.out.printf("Result is: %.2f%n", result);
        return result;
    }
}
