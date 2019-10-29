package ru.job4j.set;


import ru.job4j.list.DynamicArray;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {
    private final DynamicArray<E> array = new DynamicArray<>();
    private int size;

    public boolean add(E value) {
        boolean rst = true;
        for (E data : array) {
            if (data.hashCode() == value.hashCode() && data.equals(value)) {
                rst = false;
            }
        }
        if (rst) {
            array.add(value);
        }
        return rst;
    }

    public int getSize() {
        return array.getSize();
    }

    @Override
    public Iterator<E> iterator() {
        return array.iterator();
    }
}
