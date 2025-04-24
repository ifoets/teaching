package com.design.analysis.core.algo.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class AlgoUtilsTest {

    @Test
    public void countSetBitsUtilTest() {
        Assert.assertEquals(AlgoUtils.countSetBitsUtil(7) , 3);
        Assert.assertEquals(AlgoUtils.countSetBitsUtil(16) , 1);
        Assert.assertEquals(AlgoUtils.countSetBitsUtil(15) , 4);
    }

    @Test
    public void numOfDigitTest() {

        Assert.assertEquals(1 , AlgoUtils.numOfDigit(7));
        Assert.assertEquals(2 , AlgoUtils.numOfDigit(10));
        Assert.assertEquals(4 , AlgoUtils.numOfDigit(7109));
        Assert.assertEquals(5 , AlgoUtils.numOfDigit(19087));
    }

    @Test
    public void numOfDigitInArrayTest() {
        int []a1 = new int[10];
        a1[0] = 1;
        a1[1] = 2;

        int []b1 = new int[10];
        b1[0] = 1;
        b1[1] = 1;
        b1[2] = 3;

        int []c = new int[10];
        Assert.assertEquals(2 , AlgoUtils.numOfDigitInArray(a1));
        Assert.assertEquals(3 , AlgoUtils.numOfDigitInArray(b1));
        Assert.assertEquals(0 , AlgoUtils.numOfDigitInArray(c));

        int []a = { 1, 2, 3, 4, 5 };
        Assert.assertEquals(5 , AlgoUtils.numOfDigitInArray(a));

    }

    @Test
    public void precedenceTest() {
        Assert.assertEquals(AlgoUtils.precedence('*') , 2);
        Assert.assertEquals(AlgoUtils.precedence('+') , 1);
        Assert.assertEquals(AlgoUtils.precedence('^') , 3);
    }

    @Test
    public void isOperandTest() {
        Assert.assertFalse(AlgoUtils.isOperand('*'));
        Assert.assertTrue(AlgoUtils.isOperand('A'));
        Assert.assertFalse(AlgoUtils.isOperand('1') );
    }
    @Test
    public void binarySearchJustGreaterTest()
    {
        int []a = {3,4};
        Assert.assertEquals(AlgoUtils.binarySearchJustGreaterOrLess(a,0,a.length-1,-1, true),0);
        Assert.assertEquals(AlgoUtils.binarySearchJustGreaterOrLess(a,0,a.length-1,-1, false),-1);
        int []b= {-1,4,5,8};

        Assert.assertEquals(AlgoUtils.binarySearchJustGreaterOrLess(b,0,b.length-1,2, true),1);
        Assert.assertEquals(AlgoUtils.binarySearchJustGreaterOrLess(b,0,b.length-1,2, false),0);
        int []c= {-1,2,3,7,12};

        Assert.assertEquals(AlgoUtils.binarySearchJustGreaterOrLess(c,0,c.length-1,9, true),4);
        Assert.assertEquals(AlgoUtils.binarySearchJustGreaterOrLess(c,0,c.length-1,9, false),3);
    }
    @Test
    public  void reversePartTest()
    {
        int []a ={1,2,3,4,5,6,7,8,9,10};
        int []b={1,2,3,4,5,10,9,8,7,6};
        AlgoUtils.reversePart(a,a.length/2,a.length-1);
        for(int i=0;i<a.length;i++)
            Assert.assertEquals(b[i],a[i]);
    }
    @Test
    public  void swapAlternativeTest()
    {
        int []a={1,2,3,4,5,6,7,8,9,10,11};
        int []b={2,1,4,3,6,5,8,7,10,9,11};
        AlgoUtils.swapAlternative(a);
        for(int i=0;i<a.length;i++)
            Assert.assertEquals(b[i],a[i]);
    }
}
