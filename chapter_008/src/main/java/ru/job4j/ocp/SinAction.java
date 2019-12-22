package ru.job4j.ocp;

import ru.job4j.calculate.Calculate;
import ru.job4j.srp.BaseCalcAction;
import ru.job4j.srp.CalcHandler;

/**
 * Action sinus calculations class.
 */
public class SinAction extends BaseCalcAction {

    protected SinAction(String nunber, String text) {
        super(nunber, text);
    }

    /**
     *Executing sinus action.
     *
     * @param calculate object class engineerCalculator.
     * @param calcHandler object calculator behavior.
     * @return calculation sinus result.
     */
    @Override
    public double execute(Calculate calculate, CalcHandler calcHandler) {
        double sin = calcHandler.executeOneVar(x -> {
            CalculateEngineer engineer = (CalculateEngineer) calculate;
            return engineer.sin(x);
        });
        System.out.println(sin);
        return sin;
    }
}
