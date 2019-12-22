package ru.job4j.srp;

import ru.job4j.calculate.Calculate;

/**
 * Subtraction action class.
 */
public class SubtractAction extends BaseCalcAction {

    public SubtractAction(String number, String text) {
        super(number, text);
    }

    /**
     *Execution of subtraction.
     *
     * @param calculate Class object with calculator methods.
     * @param calcHandler A class object that defines behavior.
     * @return The result of the subtraction.
     */
    @Override
    public double execute(Calculate calculate, CalcHandler calcHandler) {
        double result = calcHandler.executeTwoVar(calculate::subTract);
        System.out.printf("Result is: %.2f%n", result);
        return result;
    }
}
