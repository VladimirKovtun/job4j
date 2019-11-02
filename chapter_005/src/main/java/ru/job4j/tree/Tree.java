package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private final Node<E> root;
    private int size;
    private int modCount;

    public Tree(Node<E> root) {
        this.root = root;
    }

    @Override
    public boolean add(E parent, E children) {
        boolean rst = false;
        if (findBy(parent).isPresent() && findBy(children).isEmpty()) {
            findBy(parent).get().leaves().add(new Node<>(children));
            rst = true;
            size++;
            modCount++;
        }
        return rst;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rs1 = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        while (!data.isEmpty()) {
            Node<E> e1 = data.poll();
            if (e1.eqValue(value)) {
                rs1 = Optional.of(e1);
                break;
            }
            for (Node<E> child : e1.leaves()) {
                data.offer(child);
            }
        }
        return rs1;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleTreeItrImpl();
    }

    private class SimpleTreeItrImpl implements Iterator<E> {
        int expectModCount = modCount;
        Queue<Node<E>> data = new LinkedList<>();
        Node<E> current = root;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (expectModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E value = current.value;
            if (!current.leaves().isEmpty()){
                for (Node<E> child : current.leaves()) {
                    data.offer(child);
                }
            }
            current = data.isEmpty() ? null : data.poll();
            return value;
        }
    }

    public static class Node<E extends Comparable<E>> {
        private final List<Node<E>> children = new ArrayList<>();
        private final E value;

        public Node(E value) {
            this.value = value;
        }

        public void add(Node<E> child) {
            children.add(child);
        }

        public List<Node<E>> leaves() {
            return children;
        }

        public boolean eqValue(E that) {
            return value.compareTo(that) == 0;
        }
    }
}
