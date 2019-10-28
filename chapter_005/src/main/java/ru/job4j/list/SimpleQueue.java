package ru.job4j.list;

import java.util.NoSuchElementException;

public class SimpleQueue<E> {
    private SimpleStack<E> stackO;
    private SimpleStack<E> stackT;
    private int size;

    public SimpleQueue() {
        stackO = new SimpleStack<>();
        stackT = new SimpleStack<>();
    }

    public void push(E data) {
        Node<E> current = new Node<>(data);
        stackO.push(data);
        size++;
    }

    public E poll() {
        E data;
        int sizeStackT = stackT.getSize();
        int sizeStackO = stackO.getSize();
        if (sizeStackT == 0 && sizeStackO == 0) {
            throw new NoSuchElementException();
        }
        if (sizeStackT == 0) {
            for (int i = 0; i < sizeStackO; i++) {
                stackT.push(stackO.poll());
            }
            data = stackT.poll();
        } else {
            data = stackT.poll();
        }
        return data;
    }

    public int getSize() {
        return size;
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}
