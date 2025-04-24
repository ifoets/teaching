package com.design.analysis.utils;

import com.design.analysis.utils.ArraysUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ArraysUtilTest {

    @Test
    public void getIndexTest()
    {
        int a[] ={4,3,2,1};
        Assert.assertTrue(ArraysUtil.getIndex(a,4)==0);
        Assert.assertTrue(ArraysUtil.getIndex(a,1)==3);
    }

    @Test
    public void getMaxTest()
    {
        int a[] ={4,3,2,1,9,5,7,0};
        Assert.assertTrue(ArraysUtil.getMax(a)==9);
    }

    @Test
    public void getIndexedValTest()
    {
        int a[] = {1,2,3,4,5,0,7,9,5,76,2,5,7,8,2,5,9};
        System.out.println(Arrays.toString(ArraysUtil.getIndexedVal(a)));
    }

    @Test
    public void findFirstOccurrenceInSortedTest()
    {
        int a[] ={1, 2, 3, 3, 3, 3, 10};
        Assert.assertEquals(2,ArraysUtil.findFirstOccurenceInSorted(a,0,a.length-1,3));
        int []b = {1, 1, 2, 4, 4, 4, 6, 6};
        Assert.assertEquals(3,ArraysUtil.findFirstOccurenceInSorted(b,0,b.length-1,4));
    }
    @Test
    public void findPeakInSortedTest()
    {
        int a[] ={1, 2, 4, 5, 7, 8, 3};
        Assert.assertEquals(ArraysUtil.findPeakInSorted(a,1,a.length-2),5);
    }
}
