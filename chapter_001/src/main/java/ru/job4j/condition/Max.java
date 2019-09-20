package ru.job4j.condition;
/**
 * Max.
 *
 * @author Vladimir Kovtun (vovan_men@mail.ru)
 */
public class Max {
    public static int max(int left, int right) {
        return left > right ? left : right;
    }
    public static int max(int first, int second, int third) {
        return max(max(first, second), third);
    }
    public static int max(int first, int second, int third, int forth) {
        return max(max(first, second, third), forth);
    }
}
