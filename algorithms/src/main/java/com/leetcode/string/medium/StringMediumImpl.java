package com.leetcode.string.medium;

import com.design.analysis.utils.StringUtils;

import java.util.*;
import java.util.stream.IntStream;

public class StringMediumImpl implements IStringMedium{

    /** 3. Longest Substring Without Repeating Characters*/
    @Override
    public int lengthOfLongestSubstring(String s) {

        char[] charA = s.toCharArray();
        int N=charA.length;
        int i=-1;
        int j=i+1;
        Set<Character> set = new HashSet<>();
        int maxLen=-1;
        while (i<N && j<N)
        {
            if(set.contains(charA[j]))
            {
                maxLen=Math.max(maxLen,set.size());
                set=new HashSet<>();
                i++;
                j=i+1;
                    set.add(charA[j++]);
            }
            else{
                    set.add(charA[j++]);
            }
        }
        return Math.max(maxLen,set.size());
    }

    /** 5. Longest Palindromic Substring O(n)*/
    @Override
    public String longestPalindrome(String s) {

        if(s==null||s.length()==1)
            return s;
        int N= s.length();
        int[] odd = new int[N];
        int[] even = new int[N];
        Arrays.fill(odd,1);
        Arrays.fill(even,1);
        for(int i=1;i<N;i++)
        {
            //odd arrangement
            int x=i;
            int y=i;
            while (x>0 && y<N-1 && s.charAt(x-1)==s.charAt(y+1)) {
                x--;
                y++;
                odd[i] += 2;
            }

            //even arrangement
            int j=i-1;
            int k=i;
            while (j>=0 && k<N && s.charAt(j)==s.charAt(k)) {
                j--;
                k++;
                even[i-1] += k-1==i?1:2;
            }
        }
        int oddMax = Arrays.stream(odd).max().getAsInt();
        int evenMax = Arrays.stream(even).max().getAsInt();
        if(evenMax > oddMax)
        {
            int evenIndex= IntStream.range(0, even.length)
                    .boxed()
                    .max(Comparator.comparingInt(i -> even[i]))
                    .orElse(-1);
            return s.substring(evenIndex-(evenMax/2-1),evenIndex+(evenMax/2+1));
        }
        else{
            int oddIndex=  IntStream.range(0, odd.length)
                    .boxed()
                    .max(Comparator.comparingInt(i -> odd[i]))
                    .orElse(-1);
            return s.substring(oddIndex-oddMax/2,oddIndex+oddMax/2+1);
        }
    }

    /** 6. Zigzag Conversion*/
    @Override
   public String convert(String s, int numRows){
        if(numRows<2 || s==null || s.length()==1)
            return s;
        int N=s.length();
        int i=0,j=0;
        List<List<Character>> charList = new ArrayList<>();
        for (int k=0;k<numRows;charList.add(new ArrayList<>()),k++);
        boolean incDecr=true;
        while (i<N) {
            if(incDecr){
                charList.get(j++).add(s.charAt(i++));
                if(j==numRows)
                {
                    incDecr=!incDecr;
                    j-=2;
                }
           }
            else{
                charList.get(j--).add(s.charAt(i++));
                if(j==-1){
                    incDecr=!incDecr;
                    j+=2;
                }
            }
        }
        StringBuilder builder=new StringBuilder();
        for(List<Character> chars:charList){
            for(Character ch:chars)
                builder.append(ch);
        }
        return builder.toString();
    }

    /**8. String to Integer (atoi)*/
    @Override
    public int myAtoi(String s){

        int sign = 1, res = 0, idx = 0;
// Ignore leading whitespaces
        while (idx < s.length() && s.charAt(idx) == ' ') {
            idx++;
        }
// Store the sign of number
        if (idx < s.length() && (s.charAt(idx) == '-'
                || s.charAt(idx) == '+')) {
            if (s.charAt(idx++) == '-') {
                sign = -1;
            }
        }
// Construct the number digit by digit
        while (idx < s.length() && s.charAt(idx) >= '0'
                && s.charAt(idx) <= '9') {

            // Handling overflow/underflow test case
            if (res > Integer.MAX_VALUE / 10 ||
                    (res == Integer.MAX_VALUE / 10 && s.charAt(idx) - '0' > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Append current digit to the result
            res = 10 * res + (s.charAt(idx++) - '0');
        }
        return res * sign;
    }

}
