package ru.job4j.lsp.parking;

public class Parking implements IParking {
    private final CarParking carParking;
    private final TruckParking truckParking;

    public Parking(int carPlace, int truckPlace) {
        this.carParking = new CarParking(carPlace);
        this.truckParking = new TruckParking(truckPlace);
    }

    @Override
    public boolean addCar(Vehicle vehicle) {
        return false;
    }
}
