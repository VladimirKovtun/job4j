package ru.job4j.condition;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

    @Test
    public void whenTriangleExistThenSquare() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(2, 0), new Point(0, 2));
        double result = triangle.square();
        double expect = 6.8284;
        Assert.assertEquals(result, expect, 0.001);
    }

    @Test
    public void whenTriangleNotExist() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(2, 2), new Point(2, 2));
        double result = triangle.square();
        Assert.assertThat(result, Is.is(-1.0));
    }
}
