package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {

    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() % rows == 0 ? list.size() / rows : (list.size() / rows) + 1;
        int[][] array = new int[rows][cells];
        int i = 0;
        int j = 0;
        for (Integer in : list) {
            if (j == cells) {
                j = 0;
                i++;
            }
            array[i][j++] = in;
        }
        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> listInteger = new ArrayList<>();
        for (int[] mas : list) {
            for (int i : mas) {
                listInteger.add(i);
            }
        }
        return listInteger;
    }
}
