package com.design.analysis.advance.cache;

public interface ICache<K, V> {

    public K get(K k);

    public V put(K k, V v);

    public boolean evict(K k);

    //https://www.geeksforgeeks.org/lru-cache-implementation/
    // https://medium.com/analytics-vidhya/how-to-implement-cache-in-java-d9aa5e9577f2
    //https://crunchify.com/how-to-create-a-simple-in-memory-cache-in-java-lightweight-cache/
}
