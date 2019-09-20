package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int capacity) {
        load = capacity;
    }

    public int showCapacity() {
        return this.load;
    }

    public void exchange(Battery another) {
        this.load += another.load;
        another.load = 0;
    }

    public static void main(String[] args) {
        Battery powerBank = new Battery(2000);
        Battery myPhone = new Battery(500);
        myPhone.exchange(powerBank);
        System.out.println("My phone capacity: " + myPhone.showCapacity());
        System.out.println("PowerBank capacity: " + powerBank.showCapacity());
    }
}
