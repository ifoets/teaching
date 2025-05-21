package interview.preparation.company.interviews;

import interview.preparation.company.interviews.impl.EPAMImpl;
import interview.preparation.company.interviews.question.IEPAM;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class IEPAMTest {

    IEPAM ie ;
    @Before
    public void inti()
    {
        ie = new EPAMImpl();
    }
    /*java 8 merge two sorted array in sorted*/
    @Test
    public void mergeTwoSortedArrayTest()
    {
        int arr1[] = { 1, 3, 4, 5};
        int arr2[] = {2, 4, 6, 8};
        List<Integer> rsL = List.of(1, 2, 3, 4, 4, 5, 6, 8);
        List<Integer> list = ie.mergeTwoSortedArray(arr1,arr2);
        Assert.assertTrue(list.containsAll(rsL));
        for (int i=0;i<rsL.size();i++)
            Assert.assertTrue(list.get(i)==rsL.get(i));
    }

    @Test
    public void countCharsInStrTest()
    {
        String text = "Ruchi is in technical discussion with Sagar and Gowthami";
        System.out.println(ie.countCharsInStr(text));
    }

    @Test
    public void removeDuplicateStrTest()
    {
        String text = "Ruchi is in technical discussion with Sagar and Gowthami";
        System.out.println(ie.removeDuplicateChar(text));
    }

}
