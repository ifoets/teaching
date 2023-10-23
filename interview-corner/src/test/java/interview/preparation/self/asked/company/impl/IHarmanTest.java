package interview.preparation.self.asked.company.impl;

import interview.preparation.self.asked.company.question.IHarman;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IHarmanTest {

    IHarman ih;

    @Before
    public void init()
    {
        ih = new HarmanImpl();
    }

    @Test
    public void kthMaxMinTest()
    {
        int a[] ={1,2,2,3,4,9,6,9,2,6,5,4};//1,2,2,2,3,4,4,5,6,6,9
        Assert.assertTrue(ih.kthMaxMin(a,3,true)==5);
        Assert.assertTrue(ih.kthMaxMin(a,3,false)==3);
    }

    @Test
    public void kthMaxMinXTest()
    {
        int a[] ={1,2,2,3,4,9,6,9,2,6,5,4};//1,2,2,2,3,4,4,5,6,6,9
        Assert.assertTrue(ih.kthMaxMinX(a,3,true)==5);
        Assert.assertTrue(ih.kthMaxMinX(a,3,false)==3);
    }
}
