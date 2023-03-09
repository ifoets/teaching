package interview.preparation.self.asked.company;

public interface ICoforge {

	public void useFunctionalInferface();

}

interface X {
	void test();

	default void sum() {
		System.out.println("sum");
	}
}
