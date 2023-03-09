package interview.preparation.self.asked.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class INetcoreTest {

	INetcore inc;

	@Before
	public void init() {
		inc = new NetcoreImpl();
	}

	/* The total number of subarrays */
	@Test
	public void subArrayCountTest() {

		int a[] = {1,2,3};
		Assert.assertTrue(inc.subArrayCount(a)==15);
	}

	/* Count sub-arrays which have elements less than or equal to X */
	@Test
	public void subArrayLesEqualToXTest() {

	}

	/* Number of subarrays having even product */
	@Test
	public void countSubArrayEvenProd() {

	}

}
