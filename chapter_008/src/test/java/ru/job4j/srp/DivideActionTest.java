package ru.job4j.srp;

import org.junit.Test;
import ru.job4j.calculate.Calculate;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DivideActionTest {

    @Test
    public void whenFirstNumberDivideOnSecond() {
        Calculate calculate = new Calculate();
        List<String> answers = Arrays.asList("12.4", "2.0");
        Input input = new StubInput(answers);
        double result = new DivideAction("", "")
                .execute(calculate, new CalcHandler(input, 0));
        assertEquals(result, 6.20, 0.01);
    }

}