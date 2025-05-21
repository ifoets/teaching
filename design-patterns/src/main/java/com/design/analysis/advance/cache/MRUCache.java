package com.design.analysis.advance.cache;
import java.util.*;

public class MRUCache<K, V> {
    private final int capacity;
    private final Map<K, V> map;
    private final Deque<K> usageOrder;

    public MRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.usageOrder = new LinkedList<>();
    }

    public V get(K key) {
        if (!map.containsKey(key)) return null;

        usageOrder.remove(key);       // Move to the end (most recently used)
        usageOrder.addLast(key);

        return map.get(key);
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            usageOrder.remove(key);
            usageOrder.addLast(key);
            return;
        }

        if (map.size() >= capacity) {
            K mostRecentlyUsed = usageOrder.removeLast(); // Remove MRU
            map.remove(mostRecentlyUsed);
        }

        map.put(key, value);
        usageOrder.addLast(key);
    }

    public void display() {
        System.out.print("Cache [MRU --> LRU]: ");
        ListIterator<K> it = ((LinkedList<K>) usageOrder).listIterator(usageOrder.size());
        while (it.hasPrevious()) {
            K key = it.previous();
            System.out.print(key + "=" + map.get(key) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MRUCache<Integer, String> cache = new MRUCache<>(3);

        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        cache.display(); // Should show: 3=Three 2=Two 1=One

        cache.get(2);    // 2 is now MRU
        cache.put(4, "Four"); // Evicts 2 (most recently used)
        cache.display(); // Should show: 4=Four 3=Three 1=One
    }
}