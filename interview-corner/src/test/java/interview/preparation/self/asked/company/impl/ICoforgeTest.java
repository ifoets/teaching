package interview.preparation.self.asked.company.impl;

import interview.preparation.self.asked.company.question.ICoforge;
import org.junit.Before;
import org.junit.Test;

public class ICoforgeTest {

	private ICoforge ifg = null;

	@Before
	public void init() {
		ifg = new CoforgeImpl();
	}

	@Test
	public void useFunctionalInferfaceTest() {
		ifg.useFunctionalInferface();
	}

}
