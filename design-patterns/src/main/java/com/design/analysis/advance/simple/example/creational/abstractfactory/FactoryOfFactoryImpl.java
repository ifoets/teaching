package com.design.analysis.advance.simple.example.creational.abstractfactory;

import com.design.analysis.advance.simple.example.creational.factory.CarFactory;
import com.design.analysis.advance.simple.example.creational.factory.CarType;
import com.design.analysis.advance.simple.example.creational.factory.Location;

public class FactoryOfFactoryImpl extends FactoryBuilder {

    @Override
    CountryFactory getCountryFactory(String location) {
        return new CountryFactory();
    }

    @Override
    ModelFactory getCarType(String model) {
        return new ModelFactory();
    }

    public void createCar(String location, String model)
    {
         Location loc = getCountryFactory(location).getCountry(location);
         CarType carType = getCarType(model).getCarTye(model);
         switch (loc)
         {
             case INDIA :
                 IndiaCarFactory.buildCar(carType);
             break;
             case USA :
                 USACarFactory.buildCar(carType);
                 break;
             case DEFAULT:
                 DefaultCarFactory.buildCar(carType);
                 break;

         }
    }
}
