package com.design.analysis.ds.deque.stack.medium;

import com.design.analysis.ds.deque.stack.medium.IStackMedium;
import com.design.analysis.ds.deque.stack.medium.StackMediumImpl;
import org.junit.Before;
import org.junit.Test;

public class IStackMediumTest {

    IStackMedium ism;

    @Before
    public void init()
    {
        ism = new StackMediumImpl();
    }

    /**71. Simplify Path**/
    @Test
    public void simplifyPathTest()
    {
        String strs = "/../";//"/home/user/Documents/../Pictures";
        System.out.println(ism.simplifyPath(strs));
    }
}
