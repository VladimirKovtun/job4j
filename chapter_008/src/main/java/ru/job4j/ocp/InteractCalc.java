package ru.job4j.ocp;

import ru.job4j.calculate.Calculate;
import ru.job4j.srp.*;

/**
 * The class that initializes and starts the engineer calculator.
 */
public class InteractCalc {
    /**
     * Object class engineer calculate method.
     */
    private final Calculate calculate;
    /**
     * Input stream object.
     */
    private final Input input;
    /**
     * Menu object.
     */
    private final Menu menu;

    public InteractCalc(final Calculate calculate, final Input input, final Menu menu) {
        this.calculate = calculate;
        this.input = input;
        this.menu = menu;
    }

    /**
     * Menu operation method.
     */
    public void init() {
        double result = 0;
        do {
            menu.showMenu();
            int index = input.askInt("Select action: ", menu.menuSize());
            result = menu.executeAction(index, calculate, input, result);
        } while (!"y".equals(input.askStr("Press 'y' for exit: ")));
    }

    /**
     * Initialization and launch of the engineer calculator.
     *
     * @param args args.
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.addToMenu(new AdditionAction("0", "Addition"));
        menu.addToMenu(new SubtractAction("1", "Subtract"));
        menu.addToMenu(new DivideAction("2", "Divide"));
        menu.addToMenu(new MultiplyAction("3", "Multiply"));
        menu.addToMenu(new CosAction("4", "Cos"));
        menu.addToMenu(new SinAction("5", "Sin"));
        menu.addToMenu(new TanAction("6", "Tan"));
        Calculate calculate = new CalculateEngineer();
        Input input = new ValidateInput(new ConsoleInput());
        new InteractCalc(calculate, input, menu).init();
    }
}

