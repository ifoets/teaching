package com.design.analysis.algo.concurrency.medium;

import org.junit.Before;
import org.junit.Test;

public class IConcurrencyMediumTest {


    IConcurrencyMedium icm;

    @Before
    public void init()
    {
        icm = new ConcurrencyMediumImpl();
    }

    /**1115. Print FooBar Alternately**/
    @Test
    public void printFootBarAlternatelyTest() throws InterruptedException {
        icm.printFootBarAlternately(3);
    }
}
