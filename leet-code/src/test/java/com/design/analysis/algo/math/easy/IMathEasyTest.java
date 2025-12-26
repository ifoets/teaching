package com.design.analysis.algo.math.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IMathEasyTest {

    IMathEasy ime;

    @Before
    public void init()
    {
        ime = new MathEasyImpl();
    }

    /**9. Palindrome Number**/
    @Test
    public void isPalindromeTest()
    {
        Assert.assertTrue(ime.isPalindrome(121));
    }
}
