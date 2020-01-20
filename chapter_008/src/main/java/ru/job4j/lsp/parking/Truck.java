package ru.job4j.lsp.parking;

public class Truck implements IVehicle {
    private final int capacity;

    public Truck(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }
}
