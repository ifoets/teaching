package com.design.analysis.advance.cache;

public class CacheImpl<K, V> {

    public  ICache iCache;

    public CacheImpl(ICache iCache)
    {
        this.iCache = iCache;
    }

    public K git(K k){
        return (K) iCache.get(k);
    }

    public boolean put(K k, V v){
          iCache.put(k, v);
    }

    public boolean evict(K k){
            return iCache.evict(k);
    }
}
