package ru.job4j.srp;

import ru.job4j.calculate.Calculate;

/**
 * The class that initializes and starts the calculator.
 */
public class InteractCalc {
    /**
     * Object class calculate method.
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
            int index = input.askInt("Choose action for next operation: ", menu.menuSize());
            result = menu.executeAction(index, calculate, input, result);
        } while (!"y".equals(input.askStr("Press 'y' for exit: ")));
    }

    /**
     * Initialization and launch of the calculator.
     *
     * @param args args.
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.addToMenu(new AdditionAction("0", "Addition"));
        menu.addToMenu(new SubtractAction("1", "Subtract"));
        menu.addToMenu(new DivideAction("2", "Divide"));
        menu.addToMenu(new MultiplyAction("3", "Multiply"));
        Calculate calculate = new Calculate();
        Input input = new ValidateInput(new ConsoleInput());
        new InteractCalc(calculate, input, menu).init();
    }
}
