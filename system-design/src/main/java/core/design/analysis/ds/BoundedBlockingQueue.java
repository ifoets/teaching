package core.design.analysis.ds;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueue<E> {
    private final Object[] items;
    private int head, tail, count;
    private final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    public BoundedBlockingQueue(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException();
        this.items = new Object[capacity];
        this.lock = new ReentrantLock(true); // fairness optional
        this.notEmpty = lock.newCondition();
        this.notFull = lock.newCondition();
    }

    public void put(E e) throws InterruptedException {
        if (e == null) throw new NullPointerException();
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await(); // block until space is available
            }
            items[tail] = e;
            tail = (tail + 1) % items.length;
            count++;
            notEmpty.signal(); // wake up one waiting consumer
        } finally {
            lock.unlock();
        }
    }

    public E take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await(); // block until element available
            }
            @SuppressWarnings("unchecked")
            E e = (E) items[head];
            items[head] = null; // avoid memory leak
            head = (head + 1) % items.length;
            count--;
            notFull.signal(); // wake up one waiting producer
            return e;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }
}

