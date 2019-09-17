package ru.job4j.condition;

public class Triangle {

    public static boolean exist(double ab, double bc, double ca) {
        return (ab + bc > ca && bc + ca > ab && ca + ab > bc);
    }
}
