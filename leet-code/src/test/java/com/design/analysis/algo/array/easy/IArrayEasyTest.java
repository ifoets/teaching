package com.design.analysis.algo.array.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
    /**find all indexes target sum*/
    @Test
    public void sumTargetIndexesTest()
    {
       int[] a={0,1,2,3,4,5,6,7,8,9};
       int target = 10;
       Map<Integer,Integer> resultMap = iae.sumTargetIndexes(a,target);
       Map<Integer,Integer> expMap = Map.of(1,9,2,8,3,7,4,6);
       Assert.assertEquals(expMap,resultMap);
    }
    /**26. Remove Duplicates from Sorted Array*/
    @Test
    public void removeDuplicatesTest(){
        int[] nums ={1,1,2};
        Assert.assertEquals(2, iae.removeDuplicates(nums));
    }

    /**remove duplicate elements*/
    @Test
    public void removeDuplicatesS(){
        int[] a = {0,0,1,1,1,2,2,3,3,4};
        int[] rs = iae.removeDuplicatesS(a);
        int[] expRs = {0,1,2,3,4};
        Assert.assertArrayEquals(rs,expRs);
    }

    /**27. Remove Element*/
    @Test
    public void removeElementTest()
    {
        int[] nums ={0,1,2,2,3,0,4,2};
        Assert.assertEquals(5, iae.removeElement(nums, 2));
    }
    @Test
    public void removeElementSTest()
    {
        int[]a ={0,1,2,2,3,0,4,2};
        int val =2;
        int []rs = iae.removeElementS(a,val);
        int[] expRs = {0,1,4,0,3};
        Assert.assertArrayEquals(Arrays.stream(rs).sorted().toArray(), Arrays.stream(expRs).sorted().toArray());
    }
    /**412. Fizz Buzz*/
    @Test
    public void fizzBuzzTest(){

        List<String> rs = iae.fizzBuzz(15);
        System.out.print(Arrays.toString(rs.toArray()));
    }
    /**35. Search Insert Position, Given a sorted array of distinct integers and a target value, return the index if the target is found.
     If not, return the index where it would be if it were inserted in order*/
    @Test
    public void searchInsertTest(){

        int[] nums = {1,3,5,6};
        Assert.assertEquals(2, iae.searchInsert(nums, 5));
        Assert.assertEquals(1, iae.searchInsert(nums, 2));
        Assert.assertEquals(4, iae.searchInsert(nums, 7));
        Assert.assertEquals(0, iae.searchInsert(nums, 0));
        int []a={1,3,5};
        Assert.assertEquals(2, iae.searchInsert(a, 4));
    }

    @Test
    public void searchInsertSTest(){

        int[] nums = {1,3,5,6};
        Assert.assertEquals(2, iae.searchInsertX(nums, 5,0,3));
        Assert.assertEquals(1, iae.searchInsertX(nums, 2,0,3));
        Assert.assertEquals(4, iae.searchInsertX(nums, 7,0,3));
        Assert.assertEquals(0, iae.searchInsertX(nums, 0,0,3));
        int []a={1,3,5};
        Assert.assertEquals(2, iae.searchInsertX(a, 4,0,2));
    }

    /**88. Merge Sorted Array, num1.lengh=m+n, sort all in num1**/
    @Test
    public void mergeTest()
    {
        int[]nums1 = {4,0,0,0,0,0};
        int m = 1;
        int[] nums2 = {1,2,3,5,6};
        int n = 5;
        int[] expResult= {1,2,3,4,5,6};
        iae.merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
}
