package interview.preparation.company.interviews.impl;

import interview.preparation.company.interviews.question.ITcs;
import interview.preparation.rxjava.records.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class TcsImpl implements ITcs {
    @Override
    public Map<String, Map<String, Integer>> minAgeEmployeeInEachDepartment(List<Employee> list) {
        return
            list.stream()
                .collect(
                    Collectors.groupingBy(
                        Employee::department,
                        Collectors.collectingAndThen(
                            Collectors.minBy(Comparator.comparingInt(Employee::age)),
                            empOpt->
                                empOpt.map(emp-> Map.of(emp.name(),emp.age())).orElse(Map.of())
                        )
                    )
                );
    }

    @Override
    public Map<String, Optional<Employee>> minAgeEmployeeInEachDepartmentX(List<Employee> list){

        return
            list.stream()
                .collect(
                    Collectors.groupingBy(
                        Employee::department,
                        Collectors.reducing(
                            BinaryOperator.minBy(Comparator.comparingInt(Employee::age))
                        )
                    )
                );
    }
}
