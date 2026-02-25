package com.classic.analysis.core.ds.heap;

import org.junit.Before;
import org.junit.Test;

public class MinHeapTest {

    MinHeap heap ;
    @Before
    public void init()
    {
        heap = new MinHeap(10);
    }
    @Test
    public void minHeapTest()
    {
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);
        heap.insert(1);

        while (!heap.isEmpty()) {
            System.out.println(heap.extractMin());
        }
    }

}
