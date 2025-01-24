package com.design.analysis.core.algo.starpatterns;

import org.junit.Before;
import org.junit.Test;

public class IStarPatternsTest {

    public IStarPatterns isp;

    @Before
    public void inti()
    {
        isp = new StarPatternsImpl();
    }

    /** 1. print left bottom 90 degree triangle*/
    @Test
    public void leftBottomTriangleTest()
    {
        isp.leftBottomTriangle(10);

    }
    /** 2. print right up 90 degree triangle*/
    @Test
    public void rightUpTriangleTest()
    {
        isp.rightUpTriangle(10);
    }
}
