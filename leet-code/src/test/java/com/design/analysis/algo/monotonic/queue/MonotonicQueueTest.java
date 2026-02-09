package com.design.analysis.algo.monotonic.queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MonotonicQueueTest {

    MonotonicQueue mq;

    @Before
    public void init()
    {
        mq = new MonotonicQueue();
    }

    @Test
    public void insertTest() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = new int[nums.length - k + 1];
        int[] exp = {3,3,5,5,6,7};
        for (int i = 0; i < nums.length; i++) {
            mq.push(nums[i]);

            if (i >= k - 1) {
                result[i - k + 1] = mq.max();
                mq.pop(nums[i - k + 1]);
            }
        }
        Assert.assertArrayEquals(exp,result);
    }
}
