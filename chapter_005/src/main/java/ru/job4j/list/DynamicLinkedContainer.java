package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicLinkedContainer<E> implements Iterable<E> {
    private int size;
    private int modCount;
    private Node<E> first;

    public void add(E value) {
        Node<E> current = new Node<>(value);
        if (first == null) {
            first = current;

        } else {
            Node<E> temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = current;
        }
        modCount++;
        size++;
    }

    public E get(int index) {
        int count = 0;
        Node<E> current = first;
        while (current.next != null) {
            if (count == index) {
                break;
            }
            current = current.next;
            count++;
        }
        if (index > count) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return current.data;
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
    @Override
    public Iterator<E> iterator() {
        return new DynamicLinkedContainerItrImpl();
    }

    public int getSize() {
        return size;
    }

    private class DynamicLinkedContainerItrImpl implements Iterator<E> {
        int expModCount = modCount;
        Node<E> current = first;

        @Override
        public boolean hasNext() {
            return current != null && current.next != null;
        }

        @Override
        public E next() {
            if (expModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (current == null) {
                throw new NoSuchElementException();
            }
            E data = current.data;
            current = current.next;
            return data;
        }
    }
}
