package com.design.analysis.algo.string.medium;

import java.util.List;

public interface IStringMedium {

    /** 3. Longest Substring Without Repeating Characters*/
    int lengthOfLongestSubstring(String s);
    String uniqueCharMaxSubStrS(String s);

    /** 5. Longest Palindromic Substring*/
    String longestPalindrome(String s);
    String longestPalindromeS(String s);

    /** 6. Zigzag Conversion*/
    String convert(String s, int numRows);

    /**8. String to Integer (atoi)*/
    int myAtoi(String s);

    /**12. Integer to Roman*/
    String intToRoman(int num);

    /**17. Letter Combinations of a Phone Number**/
    List<String> letterCombinations(String digits);
}
