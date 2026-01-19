package interview.preparation.company.interviews.interview;

import interview.preparation.company.interviews.impl.WiproImpl;
import interview.preparation.company.interviews.question.IWipro;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class IWiproTest {

    IWipro iwp;

    @Before
    public void init()
    {
        iwp = new WiproImpl();
    }
    /**longest common prefix*/
    @Test
    public void longestCommonPrefixTest()
    {
        String[] stars1 ={"geeksforgeeks","geeks","geek","geezer"};
        String[] stars2 ={"flower", "flow", "flo-light"};
        Assert.assertEquals("gee",iwp.longestCommonPrefix(stars1));
        Assert.assertEquals("flo",iwp.longestCommonPrefix(stars2));
    }

    @Test
    public void longestCommonPostfixTest()
    {
        String[] stars2 ={"rewolf", "wolf", "thgil-olf"};
        Assert.assertEquals("olf",iwp.longestCommonPostfix(stars2));
    }

    /**rotate an array by k from right side*/
    @Test
    public void rotateArrayTest()
    {
        int[]a ={1,2,3,4,5,6,7};
        int[]b={5, 6, 7, 1, 2, 3, 4};
        iwp.rotateArray(a,3);
        System.out.println(Arrays.toString(a));
        Assert.assertArrayEquals(a,b);
    }
}
