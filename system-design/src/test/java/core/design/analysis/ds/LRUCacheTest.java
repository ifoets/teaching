package core.design.analysis.ds;

import org.junit.Before;
import org.junit.Test;

public class LRUCacheTest {
    LRUCache lruCache;

    @Before
    public void init()
    {
        lruCache = new LRUCache(4);
    }

    @Test
    public void lurCacheTest()
    {
        String[] keys ={"a","b","c","d"};
        int [] values ={1,2,3,4};
        for(int i=0;i<keys.length;i++) {
            lruCache.put(keys[i], values[i]);
        }
        lruCache.get("c");
        lruCache.printList();
        lruCache.put("e",5);
        lruCache.printList();
        lruCache.get("b");
        lruCache.printList();

        lruCache.put("d",10);
        lruCache.printList();
    }
}
