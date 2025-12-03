package interview.preparation.company.interviews.design;

import interview.preparation.company.interviews.impl.TcsImpl;
import interview.preparation.company.interviews.question.ITcs;
import interview.preparation.rxjava.RxDataUtils;
import interview.preparation.rxjava.records.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ITcsTest {

    ITcs tcs;

    @Before
    public void init()
    {
        tcs = new TcsImpl();
    }

    @Test
    public void minAgeEmployeeInEachDepartmentTest()
    {
        List<Employee> list = RxDataUtils.getEmpList();
        System.out.println(tcs.minAgeEmployeeInEachDepartment(list));
    }

    @Test
    public void minAgeEmployeeInEachDepartmentXTest()
    {
        List<Employee> list = RxDataUtils.getEmpList();
        System.out.println(tcs.minAgeEmployeeInEachDepartmentX(list));
    }
}
