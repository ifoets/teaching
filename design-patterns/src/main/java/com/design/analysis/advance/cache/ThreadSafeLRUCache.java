package com.design.analysis.advance.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class ThreadSafeLRUCache<K, V> {
    private final int capacity;
    private final Map<K, V> map;

    public ThreadSafeLRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<K, V>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > ThreadSafeLRUCache.this.capacity;
            }
        };
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    public synchronized void display() {
        System.out.println(map);
    }

    public static void main(String[] args) {
        ThreadSafeLRUCache<Integer, String> cache = new ThreadSafeLRUCache<>(3);

        Runnable writer = () -> {
            for (int i = 1; i <= 5; i++) {
                cache.put(i, "Value" + i);
                cache.display();
                try { Thread.sleep(50); } catch (InterruptedException ignored) {}
            }
        };

        Runnable reader = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Read key " + i + ": " + cache.get(i));
                try { Thread.sleep(50); } catch (InterruptedException ignored) {}
            }
        };

        Thread t1 = new Thread(writer);
        Thread t2 = new Thread(reader);
        t1.start();
        t2.start();
    }
}
