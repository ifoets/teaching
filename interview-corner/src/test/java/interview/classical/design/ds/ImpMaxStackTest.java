package interview.classical.design.ds;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ImpMaxStackTest {

    ImpMaxStack ims;

    @Before
    public void init()
    {
        ims = new ImpMaxStack();
    }

    @Test
    public void impMaxStackTest()
    {
        ims.push("aaa");
        ims.push("xxxxxx");
        ims.push("bb");
        ims.push("yyyy");

        Assert.assertEquals("xxxxxx", ims.getMaxLenItem());
        ims.push("abhimanyu");
        Assert.assertEquals("abhimanyu", ims.getMaxLenItem());
        Assert.assertEquals("abhimanyu", ims.pop());
        Assert.assertEquals("yyyy", ims.pop());

        Assert.assertEquals("xxxxxx", ims.getMaxLenItem());
        ims.print();
    }
}
