package com.design.analysis.utils;

import javax.swing.*;
import java.util.Arrays;

public class ArraysUtil {

    public static int getIndex(int a[], int val)
    {
        for(int i=0;i<a.length;i++)
        {
            if(a[i]==val) {
                return i;
            }
        }
        return -1;
    }
    public static int getMax(int a[])
    {
        int max=a[0];
        for(int i=1;i<a.length;i++)
        {
            if(a[i]>max)
                max=a[i];
        }
        return max;
    }

    public static int [] getIndexedVal(int a[])
    {
        int []b = new int[getMax(a)+1];
        for (int i=0 ; i<a.length; b[a[i++]]++);
            return b;
    }

    public static int findFirstOccurenceInSorted(int []a, int low, int high, int x){

        if(high>=low) {
            int mid = (low + high) / 2;
            if((mid==0||a[mid-1]<x) && a[mid]==x)
                return mid;
            else if(x>a[mid])
                return findFirstOccurenceInSorted(a,mid+1,high,x);
            else
            return findFirstOccurenceInSorted(a,low,mid-1,x);
        }
        return -1;
    }
    public static int findPeakInSorted(int []a, int low, int high){

        while(high>=low) {
            int mid = (low + high) / 2;
            if(a[mid]>a[mid-1] && a[mid]> a[mid+1])
                return mid;
            else if(a[mid+1]>a[mid])
                low=mid+1;
            else
               high=mid-1;
        }
        return -1;
    }
}
