package com.design.analysis.advance.simple.example.j2ee.presentation.interceptingpattern;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {

    List<Filter> list = new ArrayList<>();
    Target target;
    public void addFilter(Filter filter)
    {
        list.add(filter);
    }
    public void setTarget(Target target)
    {
        this.target = target;
    }
    public void executeFilter(String request)
    {
        for(Filter filter:list)
            filter.execute(request);
        target.execute(request);
    }
}
