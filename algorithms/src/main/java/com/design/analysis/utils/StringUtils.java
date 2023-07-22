package com.design.analysis.utils;

public class StringUtils {

    public  static final int ALPHABET_LENGTH = 26;
    public static int[] getIndexArr(String str)
    {
        char chars[] = str.replace(" ","").trim().toLowerCase().toCharArray();
        int a[] = new int[ALPHABET_LENGTH];
        for (int i = 0; i < str.length(); a[chars[i] - 97]++, i++)
            ;
        return a;
    }
}
