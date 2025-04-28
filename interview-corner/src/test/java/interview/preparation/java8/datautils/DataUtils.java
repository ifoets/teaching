package interview.preparation.java8.datautils;

import interview.preparation.newjava.java8.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class DataUtils {

    public static List<Employee> getEmployees()
    {
        List<Employee> employees = new ArrayList<>();
        Employee e1 = new Employee("Ajay",35);
        Employee e2 = new Employee("Vijay",5);
        Employee e3 = new Employee("Zack",30);
        Employee e4 = new Employee("David",51);
        Employee e5 = new Employee("Ajay",10);
        Employee e6 = new Employee("Zack",40);
        employees.addAll(List.of(e1,e2,e3,e4,e5,e6));
        return  employees;
    }

    public static List<Integer> getEvens()
    {
        return List.of(2,4,6,8,10);
    }
    public static List<Integer> getOdds()
    {
        return List.of(1,3,5,9,11);
    }

    public static List<Integer> getPrimes()
    {
        return List.of(2,3,5,7,11,13,17,19,23,29);
    }
}
