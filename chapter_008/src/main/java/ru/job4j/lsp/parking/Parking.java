package ru.job4j.lsp.parking;

import ru.job4j.lsp.parking.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Parking implements IParking {
    private List<IVehicle> parkList = new ArrayList<>();
    private int carPlace;
    private int truckPlace;
    private final int carTruck;


    public Parking(int carPlace, int truckPlace, int carTruck) {
        this.carPlace = carPlace;
        this.truckPlace = truckPlace;
        this.carTruck = carTruck;
    }

    @Override
    public boolean addVehicle(IVehicle vehicle) {
        boolean successParking = false;
        if (vehicle.getCapacity() == carTruck) {
            if (truckPlace > 0) {
                parkList.add(vehicle);
                truckPlace--;
                successParking = true;
            } else if (carPlace >= carTruck) {
                parkList.add(vehicle);
                carPlace -= carTruck;
                successParking = true;
            }
        } else if (vehicle.getCapacity() == 1 && carPlace > 0) {
                parkList.add(vehicle);
                carPlace--;
                successParking = true;
        }
        return successParking;
    }

    public int getCarPlace() {
        return carPlace;
    }

    public int getTruckPlace() {
        return truckPlace;
    }
}
