package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartUITest {

    @Test
    public void whenExit() {
        StubAction stubAction = new StubAction(0, "Stub action.");
        List<BaseAction> actions = new ArrayList<>();
        actions.add(stubAction);
        new StartUI().init(new StubInput(Arrays.asList("0")), new Tracker(), actions);
        Assert.assertThat(stubAction.isCall(), Is.is(true));
    }
}
