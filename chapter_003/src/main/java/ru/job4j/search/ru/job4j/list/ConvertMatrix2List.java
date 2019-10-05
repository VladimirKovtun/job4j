package ru.job4j.search.ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {

    public List<Integer> toList(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        for (int[] mas : matrix) {
            for (int i : mas) {
                list.add(i);
            }
        }
        return list;
    }
}
