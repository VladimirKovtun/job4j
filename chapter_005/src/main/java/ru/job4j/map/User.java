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

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (name == null ? 0 : name.hashCode());
        result = 31 * result + children;
        result = 31 * result + (birthday == null ? 0 : birthday.hashCode());
        return result;
    }
}
