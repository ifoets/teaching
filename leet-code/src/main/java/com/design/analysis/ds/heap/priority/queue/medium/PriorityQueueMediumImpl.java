package com.design.analysis.ds.heap.priority.queue.medium;

import java.util.Arrays;

public class PriorityQueueMediumImpl implements IPriorityQueueMedium{

    /**215. Kth Largest Element in an Array**/
    @Override
    public int findKthLargest(int[] nums, int k){

        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
