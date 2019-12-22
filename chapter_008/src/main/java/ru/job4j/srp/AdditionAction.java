package ru.job4j.srp;

import ru.job4j.calculate.Calculate;

/**
 * Action addition class.
 */
public class AdditionAction extends BaseCalcAction {

    public AdditionAction(String number, String text) {
        super(number, text);
    }

    /**
     *Execution of addition.
     *
     * @param calculate Class object with calculator methods.
     * @param calcHandler A class object that defines behavior.
     * @return The result of the addition.
     */
    @Override
    public double execute(Calculate calculate, CalcHandler calcHandler) {
        double result = calcHandler.executeTwoVar(calculate::add);
        System.out.printf("Result is: %.2f%n", result);
        return result;
    }
}
