package ru.job4j.sort;

import java.util.List;
import java.util.TreeSet;

public class SortUser {

    public TreeSet<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }
}
