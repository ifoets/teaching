package com.design.analysis.algo.dp.medium;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IDPMediumImpl implements IDPMedium{

    /**5. Longest Palindromic Substring*/
    @Override
     public String longestPalindrome(String s){
        if (s == null || s.isEmpty()) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);     // Odd-length
            int len2 = expandAroundCenter(s, i, i + 1); // Even-length
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
     }
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length()
            && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    @Override
    public String longestPalindromeDp(String s){
        if (s == null || s.isEmpty()) return "";
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] best={0,1};//{start,len} default start=0, and len 1 char}

        IntStream.range(0,n).forEach(i->dp[i][i]=true);//single char is palindrome

        //start for check len 2 to n char checking
        IntStream.rangeClosed(2,n).forEach(len->
            IntStream.range(0, n-len+1).forEach(i->
            {
                int j=i+len-1;
                //s[i] == s[j], then checking inside substring s[i+1..j-1] is also a palindrome
                //i+1 < j-1 but it invalid for len==2, so checking len=2
                if(s.charAt(i)==s.charAt(j) && (len==2||dp[i+1][j-1]))
                {
                    dp[i][j]=true;
                    if(len>best[1]) //> for first and >= for last if n result have length
                    {
                        best[0]=i;
                        best[1]=len;
                    }
                }
            }));
        return s.substring(best[0],best[0]+best[1]);
    }

    /**22. Generate Parentheses, Given n pairs of parentheses,
     * write a function to generate all combinations of well-formed parentheses.*/
    @Override
    public List<String> generateParenthesis(int n){
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    public void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }
        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }

    @Override
    public List<String> generateParenthesisDp(int n){
        List<List<String>> dp = new ArrayList<>();
        dp.add(List.of("")); // dp[0]

        for (int i = 1; i <= n; i++) {
            List<String> list = new ArrayList<>();
            for (int left = 0; left < i; left++) {
                List<String> inside = dp.get(left);
                List<String> outside = dp.get(i - 1 - left);

                for (String in : inside) {
                    for (String out : outside) {
                        list.add("(" + in + ")" + out);
                    }
                }
            }
            dp.add(list);
        }

        return dp.get(n);
    }

}
