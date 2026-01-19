package com.design.analysis.ds.deque.stack.medium;

import java.util.*;

public class StackMediumImpl implements IStackMedium{

    /**71. Simplify Path**/
    @Override
    public String simplifyPath(String path){
        Deque<String> stack = new ArrayDeque<>();

        String[] parts = path.split("/+"); // handles //, ///

        for (String part : parts) {
            if (part.isEmpty() || part.equals(".")) {
                continue;
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(part);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append("/").append(stack.removeLast());
        }

        return result.isEmpty() ? "/" : result.toString();
    }
}
