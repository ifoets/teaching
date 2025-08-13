package interview.preparation.company.interviews.design.paypal.threadsafe.lru;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeLRUCache<K,V> extends LinkedHashMap<K, V> {

    int capacity;
    private final ReentrantLock lock = new ReentrantLock();

    public ThreadSafeLRUCache(int capacity)
    {
        super(capacity,0.75f,true);//true change access order, get/put element will be last element in list
        this.capacity = capacity;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        lock.lock();
        try {
            return size() > capacity;
        } finally {
            lock.unlock();
        }

    }

    public V put(K k, V v)
    {
        lock.lock();
        try {
            return super.put(k, v);
        } finally {
            lock.unlock();
        }
    }

    public V get(Object k)
    {
        lock.lock();
        try {
            return super.get(k);
        } finally {
            lock.unlock();
        }
    }

    public void display() {
        System.out.println(super.toString());
    }

}
