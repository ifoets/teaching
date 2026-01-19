package com.design.analysis.algo.divide.and.conquer.medium;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DivideConquerMediumImpl implements IDivideConquerMedium{

    /**53. Maximum Subarray**/
    @Override
    public int maxSubArray(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        int currentSum=0;

        for (int num : nums) {
            currentSum += num;
            if (currentSum > maxSum)
                maxSum = currentSum;
            if (currentSum < 0)
                currentSum = 0;
        }
        return maxSum;
    }

    @Override
    public int[] findMaxSumContineousArray(int[] nums) {

        int currentMax = nums[0];
        int globalMax = nums[0];

        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < nums.length; i++) {

            // Decide whether to start new subarray
            if (nums[i] > currentMax + nums[i]) {
                currentMax = nums[i];
                tempStart = i;
            } else {
                currentMax += nums[i];
            }

            // Update global maximum
            if (currentMax > globalMax) {
                globalMax = currentMax;
                start = tempStart;
                end = i;
            }
        }
        return Arrays.stream(nums, start, end+1).toArray();
    }

}
