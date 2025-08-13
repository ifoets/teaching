package interview.preparation.company.interviews.impl;

import interview.preparation.company.interviews.question.IPayPal;

import java.util.*;

public class PayPalImpl implements IPayPal {


    List<String> binaryList = new ArrayList<>();
    /**print all the subsequence of the string in sorted order*/
    public List<String> generateAllBinary(int []a, int index){

        if(a.length==index)
        {
            int i=0;
            StringBuilder sb = new StringBuilder();
            while (i<a.length)
                sb.append(a[i++]);
            binaryList.add(sb.toString());
            return binaryList;
        }
        a[index]=0;
        generateAllBinary(a,index+1);

        //flip first
        a[index]=1;
        generateAllBinary(a,index+1);
        return binaryList;
    }
    public List<String> sortedSubsequence(String s){
        int []a = new int[s.length()];
        List<String> binaryFlip = generateAllBinary(a,0);
        List<String> rsList = new ArrayList<>();

        for (String string : binaryFlip) {
            StringBuilder sb = new StringBuilder();
            String[] str = string.split("");
            for (int j = 0; j < str.length; j++) {
                if (str[j].equals("1"))
                    sb.append(s.charAt(j));
            }
            rsList.add(sb.toString());
        }
       Collections.sort(rsList);
        return rsList;
    }

    List<String> seqList = new ArrayList<>();
    public List<String> sortedSubsequenceX(String str, char[] s, int index){

        if(index==s.length)
        {
            StringBuilder sb = new StringBuilder();
            for(char c:s) {
                if(c!=' ') {
                    sb.append(c);
                }
            }
            seqList.add(sb.toString().trim());
            return seqList;
        }
        //flip
        s[index]=' ';
        sortedSubsequenceX(str, s,index+1);
        //put value  ie unflip
        s[index]=str.charAt(index);
        sortedSubsequenceX(str, s,index+1);
        Collections.sort(seqList);
        return seqList;
    }

    /*Container With Most Water*/
    @Override
    public int containerMaxWater(int[] c){

        int max = Integer.MIN_VALUE;
        int currentMax,i=0,j=c.length-1;

       while (i<j)
        {
            currentMax = Math.min(c[i],c[j])*(j-i);
            if(max<currentMax)
                max = currentMax;
            if(c[i]<c[j])
                i++;
            else j--;
        }
       return max;
    }
}
