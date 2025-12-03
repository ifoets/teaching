package com.design.analysis.ds.heap.priority.queue.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IPriorityQueueMediumTest {

    IPriorityQueueMedium ipqm;

    @Before
    public  void init()
    {
        ipqm = new PriorityQueueMediumImpl();
    }

    /**215. Kth Largest Element in an Array**/
    @Test
    public void findKthLargestTest(){
        int[] a={3,2,1,5,6,4};
        int[] b={3,2,3,1,2,4,5,5,6};
        // Assert.assertEquals(5,ipqh.findKthLargest(a,2));
        Assert.assertEquals(4,ipqm.findKthLargest(b,4));
    }
}
