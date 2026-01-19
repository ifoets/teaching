package interview.preparation.company.design;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

public class LRUCaffeine <K, V> {

    private final Cache<K, V> cache;

    public LRUCaffeine(int maxSize) {
        this.cache = Caffeine.newBuilder()
            .maximumSize(maxSize)          // LRU eviction trigger but stict LRU eventual, maynot follow LRU, TTL is native for this
            .recordStats()                 // important for monitoring
            .build();
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public V get(K key) {
        return cache.getIfPresent(key);
    }

    public void remove(K key) {
        cache.invalidate(key);
    }

    public long size() {
        return cache.estimatedSize();
    }

    public void clear() {
        cache.invalidateAll();
    }

    public static void main(String[] args) {
        LRUCaffeine<Integer, String> cache = new LRUCaffeine<>(2);

        cache.put(1, "A");
        cache.put(2, "B");

        cache.get(1);       // Access 1 → most recently used
        cache.put(3, "C"); // Evicts key 2
        cache.cache.cleanUp();
        System.out.println(cache.get(1)); // A
        System.out.println(cache.get(2)); // null
        System.out.println(cache.get(3)); // C
    }
}
