package com.design.analysis.algo.array.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicIntegerArray;

public interface IArrayEasy {

    /** 1. Two Sum*/
    int[] twoSum(int[] nums, int target);
    int[] twoSumX(int[] nums, int target);
    /**find all indexes target sum*/
    Map<Integer,Integer> sumTargetIndexes(int[]a, int target);

    /**26. Remove Duplicates from Sorted Array ie return unique element count*/
    int removeDuplicates(int[] nums);
    /**remove duplicate elements*/
    int[] removeDuplicatesS(int[] a);

    /**27. Remove Element*/
    int removeElement(int[] nums, int val);
    int[] removeElementS(int[] a, int val);

    /**412. Fizz Buzz*/
    List<String> fizzBuzz(int n);

    /**35. Search Insert Position, Given a sorted array of distinct integers and a target value, return the index if the target is found.
     If not, return the index where it would be if it were inserted in order*/
     int searchInsert(int[] nums, int target);

    int searchInsertX(int[] a, int target, int l ,int r);

    /**88. Merge Sorted Array, num1.lengh=m+n, sort all in num1**/
    void merge(int[] nums1, int m, int[] nums2, int n);
}
