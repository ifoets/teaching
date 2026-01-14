package interview.preparation.company.design;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LFUCache {

    private final int capacity;
    private int minFreq;

    private final Map<Integer, Node> cache;
    private final Map<Integer, LinkedHashMap<Integer, Node>> freqMap;

    private static class Node {
        int key;
        int value;
        int freq;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }

        updateFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            updateFrequency(node);
            return;
        }

        if (cache.size() == capacity) {
            evictLFU();
        }

        Node newNode = new Node(key, value);
        cache.put(key, newNode);

        freqMap
            .computeIfAbsent(1, k -> new LinkedHashMap<>())
            .put(key, newNode);

        minFreq = 1;
    }

    private void updateFrequency(Node node) {
        int freq = node.freq;
        LinkedHashMap<Integer, Node> oldBucket = freqMap.get(freq);

        oldBucket.remove(node.key);

        if (oldBucket.isEmpty()) {
            freqMap.remove(freq);
            if (minFreq == freq) {
                minFreq++;
            }
        }

        node.freq++;

        freqMap
            .computeIfAbsent(node.freq, k -> new LinkedHashMap<>())
            .put(node.key, node);
    }

    private void evictLFU() {
        LinkedHashMap<Integer, Node> bucket = freqMap.get(minFreq);

        // LRU eviction within LFU
        Integer evictKey = bucket.entrySet().iterator().next().getKey();

        bucket.remove(evictKey);
        if (bucket.isEmpty()) {
            freqMap.remove(minFreq);
        }

        cache.remove(evictKey);
    }
}