package com.design.analysis.algo.math.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IMathMediumTest {

    IMathMedium imm;

    @Before
    public void init()
    {
        imm = new MathMediumImpl();
    }

    /**7. Reverse Integer**/
    @Test
    public void reverseTest()
    {
        Assert.assertEquals(123,imm.reverse(321));
        Assert.assertEquals(-123,imm.reverse(-321));
    }

    /**29. Divide Two Integers**/
    @Test
    public void divideTest()
    {
        //Assert.assertEquals(3,imm.divide(10,3));
        //Assert.assertEquals(-2,imm.divide(7,-3));
        System.out.println(imm.divide(-2147483648,-1));
    }
}
