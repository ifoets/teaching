package com.design.analysis.algo;

public class AlgoUtils {

    public static void swap(int[]a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j]=temp;
    }
}
