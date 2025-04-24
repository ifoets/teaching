package com.leetcode.array.hard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IArrayHardTest {

    private IArrayHard irh;

    @Before
    public void init()
    {
        irh = new ArrayHardImpl();
    }

    @Test
    public void findMedianSortedArraysTest(){
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        double output =2.00000;
        Assert.assertEquals((int) output,(int) irh.findMedianSortedArrays(nums1,nums2));
        int[] nums3 = {1,2};
        int[] nums4 = {3,4};
        double output1= 2.50000;
        Assert.assertEquals((int) output1,(int) irh.findMedianSortedArrays(nums3,nums4));

    }
}
