package ru.job4j.srp;

import org.junit.Test;
import ru.job4j.calculate.Calculate;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MultiplyActionTest {

    @Test
    public void whenFirstNumberMultiplyOnSecond() {
        Calculate calculate = new Calculate();
        List<String> answers = Arrays.asList("15.6", "3.2");
        Input input = new StubInput(answers);
        double result = new MultiplyAction("", "")
                .execute(calculate, new CalcHandler(input, 0));
        assertEquals(result, 49.92, 0.01);
    }

}