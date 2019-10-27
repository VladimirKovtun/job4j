package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterable {
    private final int[][] matrix;

    public MatrixIterator(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public Iterator iterator() {
        return new MatrixItr();
    }

     class MatrixItr implements Iterator {
        private int cursorX;
        private int cursorY;

        @Override
        public boolean hasNext() {
            return cursorY < matrix.length && cursorX < matrix[cursorY].length;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int current = matrix[cursorY][cursorX++];
            if (cursorX == matrix[cursorY].length) {
                cursorY++;
                cursorX = 0;
            }

            return current;
        }
    }
}
