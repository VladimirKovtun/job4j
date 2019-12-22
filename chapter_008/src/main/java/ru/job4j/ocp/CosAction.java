package ru.job4j.ocp;

import ru.job4j.calculate.Calculate;
import ru.job4j.srp.BaseCalcAction;
import ru.job4j.srp.CalcHandler;

/**
 * Action cosine calculations class.
 */
public class CosAction extends BaseCalcAction {

    public CosAction(String number, String text) {
        super(number, text);
    }

    /**
     *Executing cosine action.
     *
     * @param calculate object class engineerCalculator.
     * @param calcHandler object calculator behavior.
     * @return calculation cosine result.
     */
    @Override
    public double execute(Calculate calculate, CalcHandler calcHandler) {
        double cos = calcHandler.executeOneVar(x -> {
            CalculateEngineer engineer = (CalculateEngineer) calculate;
            return engineer.cos(x);
        });
        System.out.println(cos);
        return cos;
    }
}
