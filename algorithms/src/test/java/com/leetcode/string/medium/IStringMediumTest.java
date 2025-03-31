package com.leetcode.string.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

public class IStringMediumTest {

    private IStringMedium ism;

    @Before
    public void init(){
        ism = new StringMediumImpl();
    }

    @Test
    public void lengthOfLongestSubstringTest(){
        int rs[]={3,1,3,1,2};
        String str[] ={"abcabcbb","bbbbb","pwwkew" ," ","aab"};
        for(int i=0;i<rs.length;i++)
            Assert.assertEquals(rs[i],ism.lengthOfLongestSubstring(str[i]));
    }

    /** 5. Longest Palindromic Substring*/
    @Test
    public void longestPalindromeTest(){
        String[] rs={"bab","bb"};
        String[] str ={"babad","cbbd"};
        for(int i=0;i<rs.length;i++)
        Assert.assertEquals(rs[i],ism.longestPalindrome(str[i]));
    }
    /** 6. Zigzag Conversion*/
    @Test
    public void convertTest()
    {
        String[] rs={"PAHNAPLSIIGYIR","PINALSIGYAHRPI","AB"};
        String[] str ={"PAYPALISHIRING","PAYPALISHIRING","AB"};
        int []numRows={3,4,1};
        for(int i=0;i<rs.length;i++)
            Assert.assertEquals(rs[i],ism.convert(str[i],numRows[i]));
    }
    /**8. String to Integer (atoi)*/
    @Test
    public void myAtoiTest(){
        int[] rs={-42,1337,0,-2147483648,0};
        String[] str ={" -042","1337c0d3","0-1","-91283472332","words and 987"};
        for(int i=0;i<rs.length;i++)
            Assert.assertEquals(rs[i],ism.myAtoi(str[i]));
    }
}
