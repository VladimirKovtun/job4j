package ru.job4j.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class TruckParking implements IParking {
    private final List<Truck> truckList;
    private int place;

    public TruckParking(int place) {
        this.truckList = new ArrayList<>();
        this.place = place;
    }

    @Override
    public boolean addCar(Vehicle vehicle) {
        return false;
    }
}
