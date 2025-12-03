package com.design.analysis.algo.manipulation;

import org.junit.Assert;
import org.junit.Test;

public class BitUtilsTest {



    @Test
    public void intToBinaryTest()
    {
        Assert.assertEquals("1010",BitUtils.intToBinary(10));
    }

    @Test
    public void binaryToIntTest()
    {
        Assert.assertEquals(10,BitUtils.binaryToInt("1010"));
    }
}
