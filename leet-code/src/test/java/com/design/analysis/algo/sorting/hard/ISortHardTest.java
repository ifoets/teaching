package com.design.analysis.algo.sorting.hard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ISortHardTest {

    ISortHard ish;

    @Before
    public void init()
    {
        ish = new SortHardImpl();
    }

    /**218. The Skyline Problem**/
    @Test
    public void getSkylineTest(){
         int[][] buildings={
             {2,9,10},
             {3,7,15},
             {5,12,12},
             {15,20,10},
             {19,24,8}
         };
        List<List<Integer>> expResult=List.of(
             List.of(2,10),
             List.of(3,15),
             List.of(7,12),
             List.of(12,0),
             List.of(15,10),
             List.of(20,8),
             List.of(24,0)
        );
        List<List<Integer>> result = ish.getSkyline(buildings);
        for(int i=0;i<result.size();i++)
            Assert.assertEquals(expResult.get(i),result.get(i));
    }
}
