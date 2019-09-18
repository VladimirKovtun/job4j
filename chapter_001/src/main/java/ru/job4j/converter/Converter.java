package ru.job4j.converter;
/**
 * Converter.
 *
 * @author Vladimir Kovtun (vovan_men@mail.ru)
 */
public class Converter {
    public static int rubleToEuro(int value) {
        return value / 70;
    }
    public static int rubleToDollar(int value) {
        return value / 60;
    }
    public static int dollarToRuble(int value) {
        return value * 60;
    }
    public static int euroToRuble(int value) {
        return value * 70;
    }
    public static void main(String[] args) {
        int euro = rubleToEuro(140);
        System.out.println("140 rubles are " + euro + " euro.");
        int in = 140;
        int expected = 2;
        int out = rubleToDollar(in);
        boolean passed = expected == out;
        System.out.println("140 rubles are 2. Test result : " + passed);
        int dollar = rubleToDollar(120);
        System.out.println("120 rubles are " + dollar + " dollar.");
        in = 120;
        expected = 2;
        out = rubleToDollar(in);
        passed = expected == out;
        System.out.println("120 rubles are 2. Test result : " + passed);
        int rubEuro = euroToRuble(4);
        System.out.println("4 euro are " + rubEuro + " rubles.");
        in = 4;
        expected = 280;
        out = euroToRuble(in);
        passed = expected == out;
        System.out.println("4 euro are 280. Test result : " + passed);
        int rubDollar = dollarToRuble(5);
        System.out.println("5 dollar are " + rubDollar + " rubles.");
        in = 5;
        expected = 300;
        out = dollarToRuble(in);
        passed = expected == out;
        System.out.println("5 dollar are 300. Test result : " + passed);
    }
}
