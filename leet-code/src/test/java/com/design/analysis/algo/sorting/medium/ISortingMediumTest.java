package com.design.analysis.algo.sorting.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ISortingMediumTest {

    ISortingMedium ism;

    @Before
    public void init()
    {
        ism = new SortingMediumImpl();
    }

    /**49. Group Anagrams**/
    @Test
    public void groupAnagramsTest()
    {
        List<List<String>> result=ism.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        List<List<String>> expResult = List.of(List.of("ate","eat","tea"),List.of("bat"),List.of("nat","tan"));
        for(List<String> list:result) System.out.println(list);
        Assert.assertEquals(result.size(),expResult.size());
    }

    @Test
    public void groupAnagramsSTest()
    {
        List<List<String>> result=ism.groupAnagramsS(new String[]{"eat","tea","tan","ate","nat","bat"});
        List<List<String>> expResult = List.of(List.of("ate","eat","tea"),List.of("bat"),List.of("nat","tan"));
            Assert.assertEquals(result.size(),expResult.size());
        for(List<String> list:result) System.out.println(list);
    }

    /**56. Merge Intervals**/
    @Test
    public void mergeOverlappingIntervalTest()
    {
        int[][] intervals ={{1,3}, {2,4}, {3,5}, {6,8}};
        int[][] expResult = {{1,5}, {6,8}};
        int[][] result = ism.mergeOverlappingInterval(intervals);
        for(int i=0;i<result.length;i++) {
            System.out.println(Arrays.toString(result[i]));
            Assert.assertArrayEquals(expResult[i], result[i]);
        }
    }
    /*[1,3] and [3,5]  (touching)-shouldn't
        [1,3] and [2,4]  (overlapping)-shouldn't
        [1,3] and [4,6] -fine*/
    @Test
    public void addNonTouchingIntervalTest()
    {
        int[][] intervals={{1,3}};
        int[] current1={3,5};
        int[][]result1 = ism.addNonTouchingInterval(intervals,current1);
        for(int i=0;i<result1.length;i++) System.out.println(Arrays.toString(result1[i]));

        int[] current2={2,4};
        int[][]result2 = ism.addNonTouchingInterval(intervals,current2);
        for(int i=0;i<result2.length;i++) System.out.println(Arrays.toString(result2[i]));

        int[] current3={4,6};
        int[][]result3 = ism.addNonTouchingInterval(intervals,current3);
        for(int i=0;i<result3.length;i++) System.out.print(Arrays.toString(result3[i]));
    }
    /**75. Sort Colors. Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
     We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.**/
    @Test
    public void sortColorsTest()
    {
        int[]nums = {2,0,2,1,1,0};
        int[]expResult= {0,0,1,1,2,2};
       ism.sortColors(nums,3);
       Assert.assertArrayEquals(expResult,nums);

        int[]nums1 = {2,0,1,4,5,0,2,3,1,0,5,5,3,4,1,5};
        int[]expResult1= {0,0,0,1,1,1,2,2,3,3,4,4,5,5,5,5};
        ism.sortColors(nums1,6);
        Assert.assertArrayEquals(expResult1,nums1);
    }
}
