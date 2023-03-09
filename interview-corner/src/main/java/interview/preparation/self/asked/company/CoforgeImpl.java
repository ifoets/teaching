package interview.preparation.self.asked.company;

public class CoforgeImpl implements ICoforge {

	@Override
	public void useFunctionalInferface() {
		X a = () -> System.out.println("xyz");
		a.test();
	}

}
