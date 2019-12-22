package ru.job4j.srp;

import org.junit.Test;
import ru.job4j.calculate.Calculate;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SubtractActionTest {

    @Test
    public void whenFirstNumberSubtractSecond() {
        Calculate calculate = new Calculate();
        List<String> answers = Arrays.asList("22.4", "20.2");
        Input input = new StubInput(answers);
        double result = new SubtractAction("", "")
                .execute(calculate, new CalcHandler(input, 0));
        assertEquals(result, 2.20, 0.01);
    }

}