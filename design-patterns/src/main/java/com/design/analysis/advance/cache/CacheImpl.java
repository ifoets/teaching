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

    public V put(K k, V v){
          return  (V)iCache.put(k, v);
    }

    public boolean evict(K k){
            return iCache.evict(k);
    }
}
