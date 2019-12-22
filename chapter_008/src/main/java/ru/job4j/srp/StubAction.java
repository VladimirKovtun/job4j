package ru.job4j.srp;

import ru.job4j.calculate.Calculate;

/**
 * Class stub action for tests.
 */
public class StubAction extends BaseCalcAction {
    /**
     * To define a method call
     */
    private boolean call = false;

    protected StubAction(String number, String text) {
        super(number, text);
    }

    /**
     * The method is a stub for determining its call in tests.
     *
     * @param calculate This is not important here.
     * @param calcHandler This is not important here.
     * @return always 0.
     */
    @Override
    public double execute(Calculate calculate, CalcHandler calcHandler) {
        call = true;
        return 0;
    }

    /**
     * Getter.
     *
     * @return returns a variable call.
     */
    public boolean isCall() {
        return call;
    }
}
