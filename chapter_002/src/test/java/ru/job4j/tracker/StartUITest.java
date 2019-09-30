package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class StartUITest {

    @Test
    public void whenExit() {
        StubAction stubAction = new StubAction(0, "Stub action.");
        new StartUI().init(new StubInput(new String[]{"0"}), new Tracker(), new BaseAction[] {stubAction});
        Assert.assertThat(stubAction.isCall(), Is.is(true));
    }
}
