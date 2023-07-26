package com.design.analysis.advance.simple.example.behavioral.chainofresponsibility;

import org.junit.Before;
import org.junit.Test;

public class ChainOfResponsibilityTest {

    ChainOfResponsibility chain;

    @Before
    public void init()
    {
        chain = new ChainOfResponsibility();
    }

    @Test
    public void chainOfResponsibilityTest()
    {
        int a[] = {1,2,3};
        Logger log = chain.doChanning(a);
        log.logMessage(1,"Console info");
        log.logMessage(2,"Error info");
        log.logMessage(3, "Debug info");
    }
}
