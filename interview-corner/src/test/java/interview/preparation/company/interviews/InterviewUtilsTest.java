package interview.preparation.company.interviews;

import interview.preparation.company.interviews.Utils.InterviewUtils;
import org.junit.Assert;
import org.junit.Test;

public class InterviewUtilsTest {

    @Test
    public void reverseTest()
    {
        int []a ={5,6,7,1,2,3,4};
        int []b = {1,2,3,4,5,6,7};

        InterviewUtils.reverse(a,0,2);
        InterviewUtils.reverse(a,3,6);
        InterviewUtils.reverse(a,0,6);
        for(int i=0;i<a.length;i++)
            Assert.assertEquals(b[i],a[i]);
    }

    @Test
    public void binarySearchTest()
    {
        int []a ={1,2,3,4,5,6,7,8,9};
        Assert.assertEquals(4,InterviewUtils.binarySearch(a,5,0,a.length));
        Assert.assertEquals(0,InterviewUtils.binarySearch(a,1,0,a.length));
        Assert.assertEquals(8,InterviewUtils.binarySearch(a,9,0,a.length));

    }
}
