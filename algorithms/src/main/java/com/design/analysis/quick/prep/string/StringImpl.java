package com.design.analysis.quick.prep.string;

import com.design.analysis.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class StringImpl implements IString {
    /* Search element in array in fastest way */
    public int advSearch(int a[], int x) {

        int N = a.length;
        // searies 5,25,125.625.search in chunk by chunk
        // you can put base 2,3,4,5 any thing here base is 5
        int n = (int) Math.pow(N, 1 / 5);
        if (a[0] == x)
            return 0;

        for (int i = 1; i < n;) {
            int result = search(a, x, i, 5);
            if (result != -1)
                return result;
            else
                i++;
        }
        // for last iteration
        for (int i = n; i < N; i++) {
            if (a[i] == x)
                return i;
        }
        return -1;
    }

    public int search(int a[], int x, int power, int base) {
        for (int i = (int) Math.pow(base, power - 1); i < Math.pow(base, power); i++) {
            if (a[i] == x)
                return i;
        }
        return -1;
    }

    /*
     * Question 1 : How to reverse a String in java? Can you write a program without
     * using any java inbuilt methods?
     */
    @Override
    public String revStr(String str) {

        if (str.length() == 1)
            return str;
        else
            return str.charAt(str.length() - 1) + revStr(str.substring(0, str.length() - 1));
    }
    /*
     * Question 2 : Write a java program to check if two Strings are anagram in
     */
    @Override
    public boolean checkAnagram(String str1, String str2) {

        if (str1.length() != str2.length())
            return false;
        int a[] = StringUtils.getIndexArr(str1);
        int b[] = StringUtils.getIndexArr(str2);

        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }

    /*
     * java? Question 3 : Write a program to check if String has all unique
     * characters in java?
     */
    @Override
    public boolean checkAllUniqueChar(String str) {

        int a[] =StringUtils.getIndexArr(str);

        for (int i = 0; i < 26; i++) {
            if (a[i] > 1)
                return false;
        }
        return true;
    }

    /*
     * Question 4 : How to check if one String is rotation of another String in
     * java?
     */
    @Override
    public boolean checkStringRoation(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        if (str1.concat(str1).contains(str2))
            return true;
        return false;
    }

    /*
     * Question 5 : How to find duplicate characters in String in java?
     */
    @Override
    public char[] duplicateChar(String str) {

        StringBuilder sb = new StringBuilder();
        int a[] = StringUtils.getIndexArr(str);
        for (int i = 0; i < 26; i++) {
            if (a[i] > 1)
                sb = sb.append((char) (i + 97));
        }
        return sb.toString().toCharArray();
    }

    /*
     * Question 6 : Find nth non repeated character in String in java? Question
     */
    @Override
    public Character nThNonReptChar(String str, int n) {
       int l=str.length();
        int a[] = StringUtils.getIndexArr(str);
        int count=0;
        for (int i = 0 ; i < l; i++) {
            if (a[str.charAt(i) - 97] == 1)
            {
                count++;
                if(count==n)
                    return str.charAt(i);
            }

        }
        return null;
    }
    public Character lastNthNonReptChar(String str, int n)
    {
        int l=str.length();
        int a[] = StringUtils.getIndexArr(str);
        int count=0;
        for (int i = l-1 ; i >= 0; i--) {
            if (a[str.charAt(i) - 97] == 1)
            {
                count++;
                if(count==n)
                    return str.charAt(i);
            }

        }
        return null;
    }

    /*
     * 7 : Find all substrings of String in java? Question
     */
    @Override
    public List<String> allSubstr(String str) {
        int n = str.length();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String st = (String) str.subSequence(i, j);
                list.add(st);
            }
        }
        return list;
    }

    /*
     * 8 : Find length of String without using any inbuilt method in java?
     */
    @SuppressWarnings("unused")
    @Override
    public int len(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            count++;
        }
        return count;
    }

    /*
     * Question 9 : Write a program to print all permutations of String in java?
     */
    @Override
    public void permutationStr(String str, int l, int r) {

        if (l == r)
            System.out.println(str);
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permutationStr(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    public String swap(String str, int i, int j) {
        char chArr[] = str.toCharArray();
        char temp = chArr[i];
        chArr[i] = chArr[j];
        chArr[j] = temp;
        return String.valueOf(chArr);
    }

    /*Question 10 : Check is this string can be form a palindrome string, should not be more than one char odd count*/
    public boolean canBePalindrome(String str)
    {
        int count=0;
        char [] chars = str.toLowerCase().toCharArray();
        int a[] = new int[26];
        for(int i=0;i<str.length();a[chars[i]-97]++,i++);

        for (int i=0;i<26;i++)
        {
            if(a[i]%2==1)
                count++;
            if(count>1)
                return false;
        }
        return true;
    }
}
