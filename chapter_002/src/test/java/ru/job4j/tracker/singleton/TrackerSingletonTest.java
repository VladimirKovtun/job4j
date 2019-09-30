package ru.job4j.tracker.singleton;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.sigleton.TrackerSingletonFour;
import ru.job4j.tracker.sigleton.TrackerSingletonOne;
import ru.job4j.tracker.sigleton.TrackerSingletonThree;
import ru.job4j.tracker.sigleton.TrackerSingletonTwo;

public class TrackerSingletonTest {

    @Test
    public void whenTrackerSingletonOneIsSingleton() {
        TrackerSingletonOne first = TrackerSingletonOne.INSTANCE;
        TrackerSingletonOne second = TrackerSingletonOne.INSTANCE;
        Assert.assertThat(first, Is.is(second));
    }

    @Test
    public void whenTrackerSingletonTwoIsSingleton() {
        TrackerSingletonTwo first = TrackerSingletonTwo.getInstance();
        TrackerSingletonTwo second = TrackerSingletonTwo.getInstance();
        Assert.assertThat(first, Is.is(second));
    }

    @Test
    public void whenTrackerSingletonThreeIsSingleton() {
        TrackerSingletonThree first = TrackerSingletonThree.getInstance();
        TrackerSingletonThree second = TrackerSingletonThree.getInstance();
        Assert.assertThat(first, Is.is(second));
    }

    @Test
    public void whenTrackerSingletonFourIsSingleton() {
        TrackerSingletonFour first = TrackerSingletonFour.getInstance();
        TrackerSingletonFour second = TrackerSingletonFour.getInstance();
        Assert.assertThat(first, Is.is(second));
    }
}
