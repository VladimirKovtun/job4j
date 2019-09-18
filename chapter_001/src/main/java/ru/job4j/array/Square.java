package ru.job4j.array;
/**
 * Square.
 *
 * @author Vladimir Kovtun (vovan_men@mail.ru)
 */
public class Square {
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < rst.length; i++) {
            rst[i] = (i + 1) * (i + 1);
        }
        return rst;
    }
}
