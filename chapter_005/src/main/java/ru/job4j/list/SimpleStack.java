package ru.job4j.list;

import java.util.NoSuchElementException;

public class SimpleStack<E> {

    private int size;
    private Node<E> first;

    public void push(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = first;
        first = newLink;
        size++;
    }

    public E poll() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        E data = first.data;
        first = first.next;
        size--;
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
