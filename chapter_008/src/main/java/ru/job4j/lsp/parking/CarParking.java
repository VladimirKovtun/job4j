package ru.job4j.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class CarParking implements IParking {
    private final List<Car> carList;
    private int place;

    public CarParking(int place) {
        this.carList = new ArrayList<>();
        this.place = place;
    }

    @Override
    public boolean addCar(Vehicle vehicle) {
        return false;
    }

}
