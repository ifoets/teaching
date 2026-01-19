package core.design.analysis.ds;

import java.util.LinkedHashMap;
import java.util.Map;
/**1.	Design LRU Cache**/
public class LRUCacheLinkedHashMap<K,V> extends LinkedHashMap<K,V> {
    int size;

    public LRUCacheLinkedHashMap(int size)
    {
        super(size,0.75f,true);
        this.size = size;
    }
    @Override
    public boolean removeEldestEntry(Map.Entry<K,V> entry)
    {
        return size()>this.size;
    }
    public V put(K k, V v)
    {
        return super.put(k, v);
    }

    public V get(Object k)
    {
        return super.get(k);
    }
}
