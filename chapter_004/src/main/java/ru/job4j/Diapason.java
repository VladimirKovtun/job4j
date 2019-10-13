package ru.job4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Diapason {

    static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> diap = new ArrayList<>();
        for (int index = start; index != end; index++) {
            diap.add(func.apply((double) index));
        }
        return diap;
    }
}
