package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> implements Iterable<SimpleHashMap.Node<K, V>> {
    private final static float LOADFACTOR = 0.75f;
    private int capacity;
    private Node<K, V>[] tableMap;
    private int size;
    private int modCount;

    public SimpleHashMap() {
        this.capacity = 16;
        tableMap = (Node<K, V>[]) new Node[capacity];
    }

    public SimpleHashMap(int capacity) {
        this.capacity = capacity;
        tableMap = (Node<K, V>[]) new Node[capacity];
    }

    public boolean insert(K key, V value) {
        boolean rst = true;
        Node<K, V> currentNode;
        if (getLoadFactor() >= LOADFACTOR) {
            resize();
        }
        int index = indexTable(key);
        if (tableMap[index] == null) {
            tableMap[index] = new Node<>(key, value, null, key.hashCode());
            size++;
        } else {
            currentNode = tableMap[index];
            while (currentNode != null) {
                if (currentNode.hash == key.hashCode()
                        && (currentNode.key == key || (currentNode.key.equals(key)))) {
                    currentNode.value = value;
                    break;
                }
                if (currentNode.next == null) {
                    currentNode.next = new Node<>(key, value, null, key.hashCode());
                    size++;
                    break;
                }
                currentNode = currentNode.next;
            }
        }
        modCount++;
        return rst;
    }

    public V get(K key) {
        V value = null;
        int index = indexTable(key);
        Node<K, V> current = tableMap[index];
        if (current != null) {
            while (current != null) {
                if (current.hash == key.hashCode()
                        && (current.key == key || (current.key.equals(key)))) {
                    value = current.value;
                    break;
                }
                current = current.next;
            }
        }
        return value;
    }

    public boolean remove(K key) {
        int index = indexTable(key);
        Node<K, V> currentNode = tableMap[index];
        Node<K, V> node = null, nextNode;
        if (currentNode != null) {
            if (currentNode.hash == key.hashCode() && (currentNode.key == key
                    || (key.equals(currentNode.key)))) {
                node = currentNode;
            } else if (currentNode.next != null) {
                nextNode = currentNode.next;
                do {
                    if (nextNode.hash == key.hashCode()
                            && ((nextNode.key == key
                            || (key.equals(nextNode.key))))) {
                        node = nextNode;
                        break;
                    }
                    currentNode = nextNode;
                    nextNode = nextNode.next;
                } while (nextNode != null);
            }
            if (node != null) {
                if (node == currentNode) {
                    tableMap[index] = node.next;
                } else {
                    currentNode.next = node.next;
                }
                ++modCount;
                --size;
            }
        }
        return node != null;
    }

    private void resize() {
        capacity = capacity * 2 + 1;
        var oldTableMap = tableMap;
        size = 0;
        tableMap = (Node<K, V>[]) new Node[capacity];
        for (int i = 0; i < oldTableMap.length; i++) {
            if (oldTableMap[i] != null) {
                Node<K, V> current = oldTableMap[i];
                while (current != null) {
                    insert(current.key, current.value);
                    current = current.next;
                }
            }
        }
    }

    private double getLoadFactor() {
        return size / capacity;
    }

    private int indexTable(K key) {
        return key.hashCode() & (capacity - 1);
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new SimpleHashMapItrImpl();
    }

    static class Node<K, V> {
        private final int hash;
        private K key;
        private V value;
        Node<K, V> next;

        private Node(K key, V value, Node<K, V> next, int hash) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = hash;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    private class SimpleHashMapItrImpl implements Iterator<Node<K, V>> {
        int cursor;
        int expectModCount = modCount;
        Node<K, V> current = tableMap[cursor];

        @Override
        public boolean hasNext() {
            while ((cursor < (capacity - 1)) && current == null) {
                current = tableMap[++cursor];
            }
            return current != null;
        }

        @Override
        public Node<K, V> next() {
            if (expectModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node<K, V> data = current;
            if (current.next != null) {
                current = current.next;
            } else {
                while ((cursor < (capacity - 1))) {
                    current = tableMap[++cursor];
                    if (current != null) {
                        break;
                    }
                }
            }
            return data;
        }
    }
}
