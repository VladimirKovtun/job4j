package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleStack<E> implements Iterable<E> {
    private SimpleArrayList<E> arrayList= new SimpleArrayList<>();;

    public void push(E data) {
        arrayList.add(data);
    }

    public E poll() {
        if (arrayList.getFirst() == null) {
            throw new NoSuchElementException();
        }
        return arrayList.delete();
    }

    public int getSize() {
        return arrayList.getSize();
    }

    @Override
    public Iterator<E> iterator() {
        return arrayList.iterator();
    }
}
