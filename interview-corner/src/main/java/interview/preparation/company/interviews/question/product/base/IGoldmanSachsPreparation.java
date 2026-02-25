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


}
