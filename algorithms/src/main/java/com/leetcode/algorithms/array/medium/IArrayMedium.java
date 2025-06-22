package com.leetcode.algorithms.array.medium;

import java.util.List;

public interface IArrayMedium {
    /** 11. Container With Most Water*/
    int maxArea(int[] heights);

    /** 15. 3Sum*/
     List<List<Integer>> threeSum(int[] nums);
    List<List<Integer>> threeSumX(int[] nums);

    /**16. 3Sum Closest*/
     int threeSumClosest(int[] nums, int target);
     int threeSumClosestX(int[] nums, int target);

    /**18. 4Sum return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]]*/
     List<List<Integer>> fourSum(int[] nums, int target);

    /**31. Next Permutation in lexicographical order*/
     void nextPermutation(int[] nums);
     void permutationLexicalOrder(List<List<Integer>> list, int nums[], int idx);

    /**33. Search in Rotated Sorted Array */
     int search(int[] nums, int target);

    /**34. Find First and Last Position of Element in Sorted Array**/
    int[] searchRange(int[] nums, int target);
    int[] searchRangeX(int[] nums, int target);

    /**36. Valid Sudoku
     * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
     *
     * Each row must contain the digits 1-9 without repetition.
     * Each column must contain the digits 1-9 without repetition.
     * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     */
    boolean isValidSudoku(char[][] board);


}
