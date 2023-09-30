package interview.preparation.self.asked.company.model;

import java.util.List;

public class Employee {
    public String name;
    public List<Employee> list;

    public Employee(String name, List<Employee> list)
    {
        this.name = name;
        this.list = list;
    }
}
