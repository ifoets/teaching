package com.leetcode.array.hard;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ArrayHardImpl implements IArrayHard{

    /** 4. Median of Two Sorted Arrays*/
    @Override
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int[] arr = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).sorted().toArray();
        int N = arr.length;
        return N%2!=0 ? arr[N/2] : (double) (arr[N / 2 - 1] + arr[N / 2]) /2;
    }
}
