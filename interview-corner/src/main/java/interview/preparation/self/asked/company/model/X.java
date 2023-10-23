package interview.preparation.self.asked.company.model;

public interface X {
    void test();

    default void sum() {
        System.out.println("sum");
    }
}