package ru.job4j.calculate;

import org.junit.Assert;
import org.junit.Test;

public class FitTest {

    @Test
    public void manWeight() {
        double in = 200;
        double expected = 115;
        double out = Fit.manWeight(in);
        Assert.assertEquals(expected, out, 0.0001);
    }

    @Test
    public void womenWeight() {
        double in = 210d;
        double expected = 115d;
        double out = Fit.womanWeight(in);
        Assert.assertEquals(expected, out, 0.0001);
    }
}
