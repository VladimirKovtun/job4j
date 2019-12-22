package ru.job4j.srp;

import ru.job4j.calculate.Calculate;

/**
 * Action divide class.
 */
public class DivideAction extends BaseCalcAction {

    public DivideAction(String number, String text) {
        super(number, text);
    }

    /**
     *Execution of divide.
     *
     * @param calculate Class object with calculator methods.
     * @param calcHandler A class object that defines behavior.
     * @return The result of the divide.
     */
    @Override
    public double execute(Calculate calculate, CalcHandler calcHandler) {
        double result = calcHandler.executeTwoVar(calculate::divide);
        System.out.printf("Result is: %.2f%n", result);
        return result;
    }
}
