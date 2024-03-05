package interview.preparation.self.asked.company.impl;

import interview.preparation.self.asked.company.question.IWallmart;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IWallmartTest {

    IWallmart iw = null;

    @Before
    public void init()
    {
        iw = new WallmartImpl();
    }
    /*remove continuous duplicate character from words in String*/
    @Test
    public void removeContinuousCharTest()
    {
        Assert.assertTrue(iw.removeContinuousChar("Thiss iiss aa teesstt").equals("This is a test"));
        Assert.assertTrue(iw.removeContinuousChar("aaa").equals("a"));
        Assert.assertTrue(iw.removeContinuousChar("hello!").equals("helo!"));
    }

    /*wrote a function that check weather an array is sub array of another array, return true or false*/
    @Test
    public void checkArrayIsSubArrayTest()
    {
        int a[] = {1,2,3,4};
        int b[] = {1};
        Assert.assertTrue(iw.checkArrayIsSubArray(a,b));
        int[] c={};
        Assert.assertTrue(iw.checkArrayIsSubArray(a,c));
        int d[]={7};
        Assert.assertFalse(iw.checkArrayIsSubArray(a,d));
        int e[]={2,2,3,4};
        int f[]={2,2};
        Assert.assertTrue(iw.checkArrayIsSubArray(e,f));
    }

    /*print vertical dumbbells from "*" */
    @Test
    public void printDumbbellTest()
    {
        iw.printDumbbell(5);
    }
}
