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
        int b[] = new int[getMax(a)+1];
        for (int i=0 ; i<a.length; b[a[i++]]++);
            return b;
    }
}
