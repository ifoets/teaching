package com.design.analysis.leetcode.ds.stack.hard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IStackHardTest {

    private IStackHard ish;

    @Before
    public void inti()
    {
        ish = new StackHardImpl();
    }


    @Test
    public void longestValidParenthesesTest()
    {
        Assert.assertEquals(2,ish.longestValidParentheses("(()"));
        Assert.assertEquals(4,ish.longestValidParentheses(")()())"));
        Assert.assertEquals(6,ish.longestValidParentheses("(()())"));
        Assert.assertEquals(2,ish.longestValidParentheses("()(()"));
    }

    @Test
    public void trapWaterTest()
    {
        int [] h = {0,1,0,2,1,0,1,3,2,1,2,1};
        Assert.assertEquals(6,ish.trapWater(h));
        int [] h1 = {4,2,0,3,2,5};
        Assert.assertEquals(9,ish.trapWater(h1));
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
