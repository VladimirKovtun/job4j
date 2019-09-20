package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void thatAndThisDistance() {
        Point point = new Point(0, 1);
        double result = point.distance(new Point(2, 1));
        Assert.assertEquals(result, 2d, 0.1);
    }

    @Test
    public void thatAndThisDistance3d() {
        Point point = new Point(0, 1, 0);
        double result = point.distance(new Point(2, 1, 0));
        Assert.assertEquals(result, 2d, 0.1);
    }
}
