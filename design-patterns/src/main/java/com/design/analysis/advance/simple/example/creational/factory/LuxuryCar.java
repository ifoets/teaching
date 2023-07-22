package com.design.analysis.advance.simple.example.creational.factory;

public class LuxuryCar extends  Car{
    public LuxuryCar(CarType model) {
        super(model);
        construct();
    }
    public LuxuryCar(CarType model, Location location)
    {
        super(model, location);
        construct();
        location(location);
    }
    @Override
    public void construct() {
        {
            System.out.println("Constructing a luxury car");
        }
    }
    public void location(Location location)
    {
        System.out.println("at "+ location.name());
    }
}
