package ru.job4j.array;
/**
 * Min.
 *
 * @author Vladimir Kovtun (vovan_men@mail.ru)
 */
public class Min {
    public static int findMin(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}
