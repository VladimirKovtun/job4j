package ru.job4j.search.ru.job4j.list;

import java.util.Arrays;
import java.util.List;

public class ConvertList2Array {

    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() % rows == 0 ? list.size() / rows : (list.size() / rows) + 1;
        int[][] array = new int[rows][cells];
        int i = 0;
        int j = 0;
        for (Integer in : list) {
            if (j == 0 || j % cells != 0) {
                array[i][j] = in;
                j++;
            } else {
                j = 0;
                i++;
                array[i][j] = in;
                j++;
            }
        }
        return array;
    }
}
