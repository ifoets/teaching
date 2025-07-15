package com.leetcode.algorithms.string.hard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IStringHardTest {

    private IStringHard ish;

    @Before
    public void init()
    {
        ish = new StringHardImpl();
    }

    @Test
    public void isMatchTest()
    {

        Assert.assertFalse(ish.isMatch("aaa","ab*a"));
        Assert.assertTrue(ish.isMatch("aaa","ab*aa"));
        Assert.assertFalse(ish.isMatch("aa","a"));
        Assert.assertTrue(ish.isMatch("aa","a*"));
        Assert.assertTrue(ish.isMatch("aaaaa","a*"));
        Assert.assertTrue(ish.isMatch("baa",".*"));
        Assert.assertTrue(ish.isMatch("aba",".*"));
        Assert.assertFalse(ish.isMatch("ab",".*c"));
        Assert.assertTrue(ish.isMatch("aab","c*a*b"));

    }

    @Test
    public void isMatchDpTest()
    {

        Assert.assertFalse(ish.isMatchDp("aaa","ab*a"));
        Assert.assertTrue(ish.isMatchDp("aaa","ab*aa"));
        Assert.assertFalse(ish.isMatchDp("aa","a"));
        Assert.assertTrue(ish.isMatchDp("aa","a*"));
        Assert.assertTrue(ish.isMatchDp("aaaaa","a*"));
        Assert.assertTrue(ish.isMatchDp("baa",".*"));
        Assert.assertTrue(ish.isMatchDp("aba",".*"));
        Assert.assertFalse(ish.isMatchDp("ab",".*c"));
        Assert.assertTrue(ish.isMatchDp("aab","c*a*b"));

    }
}
