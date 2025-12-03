package com.design.analysis.algo.manipulation;

public class BitUtils {

    public static String intToBinary(int n){
        StringBuilder sb = new StringBuilder();
        while (n>0)
        {
            sb.append(n%2);
            n=n/2;
        }
        return sb.reverse().toString();
    }
    public static int binaryToInt(String str){
        int sum=0;
        int i=str.length()-1;
        int j=0;
        while(i>=0)
        {
            sum+= Integer.parseInt(str.charAt(i)+"")*(int)Math.pow(2,j);
            i--;
            j++;
        }
        return sum;
    }
}
