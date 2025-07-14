package interview.preparation.company.interviews;

import interview.preparation.company.interviews.model.Student;

import java.util.List;

public class DataUtils {

    public static List<Student> getStudentList()
    {
        return List.of(
            new Student("Alice", 20),
            new Student("Bob", 22),
            new Student("Alice", 25),
            new Student("Bob", 28),
            new Student("Charlie", 19)
        );
    }
}
