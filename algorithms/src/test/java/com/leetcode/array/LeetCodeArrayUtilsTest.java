package com.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

public class LeetCodeArrayUtilsTest {

    @Test
    public void pivotSortedRotatedArrayTest(){
        int[] nums ={4,5,6,7,0,1,2};
        Assert.assertEquals(4, LeetCodeArrayUtils.pivotSortedRotatedArray(nums,0,nums.length-1));
        int[] nums1 ={3,1};
        Assert.assertEquals(1,LeetCodeArrayUtils.pivotSortedRotatedArray(nums1,0,nums1.length-1));
    }
    @Test
    public void binarySearchTest(){
        int nums[] ={0,1,2};
        Assert.assertEquals(0,LeetCodeArrayUtils.binarySearch(nums,0,nums.length-1,0));
    }

    @Test
    public void binarySearchFirstIndexTest()
    {

        int [] nums = {5,7,7,8,8,10};
        int target = 8;
        Assert.assertEquals(3,LeetCodeArrayUtils.binarySearchFirstIndex(nums,0,nums.length-1,target));

        int [] nums1 = {7,7,7,8,8,10};
        int target1 = 7;
        Assert.assertEquals(0,LeetCodeArrayUtils.binarySearchFirstIndex(nums1,0,nums1.length-1,target1));
        Assert.assertEquals(-1,LeetCodeArrayUtils.binarySearchFirstIndex(nums1,0,nums1.length-1,6));
        Assert.assertEquals(-1,LeetCodeArrayUtils.binarySearchFirstIndex(nums,0,nums.length-1,6));
    }
    @Test
    public void binarySearchLastIndexTest()
    {
        int [] nums = {5,7,7,8,8,10};
        int target = 8;
        Assert.assertEquals(4,LeetCodeArrayUtils.binarySearchLastIndex(nums,0,nums.length-1,target));

        int [] nums1 = {7,7,7,8,8,10};
        int target1 = 10;
        Assert.assertEquals(5,LeetCodeArrayUtils.binarySearchFirstIndex(nums1,0,nums1.length-1,target1));
        Assert.assertEquals(-1,LeetCodeArrayUtils.binarySearchFirstIndex(nums1,0,nums1.length-1,6));
        Assert.assertEquals(-1,LeetCodeArrayUtils.binarySearchFirstIndex(nums,0,nums.length-1,6));

    }
}
