package com.design.analysis.algo.sorting.medium;

import java.util.List;

public interface ISortingMedium {

    /**49. Group Anagrams**/
    List<List<String>> groupAnagrams(String[] strs);
    List<List<String>> groupAnagramsS(String[] strs);

    /**56. Merge Intervals**/
    int[][] mergeOverlappingInterval(int[][] intervals);
    /*[1,3] and [3,5]  (touching)-shouldn't
        [1,3] and [2,4]  (overlapping)-shouldn't
        [1,3] and [4,6] -fine*/
    int[][] addNonTouchingInterval(int[][]intervals, int[] current);

    /**75. Sort Colors. Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
     We will use the integers 0, 1, and 2..so on to represent the color red, white, and blue, respectively.**/
    void sortColors(int[] nums,int k);

}
