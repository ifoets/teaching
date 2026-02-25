package com.design.analysis.algo.two.pointer.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ITwoPointerEasyTest {

    ITwoPointerEasy itpe;

    @Before
    public void init()
    {
        itpe = new TwoPointerEasyImpl();
    }

    /**28. Find the Index of the First Occurrence in a String**/
    @Test
    public void strStrTest(){
        Assert.assertEquals(0,itpe.strStr("a","a"));
        Assert.assertEquals(2,itpe.strStr("hello","ll"));
    }
}
