package com.design.analysis.algo.divide.and.conquer.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IDivideConquerMediumTest {
    IDivideConquerMedium idcm;

    @Before
    public void init()
    {
        idcm = new DivideConquerMediumImpl();
    }

    /**53. Maximum Subarray**/
    @Test
     public void maxSubArrayTest(){
        Assert.assertEquals(6,idcm.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    @Test
    public void findMaxSumContineousArrayTest()
    {
        int []a = {-2,1,-3,4,-1,2,1,-5,4};
        int[] expResult={4,-1,2,1};
        int[] rs = idcm.findMaxSumContineousArray(a);
        Assert.assertArrayEquals(expResult,rs);
    }
}
