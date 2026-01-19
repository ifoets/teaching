package core.design.analysis.ds;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class LRUCacheLinkedHashMapTest {

    LRUCacheLinkedHashMap<String,Integer> lruCacheLinkedHashMap;

    @Before
    public void init()
    {
        lruCacheLinkedHashMap = new LRUCacheLinkedHashMap<>(4);
    }

    @Test
    public void lurCacheTest()
    {
        String[] keys ={"a","b","c","d"};
        int [] values ={1,2,3,4};
        for(int i=0;i<keys.length;i++) {
            lruCacheLinkedHashMap.put(keys[i], values[i]);
        }
        lruCacheLinkedHashMap.get("c");
        System.out.println(lruCacheLinkedHashMap);
        lruCacheLinkedHashMap.put("e",5);
        System.out.println(lruCacheLinkedHashMap);
        lruCacheLinkedHashMap.get("b");
        System.out.println(lruCacheLinkedHashMap);
    }
}
