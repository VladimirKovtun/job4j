package ru.job4j.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> {
    private Object[] array;
    private int index = 0;

    public SimpleArray(int size) {
        array = new Object[size];
    }

    public void add(T model) {
        if (index > array.length - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        array[index++] = model;
    }

    public void set(int position, T model) {
        if (position > index - 1 && position < 0) {
            throw new IndexOutOfBoundsException();
        }
        array[position] = model;
    }

    public void remove(int position) {
        System.arraycopy(array, position + 1, array, position, this.index - position - 1);
        array[index-- - 1] = null;
    }

    public T get(int position) {
        return (T) array[position];
    }

    public Iterator<T> iterator() {
        return new SimpleArrayIteratorImpl();
    }

    private class SimpleArrayIteratorImpl implements Iterator<T> {
        private int cursor;

        @Override
        public boolean hasNext() {
            return cursor < index;
        }

        @Override
        public T next() {
            if (cursor > index - 1) {
                throw new NoSuchElementException();
            }
            return (T) array[cursor++];
        }
    }
}
