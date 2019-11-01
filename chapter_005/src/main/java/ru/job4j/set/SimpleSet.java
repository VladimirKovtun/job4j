package ru.job4j.set;


import ru.job4j.list.DynamicArray;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {
    private final DynamicArray<E> array = new DynamicArray<>();

    public boolean add(E value) {
        boolean rst = false;
        if (!contains(value)) {
            array.add(value);
            rst = true;
        }
        return rst;
    }

    private boolean contains(E value) {
        boolean rst = false;
        for (E data : array) {
            if (data.equals(value)) {
                rst = true;
            }
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
