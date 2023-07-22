package com.design.analysis.advance.simple.example.creational.abstractfactory;

import com.design.analysis.advance.simple.example.creational.factory.*;

public class DefaultCarFactory {
    public static Car buildCar(CarType model)
    {
        Car car = null;
        switch (model)
        {
            case MICRO:
                car = new MicroCar(CarType.MICRO, Location.DEFAULT);
                break;

            case MINI:
                car = new MiniCar(CarType.MINI, Location.DEFAULT);
                break;

            case LUXURY:
                car = new LuxuryCar(CarType.LUXURY, Location.DEFAULT);
                break;

            default:
                break;

        }
        return car;
    }
}
