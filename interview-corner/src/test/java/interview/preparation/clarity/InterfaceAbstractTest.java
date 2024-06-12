package interview.preparation.clarity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class InterfaceAbstractTest {
    InterfaceAbstract ib = null;
    @Before
    public void init()
    {
        ib = new InterfaceAbstract();
    }
    @Test
    public  void intrfAbstrTest()
    {
        A a = ib.getA();
        a.m1();
        Assert.assertTrue(a instanceof Abs);
        Assert.assertTrue(a instanceof Intrf1);
        Assert.assertTrue(a instanceof Intrf2);
    }

    public static void main(String[] args) {

        AtomicInteger counter = new AtomicInteger(10);
    }
}
