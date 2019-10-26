package ru.job4j.generic;

public interface Store <T extends Base> {

    public void add(T model);

    public boolean replace(String id, T model);

    public boolean delete(String id);

    T findById(String id);
}
