package ru.job4j.condition;
/**
 * SqMax.
 *
 * @author Vladimir Kovtun (vovan_men@mail.ru)
 */
public class SqMax {
    public static int max(int first, int second, int third, int forth) {
        int result = forth;
        if (first > second) {
            result = first > third ? first : third;
            result = result > forth ? result : forth;
        } else if (second > third) {
            result = second > forth ? second : forth;
        } else if (third > forth) {
            result = third;
        }
        return result;
    }
}
