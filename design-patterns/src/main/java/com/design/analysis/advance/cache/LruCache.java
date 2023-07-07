package com.design.analysis.advance.cache;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LruCache<K, V> implements ICache<K, V>{
    final int CACHE_SIZE;
    private Deque<K> dq;

    private ConcurrentHashMap<K, V>  lruMap;

    public LruCache(int size)
    {
        this.CACHE_SIZE = size;
        this.dq = new LinkedList<>();
        this.lruMap = new ConcurrentHashMap<>();
    }

    @Override
    public K get(K k) {
        if(!dq.contains(k))
            return null;
        else {
            return (K)lruMap.get(k);
        }
    }

    @Override
    public V put(K k, V v) {
      if(!lruMap.containsKey(k))
      {
          if(dq.size()==CACHE_SIZE)
          {
              K kr = (K)dq.removeLast();
              lruMap.remove(kr);
          }
      }
      else {
          //remove from middle
          dq.remove(k);
      }
      dq.addFirst(k);
      return lruMap.put(k,v);
    }

    @Override
    public boolean evict(K k) {
       if(lruMap.containsKey(k))
       {
           lruMap.remove(k);
           dq.remove(k);
           return true;
       }
       return false;
    }
}
