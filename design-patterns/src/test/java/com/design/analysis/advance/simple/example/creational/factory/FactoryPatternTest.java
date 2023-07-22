package com.design.analysis.advance.simple.example.creational.factory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FactoryPatternTest {

    CarFactory factory;

    @Before
    public void init()
    {
        factory = new CarFactory();
    }

    @Test
    public void factoryPatternTest()
    {
        factory.getCar( CarType.MINI);
        factory.getCar( CarType.MICRO);
        factory.getCar( CarType.LUXURY);
    }
}
