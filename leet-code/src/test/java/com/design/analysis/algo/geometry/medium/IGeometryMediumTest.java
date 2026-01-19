package com.design.analysis.algo.geometry.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IGeometryMediumTest {

    IGeometryMedium igm;

    @Before
    public void init()
    {
        igm = new GeometryMediumImpl();
    }

    /**223. Rectangle Area**/
    @Test
    public void computeAreaTest()
    {
        int ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2;
        Assert.assertEquals(45,igm.computeArea(ax1,ay1,ax2,ay2,bx1,by1,bx2,by2));
    }
}
