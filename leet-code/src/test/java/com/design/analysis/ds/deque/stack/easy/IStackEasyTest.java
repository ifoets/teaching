package com.design.analysis.ds.deque.stack.easy;

import com.design.analysis.ds.deque.stack.easy.IStackEasy;
import com.design.analysis.ds.deque.stack.easy.StackEasyImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IStackEasyTest {

    IStackEasy ise;

    @Before
    public void init()
    {
        ise = new StackEasyImpl();
    }

    /**20. Valid Parentheses**/
    @Test
    public void isValidTest()
    {
        String[] strList ={"()","()[]{}","(]","([])","([)]"};
        boolean[] expRs={true,true,false,true,false};
        for (int i=0;i<strList.length;i++)
        {
            Assert.assertEquals(expRs[i],ise.isValid(strList[i]));
        }
    }
}
