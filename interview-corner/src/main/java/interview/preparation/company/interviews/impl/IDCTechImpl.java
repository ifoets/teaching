package interview.preparation.company.interviews.impl;

import interview.preparation.company.interviews.question.IIDCTech;

import java.util.*;
import java.util.stream.Stream;

public class IDCTechImpl implements IIDCTech {
    public int stringToInt(String str)
    {
        if(Objects.isNull(str))
            throw new NumberFormatException("Null");
        int no = 0;
        for(int i=0;i<str.length();i++)
        {   char ch = str.charAt(i);
            if(ch>='0' && ch<='9')
            {
                int n = ch-48;
                System.out.println(n);
                no = no*10+ n;// assci of '0' is 48
            }
            else throw  new NumberFormatException("Not Num");
        }
        return no;
    }


    /*first occurrence of an unique element*/
    @Override
    public int firstOccurrence(int a[], int x) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<a.length;i++)
        {
               if(map.containsKey(a[i]))
                   map.put(a[i],map.get(a[i])+1);
                else
                    map.put(a[i],1);
        }
        for (Map.Entry entry:map.entrySet())
        {
            if((int)entry.getValue()==x)
                return (int) entry.getKey();
        }
        return -1;
    }

    /*last occurrence of an unique element*/
    @Override

    public int lastOccurrence(int a[], int x){
        int val =-1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<a.length;i++)
        {
            if(map.containsKey(a[i]))
                map.put(a[i],map.get(a[i])+1);
            else
                map.put(a[i],1);
        }
        for (Map.Entry entry:map.entrySet())
        {
            if((int)entry.getValue()==x)
                val = (int) entry.getKey();
        }
        return val;
    }
    /*right rotate till pos an array*/
    @Override
    public void posRotateArray(int a[], int pos) {
          int N = a.length;
          for (int i=0;i<pos;i++)
          {
              int temp = a[N-1];
           for(int j=N-1;j>0;a[j]=a[j-1],j--);
            a[0]=temp;
          }
        }

    /*reverse string using java8 stream*/
    @Override
    public String reverseStrJava8(String str)
    {
        if(Objects.isNull(str)||str.length()==1)
            return str;
       // or Stream.of(str.split("")).reduce("",(a,b)->b+a);
        return str.chars().mapToObj( c-> (char)c).reduce("", (a,b) -> b+a, (s1,s2)-> s2+s1);
    }
}
