package ru.job4j.srp;

import ru.job4j.calculate.Calculate;

/**
 * An interface that describes actions.
 */
public interface ICalcAction {

    /**
     * Formation of a line for the menu.
     *
     * @return Ready for output string.
     */
    String info();

    /**
     * Executing action.
     *
     * @param calculate object class calculator.
     * @param calcHandler object calculator behavior.
     * @return result action.
     */
    double execute(Calculate calculate, CalcHandler calcHandler);
}
