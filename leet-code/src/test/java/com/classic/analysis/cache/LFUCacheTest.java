package com.classic.analysis.cache;

import org.junit.Before;
import org.junit.Test;

public class LFUCacheTest {

    LFUCache lfuCache;

    @Before
    public void init()
    {
        lfuCache = new LFUCache(2);
    }

    @Test
    public void testLFUCacheTest()
    {
        lfuCache.put(1,1);
        lfuCache.put(2,2);
        lfuCache.print();
        lfuCache.get(1);
        lfuCache.get(2);
        lfuCache.put(3,3);
        lfuCache.print();
    }
}
