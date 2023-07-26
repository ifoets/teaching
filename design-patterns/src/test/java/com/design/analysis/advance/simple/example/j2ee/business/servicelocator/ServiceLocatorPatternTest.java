package com.design.analysis.advance.simple.example.j2ee.business.servicelocator;

import org.junit.Before;
import org.junit.Test;

public class ServiceLocatorPatternTest {

    private ServiceLocator locator;

    @Before
    public void init()
    {
        locator = new ServiceLocator();
    }

    @Test
    public void serviceLocatorTest()
    {
        MessagingService service
                = ServiceLocator.getService("EmailService");
        System.out.println(service.getMessageBody());

        MessagingService smsService
                = ServiceLocator.getService("SMSService");
        System.out.println(smsService.getMessageBody());

    }
}
