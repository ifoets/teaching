package com.design.analysis.core.algo.utils;

import org.junit.Assert;
import org.junit.Test;

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
}
