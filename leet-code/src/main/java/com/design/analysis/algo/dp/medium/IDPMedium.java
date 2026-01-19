package com.design.analysis.algo.dp.medium;

import java.util.List;

/**Dynamic programming medium*/
public interface IDPMedium {

    /**5. Longest Palindromic Substring*/
     String longestPalindrome(String s);
     String longestPalindromeDp(String s);

    /**22. Generate Parentheses, Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.*/
    List<String> generateParenthesis(int n);
    List<String> generateParenthesisDp(int n);
}
