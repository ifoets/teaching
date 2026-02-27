package interview.preparation.company.interviews.question.product.base;

import java.util.List;

public interface IGoldmanSachsPreparation {

    /**Find the missing number from a list of numbers from 1 to N in a sequence**/
    int missingNo(int[] a);

    /**Given an array of positive integers nums and an integer k, find the length of the longest subarray whose sum is less than or equal to k*/
    int lenOfLongestSubStr(int[] nums,int k);

    /**34. Find First and Last Position of Element in Sorted Array**/
    int[] searchRange(int[] nums, int target);

    /**33. Search in Rotated Sorted Array**/
    int indexOfInRotatedArr(int[]nums,int target);

    /**81. Search in Rotated Sorted Array II**/
    boolean searchInRotatedDuplicateValArr(int[] nums, int target);

    /**162. Find Peak Element**/
    int findPeakElement(int[] nums);

    /**875. Koko Eating Bananas**/
    int minEatingSpeed(int[] piles, int h);

    /**1011. Capacity To Ship Packages Within D Days**/
    int shipWithinDays(int[] weights, int days);

    /**1283. Find the Smallest Divisor Given a Threshold
    //int smallestDivisor(int[] nums, int threshold);

    /**1482. Minimum Number of Days to Make m Bouquets*/
    int minDays(int[] bloomDay, int m, int k);

    /**167. Two Sum II - Input Array Is Sorted**/
    int[] twoSum(int[] numbers, int target);

    /**125. Valid Palindrome**/
    boolean isPalindrome(String s);

    /**74. Search a 2D Matrix, O(log(m * n))**/
    boolean searchMatrix(int[][] matrix, int target);

    /**283. Move Zeroes**/
    void moveZeroes(int[] nums);

    /**763. Partition Labels**/
    List<Integer> partitionLabels(String s);

    /**881. Boats to Save People, only max two people can save in a boat*/
    int numRescueBoats(int[] peopleWeights, int limit);

    /**55. Jump Game**/
    boolean canJump(int[] nums);
    /**45. Jump Game II, min steps**/
    int jump(int[] nums);
    /**jumps path indexes, if jums in min steps*/
    List<Integer> jumpPath(int[] nums);

    /**134. Gas Station**/
    int canCompleteCircuit(int[] gas, int[] cost);

    /**435. Non-overlapping Intervals**/
    int eraseOverlapIntervals(int[][] intervals);

    /**135. Candy**/
    int candy(int[] ratings);

    /*Given a string with consecutive repeating characters, compress it by replacing each group of consecutive identical characters with the character followed by its count.*/
     String compressConscutiveStr(String str);

     void sidesZeroAtEnd(int[]a);
    /**Given two arrays start[] and finish[], representing the start and finish times of activities. A person can perform only one activity at a time, and an activity can be performed only if its start time is greater than the finish time of the last chosen activity.
     Find the maximum number of activities that can be performed without overlapping.

     Examples:

     Input: start[] = [1, 3, 0, 5, 8, 5], finish[] = [2, 4, 6, 7, 9, 9]
     Output: 4
     Explanation: A person can perform at most four activities. The maximum set of activities that can be performed is {0, 1, 3, 4} (these are the indexes in the start[] and finish[] arrays).
     */
     int maxActivity(int[]start, int[] end);

     /**2. Longest uniform subsequence - Find start index and length of longest repeating substring**/
     /**Given a string s of size N. The task is to find the largest substring which consists of the same characters**/
      int[] longestConscutiveRepetativeStr(String str);

      /**"Shuffle an Array Randomly
       Problem Statement:
       Write a Java program that takes an array of integers and shuffles its elements randomly. Each time the program runs, the order of elements in the array should be different.
       Implement the shuffle without using built-in shuffle methods like Collections.shuffle()"*/
      void suffleArrayRandom(int[] nums);

      /**15. 3Sum**/
      List<List<Integer>> threeSum(int[] nums);

      /**1283. Find the Smallest Divisor Given a Threshold**/
      int smallestDivisor(int[] nums, int threshold);
}
