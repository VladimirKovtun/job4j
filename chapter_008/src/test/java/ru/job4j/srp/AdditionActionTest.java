package ru.job4j.srp;

import org.junit.Test;
import ru.job4j.calculate.Calculate;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class AdditionActionTest {

    @Test
    public void whenTwoNumberAddition() {
        Calculate calculate = new Calculate();
        List<String> answers = Arrays.asList("9.4", "2.6");
        Input input = new StubInput(answers);
        double result = new AdditionAction("", "")
                .execute(calculate, new CalcHandler(input, 0));
        assertEquals(result, 12.00, 0.01);
    }

}