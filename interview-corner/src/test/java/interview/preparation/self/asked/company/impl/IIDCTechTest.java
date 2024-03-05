package interview.preparation.self.asked.company.impl;

import interview.preparation.self.asked.company.question.IIDCTech;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IIDCTechTest {

    IIDCTech iidcTech;
    @Before
    public void init() {
        iidcTech = new IDCTechImpl();
    }
    /*String to int without using java library*/
    @Test
    public void stringToIntTest() {
        Assert.assertTrue(iidcTech.stringToInt("12345")==12345);
    }

    /*first occurrence of an unique element*/
    @Test
    public void firstOccurrenceTest() {
       int a[] ={1,2,3,2,1,4,5,6,5,6};
       Assert.assertTrue(iidcTech.firstOccurrence(a, 1)==3);
       Assert.assertTrue(iidcTech.firstOccurrence(a, 2)==1);
    }

    /*last occurrence of an unique element*/
    @Test
    public void lastOccurrenceTest()
    {
        int a[] ={1,2,3,2,1,4,5,6,5,6};
        Assert.assertTrue(iidcTech.lastOccurrence(a, 1)==4);
        Assert.assertTrue(iidcTech.lastOccurrence(a, 2)==6);
    }

    /*right rotate till pos an array*/
    @Test
    public void posRotateArrayTest() {
        int a[] = {1,2,3,4,5};
        int pos = 2;
        int b[] = {4,5,1,2,3};
        iidcTech.posRotateArray(a,pos);
        for (int i =0 ;i<a.length;i++)
       Assert.assertTrue(a[i]==(b[i]));
    }

    /*reverse string using java8 stream*/
    @Test
    public void reverseStrJava8Test()
    {
        Assert.assertTrue(iidcTech.reverseStrJava8("abhimanyu").equals("uynamihba"));
        Assert.assertTrue(iidcTech.reverseStrJava8("").equals(""));
    }
}


