package ru.job4j.array;
/**
 * SortSelected.
 *
 * @author Vladimir Kovtun (vovan_men@mail.ru)
 */
public class SortSelected {
    public static int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = MinDiapason.findMin(array, i, array.length - 1);
            int index = FindLoop.indexOf(array, min, i, array.length - 1);
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
        return array;
    }
}
