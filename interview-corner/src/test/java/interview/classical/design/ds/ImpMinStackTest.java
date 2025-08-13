package interview.classical.design.ds;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ImpMinStackTest {

    ImpMinStack ims;

    @Before
    public void init()
    {
        ims = new ImpMinStack();
    }

    @Test
    public void impMinStackTest()
    {
        ims.push(3);
        ims.push(6);
        ims.push(2);
        ims.push(4);

        Assert.assertEquals(2,ims.getMinStack());
        Assert.assertEquals(4,ims.pop());
        Assert.assertEquals(2,ims.pop());

        Assert.assertEquals(3,ims.getMinStack());
        ims.print();
    }
}
