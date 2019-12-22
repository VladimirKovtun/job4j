package ru.job4j.srp;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 *Class defining behavior.
 */
public class CalcHandler {
    /**
     * Result of previous calculation.
     */
    private double previous;
    /**
     * Input stream.
     */
    private Input input;

    public CalcHandler(Input input, double previous) {
        this.previous = previous;
        this.input = input;
    }

    /**
     *Executing an operation with two variables.
     *
     * @param biFunction reference to the calculator method.
     * @return calculator operation result.
     */
    public double executeTwoVar(BiFunction<Double, Double, Double> biFunction) {
        double newResult;
        if (previous != 0.0 && input.askReUse("Press 'c' for start new expression or continue with result: ")) {
            double secondDouble = input.askDouble("Second number: ");
            newResult = biFunction.apply(previous, secondDouble);
        } else {
            double firstDouble = input.askDouble("First number: ");
            double secondDouble = input.askDouble("Second number: ");
            newResult = biFunction.apply(firstDouble, secondDouble);
        }
        return newResult;
    }

    /**
     *Executing an operation with a single variable.
     *
     * @param function reference to the calculator method.
     * @return calculator operation result.
     */
    public double executeOneVar(Function<Double, Double> function) {
        double newResult;
        if (previous != 0.0 && input.askReUse("Press 'c' for start new expression or continue with result: ")) {
            newResult = function.apply(previous);
        } else {
            double firstDouble = input.askDouble("Input number: ");
            newResult = function.apply(firstDouble);
        }
        return newResult;
    }
}
