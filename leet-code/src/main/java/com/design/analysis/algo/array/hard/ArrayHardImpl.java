package com.design.analysis.algo.array.hard;

import java.util.*;
import java.util.stream.IntStream;

public class ArrayHardImpl implements IArrayHard{

    /** 4. Median of Two Sorted Arrays*/
    @Override
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int[] arr = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).sorted().toArray();
        int N = arr.length;
        return N%2!=0 ? arr[N/2] : (double) (arr[N / 2 - 1] + arr[N / 2]) /2;
    }

    /**41. First Missing Positive, You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.**/
    @Override
    public int firstMissingPositive(int[] nums){
       int n = nums.length;//[1,2,3,4] +ve pure no should be

        for(int i=0;i<n;i++)
        {
            //placing all Posative no at index i to its right place till no is +ve
            //nums[nums[i]-1]==nums[i] then no is at right place
            while (nums[i]>0&&nums[i]<=n && nums[nums[i]-1]!=nums[i])
            {
                int correctIndex=nums[i]-1;
                int temp =nums[i];
                nums[i]=nums[correctIndex];
                nums[correctIndex]=temp;
            }
        }
        // find first index where value != index + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
    @Override//breaking O(1)
    public int firstMissingPositiveX(int[] nums){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(i->i));
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0&&!set.contains(num))
            {
                pq.add(num);
                set.add(num);
            }
        }
        int i=1;
        while (!pq.isEmpty())
        {
            int poll=pq.poll();
            if(poll!=i)
                return i;
            i++;
        }
        return i;
    }

    /**42. Trapping Rain Water**/
    @Override
    public int trap(int[] height){
        int i=0, j=height.length-1;
        int leftMax=0, rightMax=0;
        int water=0;
        while (i<j)
        {
            if(height[i]<height[j])
            {
                if(height[i]>=leftMax)
                    leftMax=height[i];
                else water+=leftMax-height[i];
                i++;
            }
            else {
                if(height[j]>=rightMax)
                    rightMax=height[j];
                else water+=rightMax-height[j];
                j--;
            }
        }
        return water;
    }
}
