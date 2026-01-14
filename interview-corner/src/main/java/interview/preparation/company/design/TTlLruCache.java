package interview.preparation.company.design;

import java.util.HashMap;
import java.util.Map;

public class TTlLruCache<K, V> {
    private static int capacity;
    private final Map<K, Node<K, V>> map = new HashMap<>();
    private final Node<K, V> head = new Node<>();
    private final Node<K, V> tail = new Node<>();

    private static class Node<K, V> {
        K key;
        V value;
        long expireAt;
        Node<K, V> prev;
        Node<K, V> next;

        Node() {}  // sentinel nodes

        Node(K key, V value, long expireAt) {
            this.key = key;
            this.value = value;
            this.expireAt = expireAt;
        }
    }
    public TTlLruCache(int capacity) {
        TTlLruCache.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) return null;

        if (node.expireAt < System.currentTimeMillis()) {
            remove(node);
            map.remove(key);
            return null;
        }

        moveToHead(node);
        return node.value;
    }

    public void put(K key, V value, long ttlMillis) {
        long expireAt = System.currentTimeMillis() + ttlMillis;

        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            node.value = value;
            node.expireAt = expireAt;
            moveToHead(node);
            return;
        }

        if (map.size() >= capacity) {
            evictExpiredOrLRU();
        }

        Node<K, V> node = new Node<>(key, value, expireAt);
        addToHead(node);
        map.put(key, node);
    }

    private void evictExpiredOrLRU() {
        Node<K, V> node = tail.prev;
        if (node != head && node.expireAt < System.currentTimeMillis()) {
            remove(node);
            map.remove(node.key);
        } else {
            remove(node);
            map.remove(node.key);
        }
    }
    private void moveToHead(Node<K, V> node) {
        remove(node);
        addToHead(node);
    }
    private void addToHead(Node<K, V> node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    // LRU helpers omitted for brevity
}