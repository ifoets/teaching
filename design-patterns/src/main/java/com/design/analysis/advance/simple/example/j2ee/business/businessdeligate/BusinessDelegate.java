package com.design.analysis.advance.simple.example.j2ee.business.businessdeligate;

public class BusinessDelegate
{
    BusinessLookup lookup;

    public void setLookup(BusinessLookup lookup) {
        this.lookup = lookup;
    }
    public void playBackMove(String movie)
    {
        lookup.getBusinessService(movie).doProcessing();
    }
}
