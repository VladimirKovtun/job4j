package ru.job4j.list;

import java.util.NoSuchElementException;

public class SimpleQueue<E> {
    private SimpleStack<E> first;
    private SimpleStack<E> second;
    private int size;

    public SimpleQueue() {
        first = new SimpleStack<>();
        second = new SimpleStack<>();
    }

    public void push(E data) {
        first.push(data);
        size++;
    }

    public E poll() {
        /*E data;
        int sizeStackT = second.getSize();
        int sizeStackO = first.getSize();
        if (sizeStackT == 0 && sizeStackO == 0) {
            throw new NoSuchElementException();
        }*/
        if (second.getSize() == 0) {
            for (E value : first) {
                second.push(value);
            }
        }
        /*if (sizeStackT == 0) {
            for (int i = 0; i < sizeStackO; i++) {
                second.push(first.poll());
            }
            data = second.poll();
        } else {
            data = second.poll();
        }
        return data;*/
        return second.poll();
    }

    public int getSize() {
        return size;
    }
}
