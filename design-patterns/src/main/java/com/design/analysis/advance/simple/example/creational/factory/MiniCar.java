package com.design.analysis.advance.simple.example.creational.factory;

public class MiniCar extends Car {

    public MiniCar(CarType model)
    {
        super(model);
        construct();
    }
    public MiniCar(CarType model, Location location)
    {
        super(model, location);
        construct();
        location(location);
    }
    @Override
    public void construct()
    {
        System.out.println("Constructing a mini car");
    }
    public void location(Location location)
    {
        System.out.println("at "+ location.name());
    }
}
