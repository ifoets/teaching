package com.design.analysis.algo.manipulation.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class IBitEasyOperationTest {

    IBitEasyOperation ibo;

    @Before
    public void init() {
        ibo = new BitEasyOperationImpl();
    }

    /**
     * 67. Add Binary number
     */
    @Test
    public void addBinaryTestTest() {
        Assert.assertEquals("100", ibo.addBinary("11","1"));
    }

    /**Analysis on Add Binary number*/
    @Test
    public  void addNumberByBitOperTest()
    {
        Assert.assertEquals(36,ibo.addNumberByBitOptr(19,17));
    }

    @Test
    public void subtractNumberByBitOptrTest()
    {
        Assert.assertEquals(10, ibo.subtractNumberByBitOptr(20,10));
        Assert.assertEquals(-10, ibo.subtractNumberByBitOptr(10,20));
    }

    @Test
    public void multipleNumberByBitOptrTest()
    {
        Assert.assertEquals(200,ibo.multipleNumberByBitOptr(10,20));
        Assert.assertEquals(-200,ibo.multipleNumberByBitOptr(20,-10));
    }

    @Ignore
    @Test
    public void divideNumberBYBitOptrTest()
    {
       // ibo.divideNumberBYBitOptr(20,5);
        Assert.assertEquals(4,ibo.divideNumberBYBitOptr(78,6));
       // Assert.assertEquals(10,ibo.divideNumberBYBitOptr(200,20));
    }
    @Test
    public void test() {

        System.out.println(10>>>1);
    }


}
