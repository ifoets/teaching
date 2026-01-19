package com.design.analysis.ds.deque.queue.hard;

import com.design.analysis.ds.deque.queue.hard.IQueueHard;
import com.design.analysis.ds.deque.queue.hard.QueueHardImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class IQueueHardTest {

    IQueueHard iqh;

    @Before
    public void init()
    {
        iqh = new QueueHardImpl();
    }

    /**239. Sliding Window Maximum**/
    @Test
    public void maxSlidingWindowTest()
    {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] expOutput= {3,3,5,5,6,7};
        int[] output = iqh.maxSlidingWindow(nums,k);
        System.out.println(Arrays.toString(output));
    }
}
