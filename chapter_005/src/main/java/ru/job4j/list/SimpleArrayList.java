package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayList<E> implements Iterable<E> {
    private int size;
    private Node<E> first;
    private int modCount;
//1
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = first;
        first = newLink;
        size++;
        modCount++;
    }

    public E delete() {
        E removed = first.data;
        first = first.next;
        size--;
        modCount++;
        return removed;
    }

    public E get(int index) {
        Node<E> result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    public Node<E> getFirst() {
        return first;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleArraYListIterImpl();
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    private class SimpleArraYListIterImpl implements Iterator<E> {
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
