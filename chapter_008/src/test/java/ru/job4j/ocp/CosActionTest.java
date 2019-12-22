package ru.job4j.ocp;

import org.junit.Test;
import ru.job4j.calculate.Calculate;
import ru.job4j.srp.CalcHandler;
import ru.job4j.srp.Input;
import ru.job4j.srp.StubInput;

import java.util.Arrays;

import static org.junit.Assert.*;

public class CosActionTest {

    @Test
    public void whenCosAction() {
        Calculate engCalc = new CalculateEngineer();
        Input stubInp = new StubInput(Arrays.asList("0", "y"));
        double result = new CosAction("", "").execute(engCalc, new CalcHandler(stubInp, 0));
        assertEquals(1, result, 0.001);
    }

}