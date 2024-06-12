package com.design.analysis.quick.prep.string;

import java.util.List;

/*
String
Question 1 : How to reverse a String in java? Can you write a program without using any java inbuilt methods?
Question 2 : Write a java program to check if two Strings are anagram in java?
Question 3 : Write a program to check if String has all unique characters in java?
Question 4 : How to check if one String is rotation of another String in java?
Question 5 : How to find duplicate characters in String in java?
Question 6 : Find first non repeated character in String in java?
Question 7 : Find all substrings of String in java?
Question 8 : Find length of String without using any inbuilt method in java?
Question 9 : Write a program to print all permutations of String in java?
Question 10 : Check is this string can be form a palindrome string
 */
public interface IString {
    /*Search element in array in fastest way */
    public int advSearch(int a[], int x);
    /*
     * Question 1 : How to reverse a String in java? Can you write a program without
     * using any java inbuilt methods?
     */
    public String revStr(String str);

    /*
     * Question 2 : Write a java program to check if two Strings are anagram in
     */
    public boolean checkAnagram(String str1, String str2);

    /*
     * java? Question 3 : Write a program to check if String has all unique
     * characters in java?
     */
    public boolean checkAllUniqueChar(String str);

    /*
     * Question 4 : How to check if one String is rotation of another String in
     * java?
     */
    public boolean checkStringRoation(String str1, String str2);

    /*
     * Question 5 : How to find duplicate characters in String in java?
     *
     *
     */
    public char[] duplicateChar(String str);

    /*
     * Question 6 : Find nth non repeated character in String in java? Question
     */
    public Character nThNonReptChar(String str, int n);

    public Character lastNthNonReptChar(String str, int n);
    /*
     * 7 : Find all substrings of String in java? Question
     */
    public List<String> allSubstr(String str);

    /*
     * 8 : Find length of String without using any inbuilt method in java?
     */
    public int len(String str);

    /*
     * Question 9 : Write a program to print all permutations of String in java?
     */
    public void permutationStr(String str, int l, int r);

    /*Question 10 : Check is this string can be form a palindrome string*/
    public boolean canBePalindrome(String str);

    /*for any type string small, caps number space etc..*/
    public boolean canBePalindromeX(String str);
}
