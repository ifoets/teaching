package com.design.analysis.leetcode.ds.stack.hard;

public class StackHardImpl implements IStackHard{
    /**32. Longest Valid Parentheses, Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.*/
    @Override
    public int longestValidParentheses(String s){

        int left=0,right=0, maxLen=0;
        //from left to right handle like ()) expr
        for(char ch: s.toCharArray())
        {
            if(ch=='(') left++;
            else right++;

            if(left==right)
            {
                maxLen = Math.max(maxLen, 2*right);
            }else if(right>left)
            {
                left = right=0;
            }
        }
        //from right to left handle like (() expr
        left = right=0;
        for(int i=s.length()-1;i>0;i--)
        {
            char ch = s.charAt(i);
            if(ch=='(') left++;
            else right++;

            if(left==right)
            {
                maxLen = Math.max(maxLen, 2*left);
            }else if(left>right)
            {
                left=right=0;

            }
        }
        return maxLen;
    }

    /**42. Trapping Rain Water, n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining*/
    @Override
    public int trapWater(int[] h){

        int tap=0, lmax=0, rmx=0,i=0,j=h.length-1;
        while (i<j)
        {
            lmax = Math.max(lmax,h[i]);
            rmx = Math.max(rmx, h[j]);
            tap+= lmax<rmx ? lmax-h[i++] : rmx - h[j--];
        }
        return tap;
    }
}
