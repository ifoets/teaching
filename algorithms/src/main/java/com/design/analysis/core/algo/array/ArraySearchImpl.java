package com.design.analysis.core.algo.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.design.analysis.core.algo.utils.AlgoUtils;
import com.design.analysis.utils.ArraysUtil;

public class ArraySearchImpl implements IArraySearch {

    /** 1. Search, insert and delete in an unsorted array **/
    public boolean searchInsertDelUnsortedArr(int []a, int n, int x, String flage) {

        boolean isOperationFinished = false;
        switch (flage) {
            case "S":
                for (int i = 0; i < a.length; i++) {
                    if (a[i] == x) {
                        isOperationFinished = true;
                        break;
                    }
                }
                break;
            case "I":
                if (a.length > n) {
                    a[n] = x;
                    isOperationFinished = true;
                } else {
                    isOperationFinished = false;
                    System.out.println(" Unsorted Arrays size is less..not possible to insert");
                }

                break;
            case "D":
                int i;
                for (i = 0; i < a.length; i++)
                    if (a[i] == x) {
                        isOperationFinished = true;
                        break;
                    }
                for (int j = i; j + 1 < a.length; j++)
                    a[j] = a[j + 1];
                a[a.length - 1] = 0;

                break;
            default:
                break;

        }
        return isOperationFinished;
    }

    /** 2. Search, insert and delete in an sorted array **/
    public boolean searchInsertDelSortedArr(int []a, int n, int x, String flage) {
        boolean isOperationFinished = false;
        switch (flage) {
            case "S":
                int keyPos = AlgoUtils.binarySearch(a, 0, a.length - 1, x);
                if (keyPos != -1)
                    isOperationFinished = true;
                break;
            case "I":
                if (a.length > n) {
                    a[n] = x;
                    isOperationFinished = true;
                } else {
                    isOperationFinished = false;
                    System.out.println("Sorted Arrays size is less..not possible to insert");
                }

                break;
            case "D":

                int pos = AlgoUtils.binarySearch(a, 0, a.length - 1, x);
                if (pos != -1) {
                    isOperationFinished = true;
                    for (int j = pos; j + 1 < a.length; j++)
                        a[j] = a[j + 1];
                    a[a.length - 1] = 0;
                }

                break;
            default:
                break;

        }
        return isOperationFinished;
    }

    /**
     * 3. Given an array []a and a number x, check for pair in []a with sum as x
     **/
    public List<List<Integer>> pairOfSumX(int []a, int x) {
        List<List<Integer>> listOfList = null;

        if (a.length > 1) {
            listOfList = new ArrayList<>();
            List<Integer> list = null;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < a.length; i++) {
                if (map.containsKey(x - a[i])) {
                    list = new ArrayList<>();
                    list.add(a[i]);
                    list.add(x - a[i]);
                    listOfList.add(list);
                } else
                    map.put(a[i], x - a[i]);
            }
        }
        return listOfList;
    }

    /** 12.Leaders in an array **/
    public List<Integer> findLeader(int []a) {
        int maxFromRight = a[a.length - 1];// rightmost always leader
        List<Integer> resultList = new ArrayList<>();
        resultList.add(maxFromRight);
        for (int i = a.length - 2; i >= 0; i--) {
            if (maxFromRight < a[i]) {
                resultList.add(a[i]);
                maxFromRight = a[i];
            }
        }
        return resultList;
    }

    /** 14. Majority Element @assume one is majority **/
    public Integer majorityElement(int []a) {

        Map<Integer, Integer> map = null;
        if (a == null || a.length == 0)
            return null;
        else if (a.length == 1) {
            return a[0];
        } else {
            map = new HashMap<>();

            for (int i = 0; i <
                a.length; i++) {
                if (map.containsKey(a[i]))
                    map.put(a[i], map.get(a[i]) + 1);
                else
                    map.put(a[i], 1);
            }
            int min = 0;
            int key = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int val = entry.getValue();
                if (val > min) {
                    min = val;
                    key = entry.getKey();
                }
            }
            return key;
        }
    }
    /** 15.	Check for Majority Element in a sorted array,
     A majority element in an array arr of size N is an element that appears more than N/2 times in the array.**/
    //O(long(n))
    public boolean majorityElementSorted(int []a, int x){
        int n=a.length-1;
        int index = ArraysUtil.findFirstOccurenceInSorted(a,0,n, x);
        return (index + n) / 2 < n && a[index + n / 2] == x;
    }
    /**16.	Check if an array has a majority element
     * A majority element in an array is an element that appears strictly more than arr.size() / 2 times in the array**/
    public boolean checkMajorityElements(int []a){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i:a) {
            if(map.containsKey(i))
            {
                map.put(i,map.get(i)+1);
            }
            else map.put(i,1);
        }
        int maxCount=1;
        for(Map.Entry<Integer,Integer> set:map.entrySet())
        {
            if(set.getValue()>maxCount)
            {
                maxCount=set.getValue();
            }
        }
        return maxCount>=a.length/2;
    }
    /**17.	Two Pointers Technique, it get used for sorted array
     * typically used for Two Sum in Sorted Arrays, Closest Two Sum, Three Sum, Four Sum, Trapping Rain Water **/
    public List<Integer> pairSumTwoPointerTech(int []a, int sum){

        int i=0;
        int j=a.length-1;
        List<Integer> list = new ArrayList<>();
        while(i<j) {
              if(a[i]+a[j]==sum)
              {
                  list.add(a[i]);
                  list.add(a[j]);
                  break;
              }else if(a[i]+a[j]<sum)
                  i++;
              else j--;
        }
        return list;
    }
    /**18.	Find a peak element, greater than its left and right Log(n)**/
    public int peakElement(int []a){
        int n= a.length-1;
        if(a.length==1)
            return a[0];
        if(a[0]>a[1])
            return a[0];
        if(a[n]>a[n-1])
            return a[n];
        return ArraysUtil.findPeakInSorted(a, 1,n-2);

    }
}
