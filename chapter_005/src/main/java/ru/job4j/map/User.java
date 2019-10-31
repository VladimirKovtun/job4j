package ru.job4j.map;

import java.util.Calendar;
import java.util.Objects;

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
    public boolean equals(Object obj) {
        return this == obj
                || obj != null
                && getClass() == obj.getClass()
                && Objects.equals(name, ((User)obj).name)
                && children == ((User) obj).children
                && Objects.equals(birthday, ((User) obj).birthday);
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
