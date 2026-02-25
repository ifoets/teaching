package com.classic.analysis.core.ds.heap;

import org.junit.Before;
import org.junit.Test;

public class MaxHeapTest {

    MaxHeap heap ;
    @Before
    public void init()
    {
        heap = new MaxHeap(10);
    }
    @Test
    public void minHeapTest()
    {
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);
        heap.insert(1);

        while (!heap.isEmpty()) {
            System.out.println(heap.extractMax());
        }
    }
}
