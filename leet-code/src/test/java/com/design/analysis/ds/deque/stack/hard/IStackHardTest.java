package com.design.analysis.ds.deque.stack.hard;

import com.design.analysis.ds.deque.stack.hard.IStackHard;
import com.design.analysis.ds.deque.stack.hard.StackHardImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IStackHardTest {

    IStackHard ish;

    @Before
    public void init()
    {
        ish = new StackHardImpl();
    }

    /**32. Longest Valid Parentheses**/
    @Test
    public void longestValidParenthesesTest()
    {
         int n = ish.longestValidParentheses(")()())((()))");
        Assert.assertEquals(6,n);
    }
    @Test
    public void longestValidParenthesesXTest()
    {
        String str = ish.longestValidParenthesesX(")()())((()))");
        Assert.assertEquals("((()))",str);
    }
}
