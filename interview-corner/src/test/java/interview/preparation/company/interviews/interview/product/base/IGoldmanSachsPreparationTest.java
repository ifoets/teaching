package interview.preparation.company.interviews.interview.product.base;

import interview.preparation.company.interviews.impl.product.base.GoldmanSachsPreparationImpl;
import interview.preparation.company.interviews.question.product.base.IGoldmanSachsPreparation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class IGoldmanSachsPreparationTest {

    IGoldmanSachsPreparation igsp;

    @Before
    public void init()
    {
        igsp = new GoldmanSachsPreparationImpl();
    }

    /**Find the missing number from a list of numbers from 1 to N in a sequence**/
    @Test
    public void missingNoTest()
    {
       int[] a={1,2,3,4,5,6,7,9,10};
        System.out.println(igsp.missingNo(a));
    }

    /**Given an array of positive integers nums and an integer k, find the length of the longest subarray whose sum is less than or equal to k*/
    @Test
    public void lenOfLongestSubStrTest()
    {
       int[] nums = {3,1,2,7,4,2,1,1,5};
       int k=8;
        System.out.println(igsp.lenOfLongestSubStr(nums,8));
    }

    /**34. Find First and Last Position of Element in Sorted Array**/
    @Test
    public void searchRangeTest() {
        int[] a = {5, 7, 7, 8, 8, 10};
        int k = 8;
        System.out.println(Arrays.toString(igsp.searchRange(a,k)));
    }
    /**33. Search in Rotated Sorted Array**/
    @Test
    public void indexOfInRotatedArrTest()
    {
        int []a ={3,4,5,6,7,8,0,1,2};
        Assert.assertEquals(6,igsp.indexOfInRotatedArr(a,0));
    }

    /**81. Search in Rotated Sorted Array II**/
    @Test
    public void searchInRotatedDuplicateValArrTest()
    {
        int[] a ={1,0,1,1,1};
        int target = 0;
        System.out.println(igsp.searchInRotatedDuplicateValArr(a,target));
    }

    /**162. Find Peak Element**/
    @Test
    public void findPeakElementTest()
    {
        int[]a ={1,2,3,1};
        System.out.println(igsp.findPeakElement(a));
    }
    /**875. Koko Eating Bananas**/
    @Test
    public void minEatingSpeedTest(){
        int []a ={3,6,7,11};
        // Assert.assertEquals(4,igsp.minEatingSpeed(a,8));
        int[] b={30,11,23,4,20};
        Assert.assertEquals(30,igsp.minEatingSpeed(b,5));
    }

    /**1011. Capacity To Ship Packages Within D Days**/
    @Test
    public void shipWithinDaysTest()
    {
      int[] a ={1,2,3,4,5,6,7,8,9,10};
      int days =5;
        Assert.assertEquals(15,igsp.shipWithinDays(a,5));
    }

    /**74. Search a 2D Matrix, O(log(m * n))**/
    @Test
    public void searchMatrixTest()
    {
        int[][] matrix1 = {
            {1,3,5,7},
            {10,11,16,20},
            {23,30,34,60}
        };
    int target1 = 3;
    Assert.assertTrue(igsp.searchMatrix(matrix1,target1));

        int[][]matrix2 = {
            {1,3,5,7},
            {10,11,16,20},
            {23,30,34,60}
        };
        int target2 = 13;
        Assert.assertFalse(igsp.searchMatrix(matrix2,target2));
    }

    /**763. Partition Labels**/
    @Test
    public void partitionLabelsTest(){
       List<Integer> integerList = igsp.partitionLabels("eccbbbbdec");
        System.out.println(integerList);
    }

    /**881. Boats to Save People, only max two people can save in a boat*/
    @Test
    public void numRescueBoatsTest()
    {
        Assert.assertEquals(3,igsp.numRescueBoats(new int[]{3,2,2,1},3));
        Assert.assertEquals(4,igsp.numRescueBoats(new int[]{3,5,3,4},5));
    }

    /**55. Jump Game**/
    @Test
    public void canJumpTest()
    {
        int[] nums ={2,3,1,1,4};
        int[] nums1={3,2,1,0,4};
        Assert.assertTrue(igsp.canJump(nums));
        Assert.assertFalse(igsp.canJump(nums1));
    }

    /**45. Jump Game II, min steps**/
    @Test
    public void jumpTest()
    {
        int[] nums={2,3,1,1,4};
        int[] nums1={2,3,0,1,4};
        Assert.assertEquals(2,igsp.jump(nums));
        Assert.assertEquals(2,igsp.jump(nums1));
    }

    /**jumps path indexes, if jums in min steps*/
    @Test
    public void jumpPathTest()
    {
        int[] nums={2,3,1,1,4};
        List<Integer> exPlist = List.of(0,1);
        Assert.assertEquals(exPlist,igsp.jumpPath(nums));
    }

    /**134. Gas Station**/
    @Test
    public void canCompleteCircuitTest()
    {
        int[] gas = {2,3,4};//{1,2,3,4,5};
        int[] cost = {3,4,3};//{3,4,5,1,2};
        System.out.println(igsp.canCompleteCircuit(gas,cost));
    }

    /**435. Non-overlapping Intervals**/
    @Test
    public void eraseOverlapIntervalsTest()
    {
        int[][] intervals ={{1,2},{2,3},{3,4},{1,3}};
        Assert.assertEquals(1,igsp.eraseOverlapIntervals(intervals));

        int[][] intervals1 ={{1,2},{1,2},{1,2}};
        Assert.assertEquals(2,igsp.eraseOverlapIntervals(intervals1));
    }

    /**135. Candy**/
    @Test
    public void candyTest()
    {
        Assert.assertEquals(5,igsp.candy(new int[]{1,0,2}));
        Assert.assertEquals(4,igsp.candy(new int[]{1,2,2}));
    }

    /*Given a string with consecutive repeating characters, compress it by replacing each group of consecutive identical characters with the character followed by its count.*/
    @Test
    public void compressConscutiveStrTest()
    {
        Assert.assertEquals("a3b3c3",igsp.compressConscutiveStr("aaabbbccc"));
    }

    @Test
    public void sidesZeroAtEndTest(){
        int[]a ={0,1,0,3,12};
        int[] b={1,3,12,0,0};
        igsp.sidesZeroAtEnd(a);
        Assert.assertArrayEquals(a,b);
    }
    /**Given two arrays start[] and finish[], representing the start and finish times of activities. A person can perform only one activity at a time, and an activity can be performed only if its start time is greater than the finish time of the last chosen activity.
     Find the maximum number of activities that can be performed without overlapping.

     Examples:

     Input: start[] = [1, 3, 0, 5, 8, 5], finish[] = [2, 4, 6, 7, 9, 9]
     Output: 4
     Explanation: A person can perform at most four activities. The maximum set of activities that can be performed is {0, 1, 3, 4} (these are the indexes in the start[] and finish[] arrays).
     */
    @Test
    public void maxActivityTest()
    {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] finish = {2, 4, 6, 7, 9, 9};
        Assert.assertEquals(4,igsp.maxActivity(start,finish));
    }
    /**2. Longest uniform subsequence - Find start index and length of longest repeating substring**/
    /**Given a string s of size N. The task is to find the largest substring which consists of the same characters**/
    @Test
    public void longestConscutiveRepetativeStrTest()
    {
        int[] rs = igsp.longestConscutiveRepetativeStr("abcdddddeff");
        Assert.assertArrayEquals(new int[]{3,5},rs);
    }

    /**"Shuffle an Array Randomly
     Problem Statement:
     Write a Java program that takes an array of integers and shuffles its elements randomly. Each time the program runs, the order of elements in the array should be different.
     Implement the shuffle without using built-in shuffle methods like Collections.shuffle()"*/
    @Test
    public void suffleArrayRandomTest()
    {
        int[] nums ={1,2,3,4,5,6,7,8,9};
        igsp.suffleArrayRandom(nums);
        System.out.println(Arrays.toString(nums));
    }
    /**15. 3Sum**/
    @Test
    public void threeSumTest()
    {
        List<List<Integer>> expList = List.of(List.of(-1,-1,2),List.of(-1,0,1));
        int[] nums={-1,0,1,2,-1,-4};
        List<List<Integer>> list = igsp.threeSum(nums);
        Assert.assertEquals(2,list.size());
        for (int i=0;i<list.size();i++) {
            System.out.println(list.get(i));
            Assert.assertEquals(expList.get(i), list.get(i));
        }
    }

    /**1283. Find the Smallest Divisor Given a Threshold**/
    @Test
    public void smallestDivisorTest()
    {
        int[] nums = {1,2,5,9};
        Assert.assertEquals(5,igsp.smallestDivisor(nums,6));
    }
}
