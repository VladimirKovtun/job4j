package ru.job4j.oop;

public class College {

    public static void main(String[] args) {
        Student stFreshmen = new FreshMan(); //downcasting
        Object objStFresh = stFreshmen; //downcasting
        FreshMan freshMan = (FreshMan) objStFresh; //upcasting
        System.out.println(freshMan);
    }
}
