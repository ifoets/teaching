package com.design.analysis.advance.simple.example.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable{
    private List<Address> empList;

    public Employees(){
        empList = new ArrayList<>();
    }

    public Employees(List<Address> list){
        this.empList=list;
    }
    public void loadData(){
        //read all employees from database and put into the list
        empList.add(new Address().getAge(20).getName("Pankaj"));
        empList.add(new Address().getAge(30).getName("Raj"));
        empList.add(new Address().getAge(40).getName("David"));
        empList.add(new Address().getAge(50).getName("Lisa"));
    }

    public List<Address> getEmpList() {
        return empList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        List<Address> temp = new ArrayList<>();
        for(Address s : this.getEmpList()){
            temp.add(s);
        }
        return new Employees(temp);
    }
}