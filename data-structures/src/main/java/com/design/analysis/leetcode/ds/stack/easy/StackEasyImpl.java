package com.design.analysis.leetcode.ds.stack.easy;

import java.util.Stack;

public class StackEasyImpl implements IStackEasy {

    /** 20. Valid Parentheses*/
    @Override
    public  boolean isValidParentheses(String s){

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray())
        {
            switch (ch)
            {
                case '(', '[', '{' -> stack.push(ch);
                case ')', '}', ']' ->
                {
                    if(stack.isEmpty())
                        return false;
                    else {
                        char top = stack.pop();
                        if ((ch == ')' && top != '(') ||
                            (ch == '}' && top != '{') ||
                            (ch == ']' && top != '[')) {
                            return false;
                        }
                    }
                }
                default -> throw new IllegalStateException("Unexpected value: " + ch);
            }
        }
        return stack.empty();
    }
}
