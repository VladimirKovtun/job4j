package ru.job4j.list;

public class SimpleQueue<E> {
    private SimpleStack<E> first = new SimpleStack<>();
    private SimpleStack<E> second = new SimpleStack<>();
    private int size;

    public void push(E data) {
        first.push(data);
        size++;
    }

    public E poll() {
        if (second.getSize() == 0) {
            for (E value : first) {
                second.push(value);
            }
        }
        return second.poll();
    }

    public int getSize() {
        return size;
    }
}
