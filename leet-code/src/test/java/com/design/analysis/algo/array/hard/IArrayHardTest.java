package com.design.analysis.algo.array.hard;

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

    /**41. First Missing Positive**/
    @Test
    public void firstMissingPositiveTest()
    {
        Assert.assertEquals(3,irh.firstMissingPositive(new int[]{0,2,2,1,1}));
        Assert.assertEquals(2,irh.firstMissingPositive(new int[]{3,4,-1,1}));
        Assert.assertEquals(1,irh.firstMissingPositive(new int[]{7,8,9,11,12}));
    }
    @Test
    public void firstMissingPositiveXTest()
    {
        Assert.assertEquals(3,irh.firstMissingPositiveX(new int[]{0,2,2,1,1}));
        Assert.assertEquals(2,irh.firstMissingPositiveX(new int[]{3,4,-1,1}));
        Assert.assertEquals(1,irh.firstMissingPositiveX(new int[]{7,8,9,11,12}));
    }

    /**42. Trapping Rain Water**/
    @Test
    public void trapTest()
    {
        Assert.assertEquals(6,irh.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        Assert.assertEquals(9,irh.trap(new int[]{4,2,0,3,2,5}));
    }
}
