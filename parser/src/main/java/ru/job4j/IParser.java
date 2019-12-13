package ru.job4j;

import java.util.List;

public interface IParser<T> {

    T create(T t);
    void createAll(List<T> list);
    T getId(int id);
    List<T> getAll();
    boolean update(int id, T t);
    boolean delete(int id);
}
