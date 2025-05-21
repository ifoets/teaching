package com.design.analysis.advance.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class FIFOCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public FIFOCache(int capacity) {
        super(capacity, 0.75f, false); // false = insertion order
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public V getCache(K key) {
        return super.getOrDefault(key, null);
    }

    public void putCache(K key, V value) {
        super.put(key, value);
    }

    public void display() {
        System.out.println(super.toString());
    }

    // Example usage
    public static void main(String[] args) {
        FIFOCache<Integer, String> cache = new FIFOCache<>(3);

        cache.putCache(1, "One");
        cache.putCache(2, "Two");
        cache.putCache(3, "Three");
        cache.display(); // {1=One, 2=Two, 3=Three}

        cache.putCache(4, "Four"); // Evicts key 1 (FIFO)
        cache.display(); // {2=Two, 3=Three, 4=Four}
    }
}