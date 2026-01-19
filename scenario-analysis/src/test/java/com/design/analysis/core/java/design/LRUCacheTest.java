package com.design.analysis.core.java.design;

import com.design.analysis.core.java.design.core.data.structure.LRUCache;
import org.junit.Before;
import org.junit.Test;

public class LRUCacheTest {

    LRUCache<String,Integer> lruCache;

    @Before
    public void init()
    {
        lruCache = new LRUCache<>(4);
    }

    @Test
    public void getPut()
    {
        lruCache.put("aa",1);
        lruCache.put("bb",1);
        lruCache.put("cc",1);
        lruCache.get("aa");
        lruCache.put("dd",1);
        lruCache.put("ee",1);
        lruCache.print();
        System.out.println();
        lruCache.get("aa");
        lruCache.put("ff",1);
        lruCache.put("gg",1);
        lruCache.put("hh",1);
        lruCache.get("ff");
        lruCache.print();
    }
}
