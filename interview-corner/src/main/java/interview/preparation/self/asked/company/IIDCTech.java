package interview.preparation.self.asked.company;

import java.util.Objects;

public interface IIDCTech {

    /*String to int without using java library*/
    public int stringToInt(String str);

    /*first occurrence of x count element*/
    public int firstOccurrence(int a[],  int x);

    /*last occurrence of x count element*/
    public int lastOccurrence(int a[], int x);

    /*right rotate till pos an array*/
    public void posRotateArray(int a[], int pos);

    /*reverse string using java8 stream*/
    public String reverseStrJava8(String str);
}
