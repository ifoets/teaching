package com.design.analysis.ds.deque.queue.hard;

import java.util.*;
import java.util.stream.IntStream;

public class QueueHardImpl implements IQueueHard{

    /**239. Sliding Window Maximum, You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
     Return the max sliding window.**/
    public int[] maxSlidingWindow(int[] nums, int k){
        if (nums == null || k == 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Remove elements outside window
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            //Remove smaller elements from back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            //Add current index
            deque.offerLast(i);

            //Add max to result once window is formed
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    @Override//it not suport big size data face time limit
    public int[] maxSlidingWindowX(int[] nums, int k){
        int n = nums.length;
        int[] maxSlidingWindow = new int[n-k+1];
        for(int i=0, j=0;i<=n-k;i++) maxSlidingWindow[j++]= IntStream.range(i,i+k).map(x->nums[x]).max().orElseThrow();
        return maxSlidingWindow;
    }
}
