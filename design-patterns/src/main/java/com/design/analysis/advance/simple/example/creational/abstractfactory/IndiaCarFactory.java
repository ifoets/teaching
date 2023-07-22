package com.design.analysis.advance.simple.example.creational.abstractfactory;

import com.design.analysis.advance.simple.example.creational.factory.*;

public class IndiaCarFactory {
    public static Car buildCar(CarType model)
    {
        Car car = null;
        switch (model)
        {
            case MICRO:
                car = new MicroCar(CarType.MICRO, Location.INDIA);
                break;

            case MINI:
                car = new MiniCar(CarType.MINI, Location.INDIA);
                break;

            case LUXURY:
                car = new LuxuryCar(CarType.LUXURY, Location.INDIA);
                break;

            default:
                break;

        }
        return car;
    }
}
