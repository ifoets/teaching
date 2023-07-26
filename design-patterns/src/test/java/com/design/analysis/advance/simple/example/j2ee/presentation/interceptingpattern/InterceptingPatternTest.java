package com.design.analysis.advance.simple.example.j2ee.presentation.interceptingpattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InterceptingPatternTest {

    FilterManager filterManager;
    @Before
    public void init()
    {
        filterManager = new FilterManager(new Target());
    }
    @Test
    public void interceptingPatternTest()
    {
        filterManager.setFilter(new AuthenticationFilter());
        filterManager.setFilter(new DebugFilter());

        Client client = new Client();
        client.setFilterManager(filterManager);
        client.sendRequest("Downloads");
    }
}
