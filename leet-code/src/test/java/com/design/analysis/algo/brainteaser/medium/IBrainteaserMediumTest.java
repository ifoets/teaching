package com.design.analysis.algo.brainteaser.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IBrainteaserMediumTest {

    IBrainteaserMedium ibm;

    @Before
    public void init()
    {
        ibm = new BrainteaserMediumImpl();
    }

    /**319. Bulb Switcher**/
    @Test
    public void bulbSwitchTest()
    {
        Assert.assertEquals(2,ibm.bulbSwitch(4));
    }
}
