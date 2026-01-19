package com.design.analysis.algo.geometry.hard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IGeometryHardTest {

    IGeometryHard igh;

    @Before
    public void init()
    {
        igh = new GeometryHardImpl();
    }

    /**149. Max Points on a Line**/
    @Test
    public void maxPointsTest()
    {
        int[][] points={
            {1,1},
            {2,2},
            {3,3}
        };
        Assert.assertEquals(3,igh.maxPoints(points));
        int[][] pts=
            {
                {1,1},{3,2},{5,3},{4,1},{2,3},{1,4}
            };
        Assert.assertEquals(4,igh.maxPoints(pts));
        int[][] pts1=
            {
                {2,3},{3,3},{-5,3}
            };
        Assert.assertEquals(3,igh.maxPoints(pts1));
    }
}
