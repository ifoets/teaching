package com.leetcode.array;

import java.util.*;

public class LeetCodeArrayUtils {
    private LeetCodeArrayUtils(){};
    /*
    this method transform big repetitive array items to useful required arras items
    2,3,4 5..sum/target problems
     */
    public static int[] transformArray(int[] arr, int sumCount){
        int N= arr.length;
        Map<Integer,Integer> map = new TreeMap<>();
        //O(n) since only max 3/sumCount repetitive values get in to use for result
        for(int i=0;i<N;i++) {
            if(map.containsKey(arr[i])) {
                if(map.get(arr[i])<3){
                    map.put(arr[i],map.get(arr[i])+1);
                }
            }
            else map.put(arr[i],1);
        }
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> set:map.entrySet()) {
            int val = set.getValue();
            while (val-->0)
                list.add(set.getKey());
        }
        list=list.stream().sorted().toList();
        arr= new int[list.size()];
        for (int i=0;i<list.size();arr[i]=list.get(i),i++);
        return arr;
    }
    public static void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]=temp;
    }
    public static void reverse(int[] nums, int start, int end)
    {
        while (start<end)
            swap(nums,start++,end--);
    }
    public static void rightRotate(int[] nums, int i, int j)
    {
        int temp = nums[j];
        for(int k=j;k>i;nums[k]=nums[k-1],k--);
        nums[i]=temp;
    }
    public static void leftRotate(int[] nums, int i, int j){
        int temp = nums[i];
        for(int k=i;k<j;nums[k]=nums[k+1],k++);
        nums[j]=temp;
    }
    public static int pivotSortedRotatedArray(int[] nums, int l, int r){
        if(r-l==1 && nums[l]>nums[r])
            return r;
        int mid = (l+r)/2;
        while (l<r)
        {
            if(mid-1>=0&& nums[mid-1]>nums[mid])
                return mid;
            else if(nums[l]<nums[mid])
                return pivotSortedRotatedArray(nums,mid,r);
            else return pivotSortedRotatedArray(nums, l,mid);
        }
        return -1;
    }

    public static int binarySearch(int[] a, int l, int r, int x){

        while (l <= r) {
            int m = (l + r) / 2;
            if (a[m] == x) {
                return m;
            } else if (a[m] > x) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        // No Element Found
        return -1;
    }

    public static int binarySearchFirstIndex(int[] a, int l, int r, int x){

        while (l <= r) {
            int m = (l + r) / 2;
            if (m==0&&a[m] == x || m!=0 && a[m]==x && a[m-1]<a[m]) {
                return m;
            } else if (a[m] >= x) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        // No Element Found
        return -1;
    }

    public static int binarySearchLastIndex(int[] a, int l, int r, int x){

        while (l <= r) {
            int m = (l + r) / 2;
            if (m==a.length-1 && a[m] == x || a[m]==x && m != a.length-1 && a[m]<a[m+1]) {
                return m;
            } else if (a[m]<=x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        // No Element Found
        return -1;
    }

}
