package com.design.analysis.advance.simple.example.creational.abstractfactory;

import com.design.analysis.advance.simple.example.creational.factory.*;

public class ModelFactory {

    public CarType getCarTye(String car)
    {
        CarType carType = null;
        switch (car)
        {
            case "MICRO" :
                carType = CarType.MICRO;
                break;
            case "MINI":
                carType = CarType.MINI;
                break;
            case "LUXURY":
                carType = CarType.LUXURY;
                break;
            default:
                break;
        }
        return carType;
    }
}
