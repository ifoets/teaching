package com.design.analysis.advance.simple.example.creational.abstractfactory;

import com.design.analysis.advance.simple.example.creational.factory.*;

public class USACarFactory {
    public static Car buildCar(CarType model)
    {
        Car car = null;
        switch (model)
        {
            case MICRO:
                car = new MicroCar(CarType.MICRO, Location.USA);
                break;

            case MINI:
                car = new MiniCar(CarType.MINI, Location.USA);
                break;

            case LUXURY:
                car = new LuxuryCar(CarType.LUXURY, Location.USA);
                break;

            default:
                break;

        }
        return car;
    }
}
