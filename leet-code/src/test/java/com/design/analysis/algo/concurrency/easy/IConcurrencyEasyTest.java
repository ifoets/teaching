package com.design.analysis.algo.concurrency.easy;

import org.junit.Before;
import org.junit.Test;

public class IConcurrencyEasyTest {

    IConcurrencyEasy ice;

    @Before
    public void init()
    {
        ice = new ConcurrencyEasyImpl();
    }
    /**1114. Print in Order**/
    @Test
    public void printInOrderTest()throws InterruptedException
    {
        ice.printInOrder();
    }
}
