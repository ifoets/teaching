package interview.preparation.company.interviews.design.paypal.threadsafe.lru;

import org.junit.Before;
import org.junit.Test;

public class ThreadSafeLRUCacheTest {

    public ThreadSafeLRUCache<Integer,String> tslru;

    @Before
    public void init()
    {
        tslru = new ThreadSafeLRUCache<>(3);
    }

    @Test
    public void threadSafeLRUCacheTest() {

        Runnable run1 = () ->
        {

        tslru.put(1, "One");
        tslru.put(2, "Two");
        tslru.put(3, "Three");
        tslru.display(); // {1=One, 2=Two, 3=Three}

        tslru.get(1); // Access key 1
        tslru.display();
    };
        Runnable run2 =()->
        {
            tslru.put(4, "Four"); // Evicts key 2
            tslru.display(); // {3=Three, 1=One, 4=Four}

            tslru.get(3);
            tslru.display();

            tslru.get(1);
            tslru.display();
        };
       new Thread(run1).start();
       new Thread(run2).start();
    }
}
