package com.design.analysis.ds.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DSUtils {

    public static List<String> permutation(String[] strs){
        Set<String> result = new HashSet<>();

        permutation(0,strs.length-1,strs,result);
        return new ArrayList<>(result);
    }
    public static void permutation(int l,int r,String[] words,Set<String> result)
    {
        if(l==r)
        {
            result.add(String.join("", words));
        }
        for(int i=l;i<=r;i++)
        {
            swap(l, i, words);
            permutation(l+1,r,words,result);
            swap(l, i, words);
        }
    }
    public static void swap(int l,int r, String[] words)
    {
        String temp = words[l];
        words[l]=words[r];
        words[r]=temp;
    }
}
