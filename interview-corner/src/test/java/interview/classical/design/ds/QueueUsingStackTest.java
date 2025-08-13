package interview.classical.design.ds;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueueUsingStackTest {

    QueueUsingStack<Integer> qus;

    @Before
    public void init()
    {
        qus = new QueueUsingStack<>();
    }

    @Test
    public void queueUsingStackTest()
    {
        qus.push(1);
        qus.push(2);
        qus.push(3);

        Assert.assertEquals(1,qus.peek().intValue());
        Assert.assertEquals(1,qus.pop().intValue());
        Assert.assertEquals(2,qus.pop().intValue());

        qus.push(4);
        qus.push(5);
        Assert.assertEquals(3,qus.peek().intValue());
        Assert.assertEquals(3,qus.pop().intValue());
        Assert.assertEquals(4,qus.pop().intValue());
        qus.print();
    }
}
