package com.design.analysis.ds.deque.stack.easy;

import java.util.Stack;

public class StackEasyImpl implements IStackEasy{

    /**20. Valid Parentheses**/
    @Override
    public boolean isValid(String s){
        if(s.isEmpty())return true;

        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            switch (ch)
            {
                case '(','{','['-> stack.add(ch);
                case ')','}',']'->
                {
                    if(!stack.isEmpty()) {
                        char peek=stack.peek();
                        if(peek=='('&&ch==')'||peek=='{'&&ch=='}'||peek=='['&&ch==']') {
                            stack.pop();
                        }
                        else return false;
                    }//at empty stack no need to add closing
                    else return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
