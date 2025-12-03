package interview.preparation.company.interviews.question;

import interview.preparation.rxjava.records.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ITcs {

    /** Find min age employee in each department and print department name and employee name */
    Map<String, Map<String,Integer>> minAgeEmployeeInEachDepartment(List<Employee> list);

    Map<String, Optional<Employee>> minAgeEmployeeInEachDepartmentX(List<Employee> list);
}
