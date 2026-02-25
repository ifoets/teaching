package com.classic.analysis.core.ds.heap;

import org.junit.Before;
import org.junit.Test;

public class MinHeapDecreaseKeyTest {

    MinHeapDecreaseKey heap;

    @Before
    public void init()
    {
        heap = new MinHeapDecreaseKey();
    }

    @Test
    public void minHeapDecreaseKeyTest()
    {
        heap.insert(20);
        heap.insert(15);
        heap.insert(30);
        heap.insert(40);
        heap.insert(50);

        heap.decreaseKey(40, 10);

        while (!heap.isEmpty()) {
            System.out.println(heap.extractMin());
        }
    }
}
