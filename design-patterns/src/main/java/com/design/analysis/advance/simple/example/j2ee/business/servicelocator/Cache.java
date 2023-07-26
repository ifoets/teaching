package com.design.analysis.advance.simple.example.j2ee.business.servicelocator;

import java.util.ArrayList;
import java.util.List;

public class Cache {

    public static List<MessagingService> list = new ArrayList<>();

    public MessagingService getService(String serviceName)
    {
        for(MessagingService service: list)
        {
            if(service.getServiceName().equalsIgnoreCase(serviceName))
                return  service;
        }
        return  null;
    }
    public void addService(MessagingService newService)
    {
        list.add(newService);
    }
}
