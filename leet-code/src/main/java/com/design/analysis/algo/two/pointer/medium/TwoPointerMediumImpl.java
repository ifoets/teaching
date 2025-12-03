package com.design.analysis.algo.two.pointer.medium;

import java.util.*;

public class TwoPointerMediumImpl implements ITwoPointerMedium{

    /**5. Longest Palindromic Substring*/
    @Override
    public String longestPalindrome(String s){

        if(s==null ||s.isEmpty())
            return "";
        int maxLen=0;
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s,i,i+1);

            maxLen = Math.max(len1,len2);
            if(maxLen>(end-start))
            {
                start=i-(maxLen-1)/2;
                end = i+maxLen/2;
            }
        }
        return s.substring(start,end+1);

    }

    @Override
    public int expandAroundCenter(String s, int l, int r)
    {
        while (l>=0 && r<s.length() && s.charAt(l)==s.charAt(r))
        {
            l--;
            r++;
        }
        return (r-l)-1;
    }

    /**11. Container With Most Water*/
    @Override
    public int maxArea(int[] h){

        int i=0,j=h.length-1;
        int maxArea = 0;
        while (i<j)
        {
            int currentMax = Math.min(h[i],h[j])*(j-i);
            if(currentMax>maxArea)
                maxArea = currentMax;

            if(h[i]<h[j])i++;
            else j--;
        }
        return maxArea;
    }

    /**15. 3Sum*/
    @Override
    public List<List<Integer>> threeSum(int[] nums){

        List<List<Integer>> rsList = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            if(i>0 && nums[i]==nums[i-1])continue;

            int l = i+1;
            int r=nums.length-1;
            //catch first iTh element and check two from i+1 to till length-1
            while (l<r)
            {
                int sum = nums[i]+nums[l]+nums[r];
                if(sum==0)
                {
                    rsList.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while (l<r && nums[l]==nums[l+1])l++;
                    while (l<r && nums[r]==nums[r-1])r--;
                    l++;
                    r--;
                }
                else if(sum<0) l++;
                else r--;
            }
        }
        return rsList;
    }
}
