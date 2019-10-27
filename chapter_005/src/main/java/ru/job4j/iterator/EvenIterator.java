package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterable {
    private final int[] numbers;

    public EvenIterator(int[] numbers) {
        this.numbers = numbers;
    }

    private class EvenItrImpl implements Iterator {
        private int cursor;

        @Override
        public boolean hasNext() {
            boolean has = false;
            while (cursor < numbers.length) {
                if (numbers[cursor] % 2 == 0) {
                    has = true;
                    break;
                }
                cursor++;
            }
            return has;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return numbers[cursor++];
        }
    }
    @Override
    public Iterator iterator() {
        return new EvenItrImpl();
    }
}
