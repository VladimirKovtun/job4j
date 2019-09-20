package ru.job4j.condition;

import ru.job4j.oop.Point;

public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point first, Point second, Point third) {
        this.a = first;
        this.b = second;
        this.c = third;
    }

    private boolean exist(Point a, Point b, Point c) {
        return a.distance(b) + b.distance(c) > c.distance(a) &&
                a.distance(b) + c.distance(a) > b.distance(c) &&
                b.distance(c) + c.distance(a) > a.distance(b);
    }

    private double period(Point a, Point b, Point c) {
        return (a.distance(b) + b.distance(c) + c.distance(a))/2;
    }

    public double square() {
        double result = - 1;
        if (exist(this.a, this.b, this.c)) {
            double period = period(this.a, this.b, this.c);
            result = Math.sqrt(period * (period - this.a.distance(this.b)) *
                               period * (period - this.b.distance(this.c)) *
                               period * (period - this.c.distance(this.a)));
        }
        return result;
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle(new Point(0,0),new Point(2,2),new Point(3,3));
        System.out.println(triangle.square());
    }
}
