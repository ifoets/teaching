package com.design.analysis.advance.simple.example.creational.prototype;

public class Address {
    public String name;
    public int age;

    public Address getAge(int age)
    {
        this.age=age;
        return this;
    }
    public Address getName(String name)
    {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
