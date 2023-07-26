package com.design.analysis.advance.simple.example.j2ee.presentation.frontcontroller;

import org.junit.Before;
import org.junit.Test;

public class FrontControllerPatternTest {
    FrontController frontController;

    @Before
    public void inti()
    {
        frontController = new FrontController();
    }
    @Test
    public void setFrontControllerTest()
    {
        frontController.dispatchRequest("HOME");
        frontController.dispatchRequest("STUDENT");
        frontController.dispatchRequest("DASHBOARD");
        frontController.dispatchRequest("ERROR");
    }
}
