package com.design.analysis.algo.array.easy;

import java.util.List;

public interface IArrayEasy {

    /** 1. Two Sum*/
    int[] twoSum(int[] nums, int target);

    int[] twoSumX(int[] nums, int target);

    /**26. Remove Duplicates from Sorted Array*/
    int removeDuplicates(int[] nums);

    /**27. Remove Element*/
    int removeElement(int[] nums, int val);

    /**412. Fizz Buzz*/
    public List<String> fizzBuzz(int n);

    /**35. Search Insert Position, Given a sorted array of distinct integers and a target value, return the index if the target is found.
     If not, return the index where it would be if it were inserted in order*/
     int searchInsert(int[] nums, int target);
}
