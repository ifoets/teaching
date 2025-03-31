package com.leetcode.array.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IArrayEasyTest {

    private IArrayEasy iae;


    @Before
    public void init()
    {
        iae = new ArrayEasyImpl();
    }

    /** 1. Two Sum*/
    @Test
    public void twoSumTest()
    {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] rs;
        rs = iae.twoSum(nums,target);
        Assert.assertEquals(2,rs.length);
        Assert.assertEquals(0,rs[0]);
        Assert.assertEquals(1,rs[1]);

    }

    @Test
    public void twoSumTestX()
    {
        int[] nums = {2,5,5,11};
        int target = 10;
        int[] rs;
        rs = iae.twoSumX(nums,target);
       Assert.assertEquals(2,rs.length);
        Assert.assertEquals(1,rs[0]);
        Assert.assertEquals(2,rs[1]);
    }
    /**26. Remove Duplicates from Sorted Array*/
    @Test
    public void removeDuplicatesTest(){
        int[] nums ={1,1,2};
        Assert.assertEquals(2, iae.removeDuplicates(nums));
    }


    /**27. Remove Element*/
    @Test
    public void removeElementTest()
    {
        int[] nums ={0,1,2,2,3,0,4,2};
        Assert.assertEquals(5, iae.removeElement(nums, 2));
    }
}
