package com.design.analysis.algo.two.pointer.easy;

public class TwoPointerEasyImpl implements ITwoPointerEasy{

    /**28. Find the Index of the First Occurrence in a String**/
    @Override
    public int strStr(String haystack, String needle){
        int start=0;
        for(int end=needle.length();end<=haystack.length();end++)
        {
            if(haystack.substring(start,end).equals(needle))
                return start;
            start++;
        }
        return -1;
    }
}
