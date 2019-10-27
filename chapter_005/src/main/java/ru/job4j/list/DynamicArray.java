package ru.job4j.list;

import java.util.*;

public class DynamicArray<E> implements Iterable<E> {
    private int size;
    private int modCount;
    private Object[] container;

    public DynamicArray() {
        container = new Object[10];
    }

    public DynamicArray(int size) {
        container = new Object[size];
    }

    void add(E value) {
        if (check()) {
            extendContainer();
        }
        container[size++] = value;
        modCount++;
    }

    E get(int index) {
        return (E) container[index];
    }

    private boolean check() {
        return size == container.length;
    }

    private void extendContainer() {
        Object[] newContainer = new Object[(int) (container.length + container.length * 1.5)];
        System.arraycopy(container, 0, newContainer, 0, size);
        container = newContainer;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new DynamicArraeItrImpl();
    }

    private class DynamicArraeItrImpl implements Iterator<E> {
        int cursor;
        int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public E next() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (E) container[cursor++];
        }
    }
}
