package com.design.analysis.advance.simple.example.creational.factory;

public abstract class Car {

    CarType model;
    Location location;
    public Car(CarType model)
    {
        this.model = model;
    }
    public Car(CarType model, Location location)
    {
        this.location = location;
        this.model = model;
    }
    abstract void construct();
    CarType getModel()
    {
        return model;
    }

    void setModel(CarType model)
    {
        this.model = model;
    }

    Location getLocation()
    {
        return location;
    }

    void setLocation(Location location)
    {
        this.location = location;
    }

    @Override
    public String toString()
    {
        return "CarModel - "+model + " located in "+location;
    }
}
