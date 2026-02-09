package com.classic.analysis.core.ds;

public class IHashSet<E> {

    static class Node<E> {
        E key;
        Node<E> next;

        Node(E key) {
            this.key = key;
        }
    }
        private static final int DEFAULT_CAPACITY = 16;
        private static final float LOAD_FACTOR = 0.75f;

        private Node<E>[] buckets;
        private int size;

    @SuppressWarnings("unchecked")
    public IHashSet () {
            buckets = new Node[DEFAULT_CAPACITY];
            size = 0;
        }

        private int getIndex(E key) {
            return (key == null) ? 0 :
                Math.abs(key.hashCode()) % buckets.length;
        }

        public void add(E key) {
            int index = getIndex(key);
            Node<E> curr = buckets[index];

            while (curr != null) {
                if ((key == null && curr.key == null) ||
                    (key != null && key.equals(curr.key))) {
                    return; // already exists
                }
                curr = curr.next;
            }

            Node<E> newNode = new Node<>(key);
            newNode.next = buckets[index];
            buckets[index] = newNode;
            size++;

            if ((float) size / buckets.length >= LOAD_FACTOR) {
                resize();
            }
        }

        public boolean contains(E key) {
            int index = getIndex(key);
            Node<E> curr = buckets[index];

            while (curr != null) {
                if ((key == null && curr.key == null) ||
                    (key != null && key.equals(curr.key))) {
                    return true;
                }
                curr = curr.next;
            }
            return false;
        }

        public void remove(E key) {
            int index = getIndex(key);
            Node<E> curr = buckets[index];
            Node<E> prev = null;

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
            Node<E>[] oldBuckets = buckets;
            buckets = new Node[oldBuckets.length * 2];
            size = 0;

            for (Node<E> head : oldBuckets) {
                Node<E> curr = head;
                while (curr != null) {
                    add(curr.key);
                    curr = curr.next;
                }
            }
        }
}
