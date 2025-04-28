package interview.preparation.newjava.java8.model;

import lombok.Data;

@Data
public class Employee {
    String firstName;
    int age;

    public Employee(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }
}