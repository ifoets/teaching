package com.design.analysis.advance.simple.example.structural.adapter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExchangeAdapterPatternTest {
    ExchangeAdapterPattern adapterPattern;

    @Before
    public void init()
    {
        adapterPattern = new ExchangeAdapterPattern();
    }

    @Test
    public void test()
    {
        Assert.assertTrue(adapterPattern.internationalExchange(10,"USD")==800);
        Assert.assertTrue(adapterPattern.internationalExchange(10,"EUR")==950);
    }
}
