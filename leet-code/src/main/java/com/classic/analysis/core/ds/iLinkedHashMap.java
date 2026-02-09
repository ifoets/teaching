package com.classic.analysis.core.ds;

public class iLinkedHashMap <K, V> {
    static class Node<K, V> {
        K key;
        V value;

        Node<K, V> next;      // hash collision chain
        Node<K, V> prevOrder; // linked list
        Node<K, V> nextOrder;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    private static final int CAPACITY = 16;

    private Node<K, V>[] buckets;
    private Node<K, V> head, tail;
    private boolean accessOrder;

    @SuppressWarnings("unchecked")
    public iLinkedHashMap(boolean accessOrder) {
        this.accessOrder = accessOrder;
        buckets = new Node[CAPACITY];
    }

    private int index(K key) {
        return (key == null) ? 0 :
            Math.abs(key.hashCode()) % buckets.length;
    }

    public V get(K key) {
        int idx = index(key);
        Node<K, V> curr = buckets[idx];

        while (curr != null) {
            if (keyEquals(curr.key, key)) {
                if (accessOrder) moveToTail(curr);
                return curr.value;
            }
            curr = curr.next;
        }
        return null;
    }

    public void put(K key, V value) {
        int idx = index(key);
        Node<K, V> curr = buckets[idx];

        while (curr != null) {
            if (keyEquals(curr.key, key)) {
                curr.value = value;
                if (accessOrder) moveToTail(curr);
                return;
            }
            curr = curr.next;
        }

        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = buckets[idx];
        buckets[idx] = newNode;

        addToTail(newNode);
    }

    public void remove(K key) {
        int idx = index(key);
        Node<K, V> curr = buckets[idx], prev = null;

        while (curr != null) {
            if (keyEquals(curr.key, key)) {
                if (prev == null) buckets[idx] = curr.next;
                else prev.next = curr.next;

                removeFromList(curr);
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    private void addToTail(Node<K, V> node) {
        if (tail == null) {
            head = tail = node;
            return;
        }
        tail.nextOrder = node;
        node.prevOrder = tail;
        tail = node;
    }

    private void moveToTail(Node<K, V> node) {
        if (node == tail) return;
        removeFromList(node);
        addToTail(node);
    }

    private void removeFromList(Node<K, V> node) {
        if (node.prevOrder != null)
            node.prevOrder.nextOrder = node.nextOrder;
        else
            head = node.nextOrder;

        if (node.nextOrder != null)
            node.nextOrder.prevOrder = node.prevOrder;
        else
            tail = node.prevOrder;

        node.prevOrder = node.nextOrder = null;
    }

    private boolean keyEquals(K k1, K k2) {
        return (k1 == null && k2 == null) ||
            (k1 != null && k1.equals(k2));
    }
}