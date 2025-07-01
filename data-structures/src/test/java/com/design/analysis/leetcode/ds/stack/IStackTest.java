package com.design.analysis.leetcode.ds.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IStackTest {

    private IStack ist;

    @Before
    public void init()
    {
        ist = new IStackImpl();
    }

    @Test
    public void isValidParenthesesTest()
    {
        Assert.assertTrue(ist.isValidParentheses("()[]{}"));
        Assert.assertFalse(ist.isValidParentheses("(]"));
        Assert.assertTrue(ist.isValidParentheses("([])"));
        Assert.assertFalse(ist.isValidParentheses("]()}"));
        Assert.assertFalse(ist.isValidParentheses("()(()"));
    }

    @Test
    public void longestValidParenthesesTest()
    {
        Assert.assertEquals(2,ist.longestValidParentheses("(()"));
        Assert.assertEquals(4,ist.longestValidParentheses(")()())"));
        Assert.assertEquals(6,ist.longestValidParentheses("(()())"));
        Assert.assertEquals(2,ist.longestValidParentheses("()(()"));
    }

    @Test
    public void trapWaterTest()
    {
        int [] h = {0,1,0,2,1,0,1,3,2,1,2,1};
        Assert.assertEquals(6,ist.trapWater(h));
        int [] h1 = {4,2,0,3,2,5};
        Assert.assertEquals(9,ist.trapWater(h1));
    }

    @Test
    public void test()
    {
        String s="kumar";
        for(int i=0;i<s.length();i++)
        {
            for(int j=i;j<= s.length();j++)
            {
                if(i<j)
                    System.out.println(s.substring(i,j));
            }
        }
    }
}
