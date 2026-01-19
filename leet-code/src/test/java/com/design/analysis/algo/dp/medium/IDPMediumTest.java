package com.design.analysis.algo.dp.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**Dynamic programming medium*/
public class IDPMediumTest {
    
    public IDPMedium idpm;
    
    @Before
    public void init(){
        idpm = new IDPMediumImpl();
    }

    /**5. Longest Palindromic Substring*/
    @Test
    public void longestPalindromeTest(){
        Assert.assertEquals("abba",idpm.longestPalindrome("abba"));
        Assert.assertEquals("bb",idpm.longestPalindrome("cbbd"));
        Assert.assertEquals("aba",idpm.longestPalindrome("aba"));
        Assert.assertEquals("aba",idpm.longestPalindrome("babad"));
        Assert.assertEquals("f",idpm.longestPalindrome("abcdef"));
    }

    @Test
    public void longestPalindromeDpTest()
    {
        Assert.assertEquals("abba",idpm.longestPalindromeDp("abba"));
        Assert.assertEquals("bb",idpm.longestPalindromeDp("cbbd"));
        Assert.assertEquals("aba",idpm.longestPalindromeDp("aba"));
        Assert.assertEquals("bab",idpm.longestPalindromeDp("babad"));
        Assert.assertEquals("a",idpm.longestPalindromeDp("abcdef"));
    }

    /**22. Generate Parentheses, Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.*/
    @Test
    public void generateParenthesisTest()
    {
        List<String> rsList = idpm.generateParenthesis(3);
        System.out.println(rsList );
    }
    /*""
└── "("
    ├── "(("
    │   ├── "((("
    │   │   └── "((()"
    │   │        └── "((())"
    │   │             └── "((()))"
    │   └── "(()"
    │       ├── "(()("
    │       │   └── "(()()"
    │       │        └── "(()())"
    │       └── "(())"
    │            └── "(())("
    │                 └── "(())()"
    └── "()"
        └── "()("
            ├── "()(("
            │    ├── "()((("
            │    │     └── "()(()"
            │    │          └── "()(())"
            │    └── "()(()"
            │         └── "()(())"
            └── "()()"
                 └── "()()("
                      └── "()()()"
                   */
    @Test
    public void generateParenthesisDpTest()
    {
        List<String> rsList = idpm.generateParenthesisDp(3);
    }
}
