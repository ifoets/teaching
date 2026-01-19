package com.design.analysis.algo.design.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class IDesignMediumTest {

    IDesignMedium idm;

    @Before
    public void init()
    {
        idm = new DesignMediumImpl();
    }

    /**146. LRU Cache**/
    @Test
    public void LRUCacheOperationTest()
    {
        String[] command={"put","put","get","put","get","put","get","put","disp","put"};
        String[] values={"one","two","","three","","four","","five","","six"};
        int[] key={1,2,1,3,2,4,3,5,0,6};
        Map<Integer,String> expMap = Map.of(4,"four", 3,"three", 5,"five", 6,"six");
        Map<Integer,String> result = idm.LRUCacheOperation(command,values,key);
        System.out.println(result.toString());
        Assert.assertEquals(expMap,result);
    }
}
