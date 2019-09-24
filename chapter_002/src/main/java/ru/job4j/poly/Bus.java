package ru.job4j.poly;

public class Bus implements Transport {
   private double fuel;
   private int passengers;

   Bus(double fuel, int passengers) {
       this.fuel = fuel;
       this.passengers = passengers;
   }

    @Override
    public void drive() {
        System.out.println("Поехали!");
    }

    @Override
    public void passenger(int pass) {
        passengers += pass;

    }

    @Override
    public double charge(double fuel) {
        this.fuel += fuel;
        System.out.println("Стоимость литра солярки 45 руб.");
        System.out.println("У вас топлива: " + this.fuel);
        System.out.println("К оплате...");
        return fuel * 45;
    }

    public static void main(String[] args) {
        Bus bus = new Bus(20, 0);
        bus.drive();
        bus.passenger(13);
        double charge = bus.charge(20);
        System.out.println(charge);
    }
}
