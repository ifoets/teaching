package com.design.analysis.advance.simple.example.creational.factory;

import com.design.analysis.advance.simple.example.creational.abstractfactory.FactoryBuilder;
import com.design.analysis.advance.simple.example.creational.abstractfactory.FactoryOfFactoryImpl;
import org.junit.Before;
import org.junit.Test;

public class AbstractFactoryTest {
    FactoryBuilder factoryBuilder;

    @Before
    public  void init()
    {
        factoryBuilder = new FactoryOfFactoryImpl();
    }

    @Test
    public void abstractFactoryTest()
    {
        factoryBuilder.createCar("INDIA","MINI");
        factoryBuilder.createCar("USA","LUXURY");
        factoryBuilder.createCar("DEFAULT","MICRO");
    }
}
