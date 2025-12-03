package com.design.analysis.algo.array.easy;

import java.util.*;

public class ArrayEasyImpl implements IArrayEasy{

    /** 1. Two Sum*/
    public int[] twoSum(int[] nums, int target){

        Map<Integer, Integer> map = new HashMap<>();  // value → index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);  // Store value and index
        }

        return new int[] {};  // No solution found
    }

    @Override
    public int[] twoSumX(int[] nums, int target){
        int N=nums.length;
         if(N<2)
             return new int[0];
        Map<Integer, List<Integer>> map=new HashMap<>();
        //O(n)
        for(int i=0;i<N;i++){
            List<Integer> l;
            if(map.containsKey(nums[i]))
                l = map.get(nums[i]);
              else
                l = new ArrayList<>();
            l.add(i);
            map.put(nums[i],l);
        }

        int[] rs = new int[2];
        int i=0;
        int j=N-1;
        int ans=nums[0]+nums[1];
        if(ans==target)
        {
            rs[1]=1;
            return rs;
        }
        else {
            Arrays.sort(nums);
            //O(n)
            while (i < j) {
                int sum=nums[i]+nums[j];
                if(sum==target)
                {
                    rs[0] = map.get(nums[i]).get(0);
                    if(nums[i]==nums[j]){
                        rs[1] = map.get(nums[i]).get(1);
                    }
                    else {
                        rs[1] = map.get(nums[j]).get(0);
                    }
                    return rs;
                }
                else if(sum>target)
                    j--;
                else i++;
            }
        }
        return rs;
    }

    /**26. Remove Duplicates from Sorted Array*/
    @Override
    public int removeDuplicates(int[] nums){
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    /**27. Remove Element*/
    @Override
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
    /**412. Fizz Buzz*/
    @Override
    public List<String> fizzBuzz(int n){

        List<String> list = new ArrayList<>();

        for(int i=1;i<=n;i++)
        {
            if(i%3==0 && i%5 ==0)
                list.add("FizzBuzz");
            else if(i%3==0)
                list.add("Fizz");
            else if(i%5==0)
                list.add("Buzz");
            else
                list.add(i+"");
        }

        return list;
    }

    /**35. Search Insert Position, Given a sorted array of distinct integers and a target value, return the index if the target is found.
     If not, return the index where it would be if it were inserted in order*/
    @Override
    public int searchInsert(int[] nums, int target){
        return binarySearchInsert(nums,0,nums.length-1, target);
    }
    int binarySearchInsert(int[] nums, int l, int r, int target){
        while(l<=r)
        {
            if(nums[l]>target)
                return l;
            if(nums[r]<target)
                return r+1;
            int m=(l+r)/2;
            if(nums[m]==target)
                return m;
            else if(nums[m]<target)
                l = m+1;
            else
                r = m-1;

        }
        return -1;
    }
}
