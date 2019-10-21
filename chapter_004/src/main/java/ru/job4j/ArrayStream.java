package ru.job4j;

import java.util.stream.IntStream;

public class ArrayStream {

    public int arrayCombo(int[] array) {
        return IntStream.of(array)
                .filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .sum();
    }
}
