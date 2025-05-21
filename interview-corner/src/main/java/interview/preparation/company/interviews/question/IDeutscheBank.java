package interview.preparation.company.interviews.question;

import interview.preparation.company.interviews.model.Employee;

import java.util.List;

public interface IDeutscheBank {

    /*producer  problems*/
    public void producerConsumer();

    /*diamond problems*/
    public void diamondProblem();

    /*collect list of employee under senior manager in tree structure org*/
    public List<String> getEmpListOfManager(List<Employee> list, String mgrName);
}
