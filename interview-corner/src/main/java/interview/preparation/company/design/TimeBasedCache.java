package interview.preparation.company.design;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeBasedCache<K, V> {
    private static class Node<V> {
        final V value;
        final long expireAt;

        Node(V value, long expireAt) {
            this.value = value;
            this.expireAt = expireAt;
        }
    }

    private final ConcurrentHashMap<K, Node<V>> cache = new ConcurrentHashMap<>();

    public TimeBasedCache() {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleWithFixedDelay(
            this::cleanupExpired,
            1, 1, TimeUnit.MINUTES
        );
    }

    public void put(K key, V value, long ttlMillis) {
        long expireAt = System.currentTimeMillis() + ttlMillis;
        cache.put(key, new Node<>(value, expireAt));
    }

    public V get(K key) {
        Node<V> node = cache.get(key);
        if (node == null) return null;

        if (node.expireAt < System.currentTimeMillis()) {
            cache.remove(key, node); // conditional remove
            return null;
        }
        return node.value;
    }

    public void remove(K key) {
        cache.remove(key);
    }

    public int size() {
        return cache.size(); // O(1)
    }

    private void cleanupExpired() {
        long now = System.currentTimeMillis();
        for (Map.Entry<K, Node<V>> e : cache.entrySet()) {
            if (e.getValue().expireAt < now) {
                cache.remove(e.getKey(), e.getValue());
            }
        }
    }

}