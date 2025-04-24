package com.leetcode.array.medium;

import java.util.List;

public interface IArrayMedium {
    /** 11. Container With Most Water*/
    int maxArea(int[] heights);

    /** 15. 3Sum*/
     List<List<Integer>> threeSum(int[] nums);
    List<List<Integer>> threeSumX(int[] nums);

    /**16. 3Sum Closest*/
    public int threeSumClosest(int[] nums, int target);
    public int threeSumClosestX(int[] nums, int target);

    /**18. 4Sum return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]]*/
    public List<List<Integer>> fourSum(int[] nums, int target);

    /**31. Next Permutation in lexicographical order*/
    public void nextPermutation(int[] nums);
    public void permutationLexicalOrder(List<List<Integer>> list, int nums[], int idx);

    /**33. Search in Rotated Sorted Array */
    public int search(int[] nums, int target);
}
