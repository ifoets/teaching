package core.design.analysis.ds;

/**55. Implement fair producer-consumer with multiple producers/consumers.*/

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FairBoundedBuffer<E> {
    private final Object[] buffer;
    private int head = 0, tail = 0, count = 0;

    private final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    public FairBoundedBuffer(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException();
        this.buffer = new Object[capacity];
        this.lock = new ReentrantLock(true); // fair lock for FIFO order
        this.notEmpty = lock.newCondition();
        this.notFull = lock.newCondition();
    }

    public void put(E e) throws InterruptedException {
        if (e == null) throw new NullPointerException();
        lock.lock();
        try {
            while (count == buffer.length) {
                notFull.await(); // wait until space is available
            }
            buffer[tail] = e;
            tail = (tail + 1) % buffer.length;
            count++;
            notEmpty.signal(); // wake one waiting consumer
        } finally {
            lock.unlock();
        }
    }

    @SuppressWarnings("unchecked")
    public E take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await(); // wait until an element is available
            }
            E e = (E) buffer[head];
            buffer[head] = null; // avoid memory leak
            head = (head + 1) % buffer.length;
            count--;
            notFull.signal(); // wake one waiting producer
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
