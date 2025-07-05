package interview.preparation.company.interviews;

import interview.preparation.company.interviews.impl.TescoImpl;
import interview.preparation.company.interviews.question.ITesco;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ITescoTest {

    private ITesco it;

    @Before
    public void init()
    {
        it = new TescoImpl();
    }

    /**Get Max price to buy and shell stocks in different days*/
    @Test
    public void getMaxGainInStockTest()
    {
        int a[] ={7,1,5,3,6,4};
        Assert.assertEquals(5,it.getMaxGainInStock(a));
    }
}
