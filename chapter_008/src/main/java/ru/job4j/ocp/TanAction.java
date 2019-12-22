package ru.job4j.ocp;

import ru.job4j.calculate.Calculate;
import ru.job4j.srp.BaseCalcAction;
import ru.job4j.srp.CalcHandler;

/**
 * Action tangent calculations class.
 */
public class TanAction extends BaseCalcAction {

    protected TanAction(String number, String text) {
        super(number, text);
    }

    /**
     *Executing tangent action.
     *
     * @param calculate object class engineerCalculator.
     * @param calcHandler object calculator behavior.
     * @return calculation tangent result.
     */
    @Override
    public double execute(Calculate calculate, CalcHandler calcHandler) {
        double tan = calcHandler.executeOneVar(x -> {
            CalculateEngineer engineer = (CalculateEngineer) calculate;
            return engineer.tan(x);
        });
        System.out.println(tan);
        return tan;
    }
}
