package interview.preparation.company.interviews.model;

import lombok.Data;

import java.util.List;
@Data
public class Employee {
    private String name;
    public int salary;

    private String department;
    public List<Employee> list;

    public Employee(String name, List<Employee> list)
    {
        this.name = name;
        this.list = list;
    }

    public Employee(String name, int salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Employee> getList() {
        return list;
    }

    public void setList(List<Employee> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Employee{" +
            "name='" + name + '\'' +
            ", salary=" + salary +
            ", department='" + department + '\'' +
            ", list=" + list +
            '}';
    }
}
