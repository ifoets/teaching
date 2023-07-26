package com.design.analysis.advance.simple.example.j2ee.presentation.interceptingpattern;

public class FilterManager {
    public FilterChain filterChain;

    public FilterManager(Target target)
    {
        filterChain = new FilterChain();
        filterChain.setTarget(target);
    }
    public void setFilter(Filter filter)
    {
        filterChain.addFilter(filter);
    }
    public void filterRequest(String request)
    {
        filterChain.executeFilter(request);
    }

}
