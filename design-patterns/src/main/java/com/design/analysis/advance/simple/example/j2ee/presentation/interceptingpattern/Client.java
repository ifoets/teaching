package com.design.analysis.advance.simple.example.j2ee.presentation.interceptingpattern;

public class Client
{
    FilterManager filterManager;

    public void setFilterManager(FilterManager filterManager)
    {
        this.filterManager = filterManager;

    }
    public void sendRequest(String request)
    {
        filterManager.filterRequest(request);
    }
}
