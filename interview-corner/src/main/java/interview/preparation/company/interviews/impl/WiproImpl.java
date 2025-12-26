package interview.preparation.company.interviews.impl;

import interview.preparation.company.interviews.question.IWipro;
import lombok.ToString;

import java.util.Arrays;

public class WiproImpl implements IWipro {

    /**longest common prefix*/
    public String longestCommonPrefix(String[] stars){
        if(stars==null||stars.length==0)
            return "";
        int n = stars.length;
        if(n==1)return stars[0];
        Arrays.sort(stars);

        String firstStr= stars[0];
        String lastStr = stars[n-1];
        StringBuilder sb = new StringBuilder();
        int minLen = Math.min(firstStr.length(),lastStr.length());
        for(int i=0;i<minLen;i++)
        {
            if(firstStr.charAt(i)==lastStr.charAt(i))sb.append(firstStr.charAt(i));
            else break;
        }
        return sb.toString();
    }
    @Override
    public String longestCommonPostfix(String[] stars){
        if(stars==null||stars.length==0)
            return "";
        int n = stars.length;
        if(n==1)return stars[0];
        String[] newStars = Arrays.stream(stars).map(s->new StringBuilder(s).reverse().toString()).toArray(String[]::new);
        return new StringBuilder(longestCommonPrefix(newStars)).reverse().toString();
    }
    /**rotate an array by k from right side*/
    @Override
    public void rotateArray(int[] a, int k){
        for(int i=0;i<k;i++)
        {
            int temp = a[a.length-1];
            for(int j=a.length-1;j>0;j--)
                a[j]=a[j-1];
            a[0]=temp;
        }
    }
}
