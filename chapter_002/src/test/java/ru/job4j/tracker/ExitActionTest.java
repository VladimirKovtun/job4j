package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

public class ExitActionTest {

    @Test
    public void whenExit() {
        boolean result = new ExitAction(0, "Exit program.").execute(new Tracker(), new StubInput(new String[0]));
        Assert.assertFalse(result);
    }
}
