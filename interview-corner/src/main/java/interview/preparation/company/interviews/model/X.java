package interview.preparation.company.interviews.model;

public interface X {
    void test();

    default void sum() {
        System.out.println("sum");
    }
}