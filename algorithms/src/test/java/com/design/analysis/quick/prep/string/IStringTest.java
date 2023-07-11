package com.design.analysis.quick.prep.string;

import com.hackerrank.easy.basic.sorting.IBasicEasySorting;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class IStringTest {

    IString is;

    @Before
    public void init()
    {
        is = new StringImpl();
    }
    /*Search element in array in fastest way */
    @Test
    public void advSearchTest()
    {
         int a[] = new int[101];
         for(int i=1;i<101;a[i]=i,i++);
        Assert.assertTrue(is.advSearch(a,50)==50);
    }
    /*
     * Question 1 : How to reverse a String in java? Can you write a program without
     * using any java inbuilt methods?
     */
    @Test
    public void revStrTest()
    {
        Assert.assertTrue(is.revStr("kumar").equals("ramuk"));
    }

    /*
     * Question 2 : Write a java program to check if two Strings are anagram in
     */
    @Test
    public void checkAnagramTest()
    {
         Assert.assertTrue(is.checkAnagram("kumar","marku"));
        Assert.assertFalse(is.checkAnagram("kumar","mabku"));
    }
    /*
     * java? Question 3 : Write a program to check if String has all unique
     * characters in java?
     */
    @Test
    public void checkAllUniqueCharTest()
    {
        Assert.assertTrue(is.checkAllUniqueChar("abcighel"));
        Assert.assertFalse(is.checkAllUniqueChar("abcigheg"));
    }

    /*
     * Question 4 : How to check if one String is rotation of another String in
     * java?
     */
    @Test
    public void checkStringRoationTest()
    {
        Assert.assertFalse(is.checkStringRoation("kumar","maruk"));
        Assert.assertTrue(is.checkStringRoation("kumar","marku"));
    }

    /*
     * Question 5 : How to find duplicate characters in String in java?
     *
     *
     */
    @Test
    public void duplicateCharTest()
    {
        String str = "abhimanyukumar";
       Assert.assertEquals(String.copyValueOf(is.duplicateChar(str)), "amu");
    }

    /*
     * Question 6 : Find first non repeated character in String in java? Question
     */
    @Test
    public void nThNonReptCharTest()
    {
       String str ="abhimanyu";
       Assert.assertTrue(is.nThNonReptChar(str,1)=='b');
        Assert.assertTrue(is.nThNonReptChar(str,3)=='i');
    }
    @Test
    public void lastNthNonReptCharTest()
    {
        String str ="abhimanyu";
        Assert.assertTrue(is.lastNthNonReptChar(str,1)=='u');
        Assert.assertTrue(is.lastNthNonReptChar(str,3)=='n');
    }
    /*
     * 7 : Find all substrings of String in java? Question
     */
    @Test
    public void allSubstrTest()
    {
      String str[] ={"a","ab","abc","b","bc","c"};
      List<String> list = is.allSubstr("abc");
      for(int i=0;i<list.size();i++)
         Assert.assertTrue(str[i].equals(list.get(i)));
    }

    /*
     * 8 : Find length of String without using any inbuilt method in java?
     */
    @Test
    public void lenTest()
    {
        Assert.assertTrue(is.len("abhimanyu")==9);
    }


    /*
     * Question 9 : Write a program to print all permutations of String in java?
     */
    @Test
    public void permutationStrTest()
    {
       is.permutationStr("abc",0, 2);
    }

    /*Question 10 : Check is this string can be form a palindrome string, should not be more than one char odd count*/
    @Test
    public void canBePalindromeTest()
    {
        String [] strArr ={"a","aab","abab","abcab"};
        String [] strArr1 = {"ab","aaab","abca","abcaba"};
        for(String str:strArr)
        Assert.assertTrue(is.canBePalindrome(str));
        for(String str:strArr1)
        Assert.assertFalse(is.canBePalindrome(str));
    }
}
