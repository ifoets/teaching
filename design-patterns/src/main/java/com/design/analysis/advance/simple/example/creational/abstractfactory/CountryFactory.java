package com.design.analysis.advance.simple.example.creational.abstractfactory;

import com.design.analysis.advance.simple.example.creational.factory.*;

public class CountryFactory {

    public Location getCountry(String location)
    {
        Location loc = null;
        switch (location)
        {
            case "INDIA":
                loc = Location.INDIA;
                break;
            case "USA":
                loc = Location.USA;
                break;
            case "DEFAULT":
                loc = Location.DEFAULT;
                break;
            default:
                break;
        }
        return loc;
    }
}
