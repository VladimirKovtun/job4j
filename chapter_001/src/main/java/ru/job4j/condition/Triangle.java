package ru.job4j.condition;
/**
 * Triangle.
 *
 * @author Vladimir Kovtun (vovan_men@mail.ru)
 */
public class Triangle {
    public static boolean exist(double ab, double bc, double ca) {
        return (ab + bc > ca && bc + ca > ab && ca + ab > bc);
    }
}
