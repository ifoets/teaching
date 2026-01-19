package com.design.analysis.core.java.design.core.data.structure;

import java.util.LinkedHashMap;
import java.util.Map;

/** purpose to keep least recently fixed size object*/

public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    int capacity;

    public LRUCache(int capacity)
    {
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> entry)
    {
       return size()>capacity;
    }

    @Override
    public V get(Object key) {
        return super.get(key);
    }

    @Override
    public V put(K key, V value) {
        return super.put(key, value);
    }

    public void print()
    {
        this.entrySet().forEach(e-> System.out.println(e.getKey()+":"+e.getValue()));
    }
}
