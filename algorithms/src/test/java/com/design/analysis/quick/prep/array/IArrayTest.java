package com.design.analysis.quick.prep.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IArrayTest {
    IArray ir;

    @Before
    public void init()
    {
        ir = new ArrayImpl();
    }

    /*Question 41 :
     * Two sorted array a1 and a2 a2 have some element and exttra space of size a1
     * sort without extra space and complexity n arr1 m [3,4,9,10,20] arr2 n with m
     * space [ ,1,2, ,8,11, ,13, , ]
     */
    @Test
    public void specialSortTest()
    {
        int a[] = { 3, 4, 9, 10, 20 };
        int b[] = { 0, 1, 2, 0, 8, 11, 0, 13, 0, 0 };
        ir.specialSort(a, b);
        System.out.println(Arrays.toString(b));
    }

    @Test
    public void minNoOfPlatformXTest()
    {
        int[] arr = { 1100, 1500, 1800, 900, 940, 950 };
        int[] dep = { 1130, 1900, 2000, 910, 1200, 1120 };
        Assert.assertTrue(ir.minNoOfPlatformX(arr,dep)==3);
    }
}
