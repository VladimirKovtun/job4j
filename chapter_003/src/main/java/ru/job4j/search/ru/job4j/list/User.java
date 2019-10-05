package ru.job4j.search.ru.job4j.list;

import java.util.Random;

public class User {
    private int id;
    private String name;
    private String city;

    public User(String name, String city) {
        this.id = genersteId();
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int genersteId() {
        return new Random().nextInt(1000);
    }
}
