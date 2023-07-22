package com.design.analysis.advance.simple.example.creational.factory;

public class CarFactory {

    CarType carType;

    public Car getCar(CarType carType)
    {
        Car car = null;
        switch (carType)
        {
            case MICRO :
                car = new MicroCar(CarType.MICRO);
            break;
            case MINI:
                car = new MiniCar(CarType.MINI);
                break;
            case LUXURY:
                car = new LuxuryCar(CarType.LUXURY);
                break;
            default:
                break;
        }
        return car;
    }
}
