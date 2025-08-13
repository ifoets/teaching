package interview.classical.design.ds;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackUsingQueueTest {

    StackUsingQueue<Integer> suq;

    @Before
    public void init()
    {
        suq = new StackUsingQueue<>();
    }

    @Test
    public void stackUSingQueueTest()
    {
        RuntimeException exception = Assert.assertThrows(RuntimeException.class, () -> {
           suq.pop();
        });
        Assert.assertEquals("Stack is Empty", exception.getMessage());

        suq.push(1);
        suq.push(2);
        suq.push(3);
        Assert.assertEquals(3,suq.pop().intValue());
        Assert.assertEquals(2,suq.pop().intValue());

        suq.push(4);
        suq.push(5);

        Assert.assertEquals(5,suq.pop().intValue());
        Assert.assertEquals(4,suq.pop().intValue());

        Assert.assertEquals(1,suq.peek().intValue());
        suq.push(4);
        suq.push(5);
        Assert.assertEquals(5,suq.peek().intValue());
        Assert.assertEquals(3,suq.size());
        suq.print();
    }

}
