
package com.design.analysis.core.algo.array;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IArraySearchTest {

    public IArraySearch ias = null;

    @Before
    public void init() {
        ias = new ArraySearchImpl();
    }

    /** 1. Search, insert and delete in an unsorted array **/
    @Test
    public void searchInsertDelUnsortedArrTest() {
        int []a = { 1, 3, 2, 5, 4, 6, 7, 8, 9 };

        Assert.assertTrue(ias.searchInsertDelUnsortedArr(a, a.length, 5, "S"));
        Assert.assertTrue(ias.searchInsertDelUnsortedArr(a, a.length, 5, "D"));
        System.out.println(Arrays.toString(a));
        Assert.assertFalse(ias.searchInsertDelUnsortedArr(a, a.length, 10, "I"));
        Assert.assertTrue(ias.searchInsertDelUnsortedArr(a, 8, 10, "I"));
        System.out.println(Arrays.toString(a));
    }

    /** 2. Search, insert and delete in an sorted array **/
    @Test
    public void searchInsertDelSortedArrTest() {
        int []a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        Assert.assertTrue(ias.searchInsertDelSortedArr(a, a.length, 5, "S"));
        Assert.assertFalse(ias.searchInsertDelSortedArr(a, a.length, 15, "S"));
        Assert.assertTrue(ias.searchInsertDelSortedArr(a, a.length, 5, "D"));
        System.out.println(Arrays.toString(a));
        Assert.assertFalse(ias.searchInsertDelSortedArr(a, a.length, 10, "I"));
        Assert.assertTrue(ias.searchInsertDelSortedArr(a, 8, 10, "I"));
    }

    /**
     * 3. Given an array []a and a number x, check for pair in []a with sum as x
     **/
    @Test
    public void pairOfSumXTest() {

        int []a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Assert.assertEquals(ias.pairOfSumX(a, 6).size() , 2);
    }

    /** 8.Leaders in an array **/
    @Test
    public void findLeaderTest() {
        int []a = { 16, 17, 4, 3, 5, 2, 1 };
        List<Integer> list = ias.findLeader(a);
        Assert.assertEquals(list.get(0).intValue() , 1);
        Assert.assertEquals(list.get(3).intValue() , 17);
    }

    /** 14. Majority Element **/
    @Test
    public void majorityElementTest() {
        Assert.assertNull(ias.majorityElement(null));
        int []a = {};
        Assert.assertNull(ias.majorityElement(a));

        int []b = { 5 };
        Assert.assertEquals(ias.majorityElement(b).intValue() , 5);

        int []c = { 1, 2, 3, 4, 5, 6, 7, 4, 7, 2, 3, 5, 1, 2, 5, 5, 5, 3, 4, 5, 5 };
        Assert.assertEquals(ias.majorityElement(c).intValue() , 5);
    }

    @Test
    public void majorityElementSortedTest(){
        int[] a = {1, 2, 3, 3, 3, 3, 10};
        Assert.assertTrue(ias.majorityElementSorted(a,3));
        int[] b = {1, 1, 2, 4, 4, 4, 6, 6};
        Assert.assertFalse(ias.majorityElementSorted(b,4));
        int[] c = {1, 1, 1, 2, 2};
        Assert.assertTrue(ias.majorityElementSorted(c,1));
    }

    /**16.	Check if an array has a majority element
     * A majority element in an array is an element that appears strictly more than arr.size() / 2 times in the array**/
    @Test
    public void checkMajorityElementsTest()
    {
        int []a = {1, 1, 2, 1, 3, 5, 1};
        Assert.assertTrue(ias.checkMajorityElements(a));
    }
    /**17.	Two Pointers Technique, it get used for sorted array
     * typically used for Two Sum in Sorted Arrays, Closest Two Sum, Three Sum, Four Sum, Trapping Rain Water **/
    @Test
    public void pairSumTwoPointerTechTest()
    {
        int a[] = {-8, 1, 4, 6, 10, 45};
        int target = 16;
        List<Integer> list = ias.pairSumTwoPointerTech(a, target);
        Assert.assertEquals(list.get(0).intValue(),6);
        Assert.assertEquals(list.get(1).intValue(),10);

        int []b ={10, 20, 30};
        Assert.assertEquals(ias.pairSumTwoPointerTech(b,70).size(),0);
    }
    /**18.	Find a peak element, greater than its left and right Log(n)**/
    @Test
    public void peakElementTest()
    {
        int []a ={10, 20, 15, 2, 23, 90, 80};
        Assert.assertEquals(1,ias.peakElement(a));
    }
}
