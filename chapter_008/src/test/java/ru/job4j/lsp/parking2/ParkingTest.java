package ru.job4j.lsp.parking2;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void whenPlaceExistsThenParked() {
        Parking parking = new Parking(1, 1, 2);
        Car car = new Car();
        Truck truck = new Truck(2);
        assertTrue(parking.addVehicle(car));
        assertTrue(parking.addVehicle(truck));
    }

    @Test
    public void whenCarAndTruckNotParking() {
        Parking parking = new Parking(0, 0, 2);
        Car car = new Car();
        Truck truck = new Truck(2);
        assertFalse(parking.addVehicle(car));
        assertFalse(parking.addVehicle(truck));
    }

    @Test
    public void whenTruckPlaceNotExistButCarPlaceExistThenTruckGetParking() {
        Parking parking = new Parking(2, 0, 2);
        Truck truck = new Truck(2);
        assertTrue(parking.addVehicle(truck));
    }

    @Test
    public void whenExistsOneCarPlaceAndOneTruckPlaceThenAfterParkingZeroLeft() {
        Parking parking = new Parking(1, 1, 2);
        Truck truck = new Truck(2);
        Car car = new Car();
        parking.addVehicle(car);
        parking.addVehicle(truck);
        assertThat(parking.getTruckPlace(), is(0));
        assertThat(parking.getCarPlace(), is(0));
    }

    @Test
    public void whenTwoCarPlaceAndZeroTruckPlaceThenAfterTruckParkedZeroCarPlaceLeft() {
        Parking parking = new Parking(2, 0, 2);
        Truck truck = new Truck(2);
        parking.addVehicle(truck);
        assertThat(parking.getCarPlace(), is(0));
    }

}