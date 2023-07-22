package com.design.analysis.advance.simple.example.creational.factory;

public class MicroCar  extends Car {

    public MicroCar(CarType model) {
        super(model);
        construct();
    }
    public MicroCar(CarType model, Location location)
    {
        super(model, location);
        construct();
        location(location);
    }
    @Override
    public void construct() {
        {
            System.out.println("Constructing a micro car");
        }
    }
    public void location(Location location)
    {
        System.out.println("at "+ location.name());
    }
}