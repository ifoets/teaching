package com.design.analysis.advance.simple.example.j2ee.business.servicelocator;

import java.util.Objects;

public class ServiceLocator {
    private static Cache cache = new Cache();

    public static MessagingService getService(String serviceName)
    {
        MessagingService service = cache.getService(serviceName);
        if(!Objects.isNull(service))
            return  service;
        InitialContext context = new InitialContext();
        MessagingService messagingService = context.lookup(serviceName);
        cache.addService(messagingService);
        return  messagingService;
    }
}
