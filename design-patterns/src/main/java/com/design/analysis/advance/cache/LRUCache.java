package com.design.analysis.advance.cache;

import java.util.LinkedHashMap;
import java.util.Map;
/**
LRU Behavior in LinkedHashMap
To enable LRU-like behavior, you must:

Use the constructor with accessOrder = true

Override removeEldestEntry() to enforce the capacity limit
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true); // true = accessOrder (not insertion order)
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public V getCache(K key) {
        return super.get(key);
    }

    public void putCache(K key, V value) {
        super.put(key, value);
    }

    public void display() {
        System.out.println(super.toString());
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.putCache(1, "One");
        cache.putCache(2, "Two");
        cache.putCache(3, "Three");
        cache.display(); // {1=One, 2=Two, 3=Three}

        cache.getCache(1); // Access key 1
        cache.display();
        cache.putCache(4, "Four"); // Evicts key 2
        cache.display(); // {3=Three, 1=One, 4=Four}

        cache.getCache(3);
        cache.display();

        cache.getCache(1);
        cache.display();
    }
}