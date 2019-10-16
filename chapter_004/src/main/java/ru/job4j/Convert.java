package ru.job4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Convert {

    public List<Integer> matrixToList(Integer[][] matrix) {
        //Arrays.stream(matrix).flatMap(Arrays::stream).collect(Collectors.toList());
        return Stream.of(matrix).flatMap(Arrays::stream).collect(Collectors.toList());
    }
}
