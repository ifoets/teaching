package com.design.analysis.algo.string.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IStringEasyTest {

    private IStringEasy ise;

    @Before
    public void init(){
        ise = new StringEasyImpl();
    }
    /**13. Roman to Integer*/
    @Test
    public void romanToIntTest()
    {
        Assert.assertEquals(3749, ise.romanToInt("MMMDCCXLIX"));
        Assert.assertEquals(58, ise.romanToInt("LVIII"));
        Assert.assertEquals(1994, ise.romanToInt("MCMXCIV"));
    }

    @Test
    public void romanToIntXTest()
    {
        Assert.assertEquals(3749, ise.romanToIntX("MMMDCCXLIX"));
        Assert.assertEquals(58, ise.romanToIntX("LVIII"));
        Assert.assertEquals(1994, ise.romanToIntX("MCMXCIV"));
    }
}
