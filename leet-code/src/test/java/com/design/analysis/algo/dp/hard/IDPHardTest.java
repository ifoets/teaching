package com.design.analysis.algo.dp.hard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IDPHardTest {

    public IDPHard idph;

    @Before
    public void init(){
        idph = new IDPHardImpl();
    }

    /**10. Regular Expression Matching*/
    @Test
    public void isMatchDpTest()
    {
        System.out.println(idph.isMatchDp("ab",".*"));
    }

    /**32. Longest Valid Parentheses*/
    @Test
    public void longestValidParenthesesTest()
    {
         Assert.assertEquals("()",idph.longestValidParentheses("(()"));
         Assert.assertEquals("()()",idph.longestValidParentheses(")()())"));
    }

    @Test
    public void longestValidParenthesesDpTest()
    {
        Assert.assertEquals(2,idph.longestValidParenthesesDp("(()"));
        Assert.assertEquals(4,idph.longestValidParenthesesDp(" )()())"));

    }
}
