package com.design.analysis.core.algo.utils;

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
}
