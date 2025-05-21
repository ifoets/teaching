package com.leetcode.string.hard;

public class StringHardImpl implements IStringHard {

    @Override
    public boolean isMatch(String s, String p)
    {
        int l=s.length();
        int m=p.length();
        int i=0, j=0;
        if(p.equals(".*"))
            return true;
        while (i<l && j<m)
        {
            if(p.charAt(j)=='.' || s.charAt(i)==p.charAt(j))
            {
                i++;
                j++;
            }else if(p.charAt(j)=='*')
            {
                // Two cases:
                // 1. '*' represents zero occurrence of the preceding character
                // 2. '*' represents one or more occurrence of the preceding character. .* will be always true
                if(j>1 && i>0 && s.charAt(i)!=p.charAt(j-1) && s.charAt(i-1)==p.charAt(j-2))
                    j++;
                else if(j > 0 && i< l-1 && (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.')) {
                    i++;
                    j++;
                    while (i<l && s.charAt(i-1) == s.charAt(i))
                        i++;
                }
                else if(p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') {
                    i++;
                    j++;
                }
                else j++;
            }
            else j++;//for nonmatching and non . or *
        }
        return i==l&&j==m;
    }

    @Override
    public boolean isMatchDp(String s, String p) {

        int l=s.length();
        int m = p.length();

        boolean dp[][] = new boolean[l+1][m+1];
        //for both empty p and s
        dp[0][0]=true;

        //for a*, a*b*, a*b*c* like senario
        for(int j=1;j<=m;j++)
        {
            if(p.charAt(j-1)=='*' && j>1)
                dp[0][j]=dp[0][j-2];
        }
        for(int i=1;i<=l;i++)
        {
            for(int j=1;j<=m;j++)
            {
                //for matching char or .
                if(p.charAt(j-1)=='.'|| s.charAt(i-1)==p.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else if(p.charAt(j-1)=='*' && j>1)
                {
                    // Two cases:
                    // 1. '*' represents zero occurrence of the preceding character
                    // 2. '*' represents one or more occurrence of the preceding character. .* will be always true
                    dp[i][j]=dp[i][j-2] ||
                        (dp[i-1][j] && (p.charAt(j-2)==s.charAt(i-1) || p.charAt(j-2)=='.'));
                }
            }
        }
        return dp[l][m];
    }
}
