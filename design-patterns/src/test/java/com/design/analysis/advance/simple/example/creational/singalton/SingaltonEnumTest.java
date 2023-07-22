package com.design.analysis.advance.simple.example.creational.singalton;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SingaltonEnumTest {

    SingaltonEnum instance;

    @Before
    public  void init()
    {
        instance = SingaltonEnum.INSTANCE;
    }
    @Test
    public void enumSingaltonTest()
    {
        Assert.assertTrue(SingaltonEnum.INSTANCE.equals(instance));
        String str ="kumar";
        instance.setValue(str);
        Assert.assertTrue(SingaltonEnum.INSTANCE.getValue().equals(instance.getValue()));
    }
}
