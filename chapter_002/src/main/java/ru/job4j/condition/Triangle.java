package ru.job4j.condition;

public class Triangle {
    private Point a;
    private Point b;
    private Point c;
    private double ab;
    private double bc;
    private double ca;

    public Triangle(Point first, Point second, Point third) {
        this.a = first;
        this.b = second;
        this.c = third;
        ab = a.distance(b);
        bc = b.distance(c);
        ca = c.distance(a);
    }

    private boolean exist() {
        return ab + bc > ca
               && ab + ca > bc
               && bc + ca > ab;
    }

    private double period() {
        return (ab + bc + ca) / 2;
    }

    public double square() {
        double result = -1;
        if (exist()) {
            result = Math.sqrt(period() * (period() - ab)
                               * period() * (period() - bc)
                               * period() * (period() - ca));
        }
        return result;
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(2, 2), new Point(3, 3));
        System.out.println(triangle.square());
    }
}
