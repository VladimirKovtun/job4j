package ru.job4j.lsp.parking;

public class Truck implements Vehicle {
    private final int n;

    public Truck(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }
}
