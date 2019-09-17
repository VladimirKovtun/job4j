package ru.job4j.array;

public class IsSorted {

    public static boolean isSorted(int[] array) {
        boolean is = false;
        int count = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] < array[i]) {
                count++;
            }
        }
        if (count == array.length - 1) {
            is = true;
        }
        return is;
    }
}
