package com.design.analysis.algo.two.pointer.medium;

import java.util.List;

public interface ITwoPointerMedium {

    /**5. Longest Palindromic Substring*/
     String longestPalindrome(String s);
     int expandAroundCenter(String s, int l, int r);

     /**11. Container With Most Water*/
     int maxArea(int[] h);

     /**15. 3Sum*/
     List<List<Integer>> threeSum(int[] nums);

     /**80. Remove Duplicates from Sorted Array II, remove some duplicates in-place such that each unique element appears at most twice.
      * The relative order of the elements should be kept the same.**/
     int removeDuplicates(int[] nums);
}
