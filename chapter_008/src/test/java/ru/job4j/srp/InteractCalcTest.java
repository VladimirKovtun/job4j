package ru.job4j.srp;

import org.junit.Test;
import ru.job4j.calculate.Calculate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class InteractCalcTest {

    @Test
    public void whenInitCalcAndStartAction() {
        StubAction actionStub = new StubAction("0", "Stub");
        Menu menu = new Menu();
        menu.addToMenu(actionStub);
        new InteractCalc(new Calculate(), new StubInput(Arrays.asList("0", "y")), menu).init();
        assertThat(actionStub.isCall(), is(true));
    }

}