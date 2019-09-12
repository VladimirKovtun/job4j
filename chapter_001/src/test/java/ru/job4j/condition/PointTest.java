package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void distance(){
        int inX1 = 1;
        int inX2 = 2;
        int inY1 = 1;
        int inY2 = 2;
        double expected = 1.4;
        double out = Point.distance(inX1,inY1,inX2,inY2);
        Assert.assertEquals(expected,out,0.1);
    }
}
