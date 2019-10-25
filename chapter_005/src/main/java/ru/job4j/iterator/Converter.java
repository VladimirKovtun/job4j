package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {

    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<>() {
            Iterator<Integer> inner = it.hasNext() ? it.next() : null;

            @Override
            public boolean hasNext() {
                return inner != null && inner.hasNext();
            }

            @Override
            public Integer next() {
                if (inner == null) {
                    throw new NoSuchElementException();
                }
                Integer in = inner.next();
                if (!inner.hasNext()) {
                    inner = it.hasNext() ? it.next() : null;
                }
                return in;
            }
        };
    }
}
