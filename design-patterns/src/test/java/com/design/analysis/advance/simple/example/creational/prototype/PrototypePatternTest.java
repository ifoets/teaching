package com.design.analysis.advance.simple.example.creational.prototype;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PrototypePatternTest {

    Employees emps;

    @Before
    public void init()
    {
        emps = new Employees();
    }

    @Test
    public void prototypeTest() throws  CloneNotSupportedException
    {
        emps.loadData();
        //Use the clone method to get the Employee object
        Employees empsNew = (Employees) emps.clone();
        Employees empsNew1 = (Employees) emps.clone();
        List<Address> list = empsNew.getEmpList();
        list.add(new Address().getAge(60).getName("John"));
        List<Address> list1 = empsNew1.getEmpList();
        list1.remove("Pankaj");

        System.out.println("emps List: "+emps.getEmpList());
        System.out.println("empsNew List: "+list);
        System.out.println("empsNew1 List: "+list1);
    }
}
