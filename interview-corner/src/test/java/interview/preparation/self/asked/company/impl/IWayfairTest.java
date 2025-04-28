package interview.preparation.self.asked.company.impl;

import interview.preparation.company.interviews.impl.WayfairImpl;
import interview.preparation.company.interviews.question.IWayfair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class IWayfairTest {

    IWayfair iw;

    @Before
    public void init()
    {
        iw = new WayfairImpl();
    }
    /* find the indexes of the values of sum */
    @Test
    public void getIndexesOfValueSumTest()
    {
        int a[] = {2,7,11,15};
        int sum = 9;
        List<Integer> rs = iw.getIndexesOfValueSum(a,sum);
        Assert.assertTrue(rs.get(0)==0 && rs.get(1)==1);
    }
}
