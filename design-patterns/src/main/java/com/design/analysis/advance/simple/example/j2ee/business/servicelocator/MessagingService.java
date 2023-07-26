package com.design.analysis.advance.simple.example.j2ee.business.servicelocator;

public interface MessagingService {
    String getMessageBody();
    String getServiceName();
}

class SMSService implements MessagingService
{

    @Override
    public String getMessageBody() {
        return "SMS message";
    }

    @Override
    public String getServiceName() {
        return "SMSService";
    }
}
class EmailService implements MessagingService
{
    @Override
    public String getMessageBody() {
        return "Email message";
    }

    @Override
    public String getServiceName() {
        return "EmailService";
    }
}
