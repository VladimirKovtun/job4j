package ru.job4j.condition;
/**
 * SqArea.
 *
 * @author Vladimir Kovtun (vovan_men@mail.ru)
 */
public class SqArea {
    public static double square(int p, int k) {
        return (Math.pow(p, 2) * k) / (4 * Math.pow(k + 1, 2));
    }
    public static void main(String[] args) {
        double result1 = square(6, 2);
        System.out.println(" p = 6, k = 2, s = 2, real = " + result1);
    }
}
