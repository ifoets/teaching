package com.classic.analysis.core.ds;

public class IHashMap<K, V> {

    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

        private static final int DEFAULT_CAPACITY = 16;
        private static final float LOAD_FACTOR = 0.75f;

        private Node<K, V>[] buckets;
        private int size;

    @SuppressWarnings("unchecked")
    public IHashMap() {
            buckets = new Node[DEFAULT_CAPACITY];
            size = 0;
        }

        private int getIndex(K key) {
            return (key == null) ? 0 :
                Math.abs(key.hashCode()) % buckets.length;
        }

        public void put(K key, V value) {
            int index = getIndex(key);
            Node<K, V> head = buckets[index];

            // Check if key already exists
            Node<K, V> curr = head;
            while (curr != null) {
                if ((key == null && curr.key == null) ||
                    (key != null && key.equals(curr.key))) {
                    curr.value = value;
                    return;
                }
                curr = curr.next;
            }

            // Insert at head
            Node<K, V> newNode = new Node<>(key, value);
            newNode.next = head;
            buckets[index] = newNode;
            size++;

            if ((float) size / buckets.length >= LOAD_FACTOR) {
                resize();
            }
        }

        public V get(K key) {
            int index = getIndex(key);
            Node<K, V> curr = buckets[index];

            while (curr != null) {
                if ((key == null && curr.key == null) ||
                    (key != null && key.equals(curr.key))) {
                    return curr.value;
                }
                curr = curr.next;
            }
            return null;
        }

        public void remove(K key) {
            int index = getIndex(key);
            Node<K, V> curr = buckets[index];
            Node<K, V> prev = null;

            while (curr != null) {
                if ((key == null && curr.key == null) ||
                    (key != null && key.equals(curr.key))) {
                    if (prev == null) {
                        buckets[index] = curr.next;
                    } else {
                        prev.next = curr.next;
                    }
                    size--;
                    return;
                }
                prev = curr;
                curr = curr.next;
            }
        }

        @SuppressWarnings("unchecked")
        private void resize() {
            Node<K, V>[] oldBuckets = buckets;
            buckets = new Node[oldBuckets.length * 2];
            size = 0;

            for (Node<K, V> head : oldBuckets) {
                Node<K, V> curr = head;
                while (curr != null) {
                    put(curr.key, curr.value);
                    curr = curr.next;
                }
            }
        }
    }
