package com.design.analysis.algo.design.medium;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap<K,V> {
    int capacity;
    public LRUCache(int capacity)
    {
        super(capacity,0.75f,true);//this true work for LRU
        this.capacity = capacity;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<K,V> eldest)
    {
        return this.size()>capacity;
    }

    public V get(Object key) {
        return super.get(key);
    }

    public V put(K key, V value) {
        super.put(key,value);
        return value;
    }
}
