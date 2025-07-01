package com.design.analysis.leetcode.ds.stack.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IStackEasyTest {
    private IStackEasy ise;

    @Before
    public void init()
    {
        ise = new StackEasyImpl();
    }
    @Test
    public void isValidParenthesesTest()
    {
        Assert.assertTrue(ise.isValidParentheses("()[]{}"));
        Assert.assertFalse(ise.isValidParentheses("(]"));
        Assert.assertTrue(ise.isValidParentheses("([])"));
        Assert.assertFalse(ise.isValidParentheses("]()}"));
        Assert.assertFalse(ise.isValidParentheses("()(()"));
    }
}
