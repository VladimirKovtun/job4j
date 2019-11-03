package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;
    private int size;
    private int modCount;

    public Tree(Node<E> root) {
        this.root = root;
    }

    @Override
    public boolean add(E parent, E children) {
        boolean rst = false;
        Node<E> parentNode = findBy(parent).orElse(null);
        if (parentNode != null && findBy(children).isEmpty()) {
            parentNode.add(new Node<>(children));
            rst = true;
        } else if (findBy(children).isEmpty()) {
            Node<E> newRoot = new Node<>(children);
            newRoot.add(root);
            root = newRoot;
            rst = true;
        }
        if (rst) {
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

    public boolean isBinary() {
        boolean rst = true;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        while (!data.isEmpty()) {
            Node<E> e1 = data.poll();
            if (e1.leaves().size() > 2) {
                rst = false;
                break;
            }
            for (Node<E> child : e1.leaves()) {
                data.offer(child);
            }
        }
        return rst;
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
            E value = current.getValue();
            if (!current.leaves().isEmpty()) {
                for (Node<E> child : current.leaves()) {
                    data.offer(child);
                }
            }
            current = data.isEmpty() ? null : data.poll();
            return value;
        }
    }
}
