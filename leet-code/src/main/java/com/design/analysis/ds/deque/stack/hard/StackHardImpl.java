package com.design.analysis.ds.deque.stack.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class StackHardImpl implements IStackHard{

    /**32. Longest Valid Parentheses**/
    @Override
    public int longestValidParentheses(String s){
        if(s.isEmpty()||s.length()==1) return 0;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(-1);
        int maxLen=0;

        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch=='(')stack.push(i);
            else {
                stack.pop();
                //reset start len
                if(stack.isEmpty())stack.add(i);
                else
                {
                    maxLen = Math.max(maxLen,i-stack.peek());
                }
            }
        }
        return maxLen;
    }

    @Override
    public String longestValidParenthesesX(String s){
        if(s.isEmpty()||s.length()==1) return "";

        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(-1);
        int maxLen=0;
        int start=0;

        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch=='(')stack.push(i);
            else {
                stack.pop();
                //reset start len
                if(stack.isEmpty())stack.add(i);
                else
                {
                    int len =i-stack.peek();
                    if(len>maxLen)
                    {
                        maxLen = len;
                        start = stack.peek()+1;
                    }
                }
            }
        }
        return maxLen==0?"":s.substring(start,start+maxLen);
    }

    /**84. Largest Rectangle in Histogram**/
    @Override
    public int largestRectangleArea(int[] heights){
return -1;
    }
}
