package com.design.analysis.advance.cache;

import java.util.*;

public class LFUCache<K, V> {
    private final int capacity;
    private int minFrequency;

    private final Map<K, V> valueMap;               // Key -> Value
    private final Map<K, Integer> frequencyMap;     // Key -> Frequency
    private final Map<Integer, LinkedHashSet<K>> freqBucketMap; // Frequency -> Keys with that frequency

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;
        this.valueMap = new HashMap<>();
        this.frequencyMap = new HashMap<>();
        this.freqBucketMap = new HashMap<>();
    }

    public V get(K key) {
        if (!valueMap.containsKey(key)) {
            return null;
        }

        // Update frequency
        int freq = frequencyMap.get(key);
        frequencyMap.put(key, freq + 1);

        freqBucketMap.get(freq).remove(key);
        if (freqBucketMap.get(freq).isEmpty()) {
            freqBucketMap.remove(freq);
            if (minFrequency == freq) {
                minFrequency++;
            }
        }

        freqBucketMap.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>()).add(key);

        return valueMap.get(key);
    }

    public void put(K key, V value) {
        if (capacity <= 0) return;

        if (valueMap.containsKey(key)) {
            valueMap.put(key, value);
            get(key); // Update frequency
            return;
        }

        if (valueMap.size() >= capacity) {
            // Evict least frequently used
            LinkedHashSet<K> keys = freqBucketMap.get(minFrequency);
            K evictKey = keys.iterator().next();
            keys.remove(evictKey);
            if (keys.isEmpty()) {
                freqBucketMap.remove(minFrequency);
            }

            valueMap.remove(evictKey);
            frequencyMap.remove(evictKey);
        }

        // Insert new key
        valueMap.put(key, value);
        frequencyMap.put(key, 1);
        freqBucketMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        minFrequency = 1;
    }

    public void display() {
        System.out.println("Cache contents:");
        for (K key : valueMap.keySet()) {
            System.out.println(key + " => " + valueMap.get(key) + " (freq: " + frequencyMap.get(key) + ")");
        }
    }

    public static void main(String[] args) {
        LFUCache<Integer, String> cache = new LFUCache<>(3);

        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");

        cache.get(1); // freq of 1: now 2
        cache.get(1); // freq of 1: now 3
        cache.get(2); // freq of 2: now 2

        cache.put(4, "Four"); // Evicts key 3 (least freq)

        cache.display(); // Should show 1, 2, 4
    }
}