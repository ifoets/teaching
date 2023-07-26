package com.design.analysis.advance.simple.example.j2ee.business.servicelocator;

import java.util.Objects;

public class InitialContext {

    public MessagingService lookup(String serviceName)
    {
        if(serviceName.equalsIgnoreCase("EmailService"))
            return new EmailService();
        else if(serviceName.equalsIgnoreCase("SMSService"))
            return new SMSService();
        return  null;
    }
}
