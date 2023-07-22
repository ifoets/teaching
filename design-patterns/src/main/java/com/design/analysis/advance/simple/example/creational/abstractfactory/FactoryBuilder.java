package com.design.analysis.advance.simple.example.creational.abstractfactory;

import com.design.analysis.advance.simple.example.creational.factory.Location;

public abstract class FactoryBuilder {

    abstract CountryFactory getCountryFactory(String location);
    abstract ModelFactory getCarType(String model);
    public abstract void createCar(String location, String model);
}
