package com.design.analysis.algo.two.pointer.medium;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ITwoPointerMediumTest {

    private ITwoPointerMedium itpm;

    @Before
    public void init()
    {
        itpm = new TwoPointerMediumImpl();
    }

    /**5. Longest Palindromic Substring*/
    @Test
    public void longestPalindromeTest(){
        String[] rs={"aba","bb"};
        String[] str ={"babad","cbbd"};
        for(int i=0;i<rs.length;i++)
            Assert.assertEquals(rs[i],itpm.longestPalindrome(str[i]));
    }
    /**11. Container With Most Water*/
    @Test
    public void maxAreaTest()
    {
      int [] height ={1,8,6,2,5,4,8,3,7};
      Assert.assertEquals(49,itpm.maxArea(height));
      int [] height1= {1,1};
        Assert.assertEquals(1,itpm.maxArea(height1));
    }
    /**15. 3Sum*/
    @Test
    public void threeSumTest()
    {
        /*Input: nums = [-1,0,1,2,-1,-4]
            Output: [[-1,-1,2],[-1,0,1]]*/
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> rsList = itpm.threeSum(nums);
        for (List<Integer> list:rsList)
            System.out.println(list);
        Assert.assertEquals(2,rsList.size());
    }
}
