package ru.job4j.calculate;

/**
 * Calculate
 *
 * @author Vladimir Kovtun (vovan_men@mail.ru)
 */

public class Calculate {

    public static void add(double first, double second){
        double result = first + second;
        System.out.println(first + " + " + second + " = " + result);
    }

    public static void subtrack(double first, double second){
        double result = first - second;
        System.out.println(first + " - " + second + " = " + result);
    }

    public static void div(double first, double second){
        double result = first / second;
        System.out.println(first + " / " + second + " = " + result);
    }

    public static void multiply(double first, double second){
        double result = first * second;
        System.out.println(first + " * " + second + " = " + result);
    }

    /**
     * Main.
     * @param args - args.
     */

    public static void main(String[] args) {
        add(1,1);
        subtrack(10,5);
        div(4,2);
        multiply(2,1);
    }
}
