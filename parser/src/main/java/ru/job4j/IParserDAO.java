package ru.job4j;

import java.time.LocalDateTime;
import java.util.List;

public interface IParserDAO<T> {

    T create(T t);
    void createAll(List<T> list);
    T getId(int id);
    List<T> getAll();
    boolean update(int id, T t);
    LocalDateTime getLastTime();
}
