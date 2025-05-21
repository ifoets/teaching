package interview.preparation.company.interviews;

import interview.preparation.company.interviews.impl.PayPalImpl;
import interview.preparation.company.interviews.question.IPayPal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class IPayPalTest {

    private IPayPal payPal;
    @Before
    public void init()
    {
        payPal = new PayPalImpl();
    }

    /**print all the subsequence of the string in sorted order*/
    @Test
    public void generateAllBinaryTest()
    {
        int[] a={0,0,0};
        List<String> rsList = payPal.generateAllBinary(a,0);
        Assert.assertEquals(8,rsList.size());
        rsList.forEach(System.out::println);
    }
    @Test
    public void sortedSubsequenceTest()
    {
        payPal.sortedSubsequence("ABCDE").forEach(System.out::println);
        List<String> rsList = payPal.sortedSubsequence("ABCDE");
        Assert.assertEquals("A",rsList.get(2));
        rsList.forEach(System.out::println);
    }

    @Test
    public void sortedSubsequenceXTest()
    {
        String str="XYX";
        List<String> rsList = payPal.sortedSubsequenceX(str, str.toCharArray(),0);
        Assert.assertEquals(8,rsList.size());
        rsList.forEach(System.out::println);
    }
}
