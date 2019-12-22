package ru.job4j.srp;

import ru.job4j.calculate.Calculate;

import java.util.ArrayList;
import java.util.List;

/**
 * A class describing the menu of the calculator.
 */
public class Menu {
    /**
     * Calculator actions list.
     */
    private List<BaseCalcAction> actions;

    public Menu() {
        actions = new ArrayList<>();
    }

    /**
     * Adding a new action.
     *
     * @param action Calculator action.
     */
    public void addToMenu(BaseCalcAction action) {
        actions.add(action);
    }

    /**
     * Rendering a calculator menu.
     */
    public void showMenu() {
        for (BaseCalcAction act : actions) {
            System.out.println(act.info());
        }
    }

    /**
     * The size of the action list.
     *
     * @return list size.
     */
    public int menuSize() {
        return actions.size();
    }

    /**
     * Delegation of the calculation action.
     *
     * @param index serial number.
     * @param calculate calculator class object.
     * @param input input stream.
     * @param previousRes previous result.
     * @return result of action.
     */
    public double executeAction(int index, Calculate calculate, Input input, double previousRes) {
       return actions.get(index).execute(calculate, new CalcHandler(input, previousRes));
    }
}
