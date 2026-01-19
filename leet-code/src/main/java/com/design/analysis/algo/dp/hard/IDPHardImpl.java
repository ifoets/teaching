package com.design.analysis.algo.dp.hard;

import java.util.Arrays;
import java.util.Stack;

/**Dynamic programming hard**/
public class IDPHardImpl implements IDPHard{

    /**10. Regular Expression Matching*/
    public boolean isMatchDp(String s, String p){
        int m=s.length();
        int n=p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0]=true;

        //handle a*, a*b*, a*b*c* situation
        for(int j=2;j<=n;j++)
        {
            if(p.charAt(j-1)=='*')
                dp[0][j]=dp[0][j-2];
        }

        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                char sc = s.charAt(i-1);
                char pc = p.charAt(j-1);
                if(sc==pc||pc=='.')
                    dp[i][j]=dp[i-1][j-1];

                else if(pc=='*')
                {
                    char prev = p.charAt(j-2);
                    // Option 1: skip prev* completely
                    dp[i][j]=dp[i][j-2];

                    if(prev==sc||prev=='.')
                        dp[i][j]=dp[i][j]||dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }

    /**32. Longest Valid Parentheses*/
    public String longestValidParentheses(String s){
        String maxLen="";
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            for (int j=i+1;j<=n;j++)
            {
                String subStr=s.substring(i,j);
                if(isValidFormat(subStr))
                {
                    if(maxLen.length()<subStr.length())
                        maxLen=subStr;
                }
            }
        }
        return maxLen;
    }
    public boolean isValidFormat(String str)
    {
        Stack<Character> stack = new Stack<>();
        for(char ch:str.toCharArray())
        {
            if(ch=='(')stack.push(ch);
            else if(ch==')')
            {
                if(!stack.isEmpty()&&stack.peek()=='(')
                    stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
    @Override
    public int longestValidParenthesesDp(String s){
        int n = s.length();
        int []dp = new int[n];
        int max=0;
        for(int i=1;i<n;i++)
        {
           if(s.charAt(i)==')')
           {
               // Case 1: "()",()()()
               if(s.charAt(i-1)=='(') {
                   dp[i]=(i>=2?dp[i-2]:0)+2; //for()() scenario
               }//case 2: (()),((())) senario
               else {
                   int j=i-dp[i-1]-1;
                   if(j>=0&&s.charAt(j)=='(')
                       dp[i]=dp[i-1]+2;
                   if(j-1>=0) //for ()(()) senario adding already previously connected balanced
                       dp[i]+=dp[j-1];
               }
               max = Math.max(max, dp[i]);
           }
        }

        return max;
    }
}
