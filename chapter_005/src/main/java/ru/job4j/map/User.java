package ru.job4j.map;

import java.util.Calendar;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar calendar) {
        this.name = name;
        this.children = children;
        this.birthday = calendar;
    }
}
