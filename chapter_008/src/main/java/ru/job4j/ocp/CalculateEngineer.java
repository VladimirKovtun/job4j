package ru.job4j.ocp;

import ru.job4j.calculate.Calculate;

/**
 *Engineer Calculate.
 */
public class CalculateEngineer extends Calculate {

    /**
     *Cosine.
     *
     * @param number number.
     * @return result.
     */
    public double cos(double number) {
        return Math.cos(Math.toRadians(number));
    }

    /**
     *Sinus.
     *
     * @param number number.
     * @return result.
     */
    public double sin(double number) {
        return Math.sin(Math.toRadians(number));
    }

    /**
     *Tangent.
     *
     * @param number number.
     * @return result.
     */
    public double tan(double number) {
        return Math.tan(Math.toRadians(number));
    }
}
