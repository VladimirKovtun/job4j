package ru.job4j.calculate;

/**
 * Calculate.
 *
 * @author Vladimir Kovtun (vovan_men@mail.ru)
 */
public class Calculate {
    /**
     * Adding numbers.
     *
     * @param first - first number.
     * @param second - second number.
     */
    public static void add(double first, double second) {
        double result = first + second;
        System.out.println(first + " + " + second + " = " + result);
    }
    /**
     * Subtract numbers.
     *
     * @param first - first number.
     * @param second - second number.
     */
    public static void subtrack(double first, double second) {
        double result = first - second;
        System.out.println(first + " - " + second + " = " + result);
    }
    /**
     * Divide numbers.
     *
     * @param first - first number.
     * @param second - second number.
     */
    public static void div(double first, double second) {
        double result = first / second;
        System.out.println(first + " / " + second + " = " + result);
    }
    /**
     * Multiply numbers.
     *
     * @param first - first number.
     * @param second - second number.
     */
    public static void multiply(double first, double second) {
        double result = first * second;
        System.out.println(first + " * " + second + " = " + result);
    }
    /**
     * Main.
     * @param args - args.
     */
    public static void main(String[] args) {
        add(1, 1);
        subtrack(10, 5);
        div(4, 2);
        multiply(2, 1);
    }
}
