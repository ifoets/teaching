package com.design.analysis.algo.simulation.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ISimulationMediumTest {

    ISimulationMedium ism;

    @Before
    public void init()
    {
        ism = new SimulationMediumImpl();
    }

    /**43. Multiply Strings**/
    @Test
    public void multiplyTest()
    {
        Assert.assertEquals("240",ism.multiply("15","16"));
        Assert.assertEquals("56088",ism.multiply("123","456"));
    }
}
