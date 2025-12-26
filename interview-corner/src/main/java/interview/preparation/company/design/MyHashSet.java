package interview.preparation.company.design;

public class MyHashSet {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private Node[] buckets;
    private int size = 0;

    static class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
        }
    }

    public MyHashSet() {
        buckets = new Node[DEFAULT_CAPACITY];
    }

    private int hash(int key) {
        return key % buckets.length;
    }

    public void add(int key) {
        int index = hash(key);
        Node head = buckets[index];

        // Check duplicate
        Node curr = head;
        while (curr != null) {
            if (curr.key == key) return;
            curr = curr.next;
        }

        // Insert at head
        Node node = new Node(key);
        node.next = head;
        buckets[index] = node;

        if ((double) size / buckets.length > LOAD_FACTOR) {
            resize();
        }

    }
    private void resize() {
        Node[] old = buckets;
        buckets = new Node[old.length * 2];
        size = 0;

        for (Node head : old) {
            while (head != null) {
                add(head.key);
                head = head.next;
            }
        }
    }
    public void remove(int key) {
        int index = hash(key);
        Node curr = buckets[index];
        Node prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    buckets[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public boolean contains(int key) {
        int index = hash(key);
        Node curr = buckets[index];
        while (curr != null) {
            if (curr.key == key) return true;
            curr = curr.next;
        }
        return false;
    }
}
