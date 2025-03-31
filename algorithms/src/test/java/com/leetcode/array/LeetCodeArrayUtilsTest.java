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
}
