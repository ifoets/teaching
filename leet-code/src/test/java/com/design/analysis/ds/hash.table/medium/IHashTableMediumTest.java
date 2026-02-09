package com.design.analysis.ds.hash.table.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class IHashTableMediumTest {

    IHashTableMedium ihm;

    @Before
    public void init()
    {
        ihm = new HashTableMediumImpl();
    }

    /**73. Set Matrix Zeroes**/
    @Test
    public void setZeroesTest()
    {
      int [][] matrix={
          {1,1,1},
          {1,0,2},
          {4,5,6}
      };
        int [][] exp={
            {1,0,1},
            {0,0,0},
            {4,0,6}
        };
      ihm.setZeroesRowsColms(matrix);
      for(int i=0;i<matrix.length;i++)
          Assert.assertArrayEquals(matrix[i],exp[i]);
    }

    @Test
    public void setZeroesDigonalsTest()
    {
        int [][] matrix={
            {1,1,1},
            {1,9,0},
            {4,8,6}
        };

        int[][] exp= {
            {1, 0, 1},
            {1, 9, 0},
            {4, 0, 6}
        };
        ihm.setZeroesDigonals(matrix);
        for(int i=0;i<matrix.length;i++)
            Assert.assertArrayEquals(matrix[i],exp[i]);
    }

}
