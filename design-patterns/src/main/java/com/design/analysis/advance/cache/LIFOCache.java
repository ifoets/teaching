package com.design.analysis.advance.cache;

import java.util.*;

public class LIFOCache<K, V> {
    private final int capacity;
    private final Map<K, V> map;
    private final Deque<K> stack; // Acts like a stack (LIFO)

    public LIFOCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.stack = new LinkedList<>();
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            stack.remove(key);
        } else if (map.size() >= capacity) {
            K lastInKey = stack.removeLast(); // Remove most recently added
            map.remove(lastInKey);
        }
        stack.addLast(key);
        map.put(key, value);
    }

    public V get(K key) {
        return map.getOrDefault(key, null);
    }

    public void display() {
        for (K key : stack) {
            System.out.print(key + "=" + map.get(key) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LIFOCache<Integer, String> cache = new LIFOCache<>(3);

        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        cache.display(); // 1=One 2=Two 3=Three

        cache.put(4, "Four"); // Evicts 3 (last in)
        cache.display(); // 1=One 2=Two 4=Four
    }
}