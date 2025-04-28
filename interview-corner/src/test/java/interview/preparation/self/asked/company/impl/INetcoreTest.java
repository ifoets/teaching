package interview.preparation.self.asked.company.impl;

import interview.preparation.company.interviews.impl.NetcoreImpl;
import interview.preparation.company.interviews.question.INetcore;
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
		Assert.assertTrue(inc.subArrayCount(a)==6);
	}

	@Test
	public void subArrayCountXTest()
	{
		int a[] = {1,2,3};
		Assert.assertTrue(inc.subArrayCountX(a)==6);
	}
	/* Count sub-arrays which have elements less than or equal to X */
	@Test
	public void subArrayLesEqualToXTest() {
		int a[] = {1,2,3,4,5};
		Assert.assertTrue(inc.subArrayLesEqualToX(a,1)==5);
		Assert.assertTrue(inc.subArrayLesEqualToX(a,2)==9);
		Assert.assertTrue(inc.subArrayLesEqualToX(a,5)==15);
	}
	// pattern 1+2+3+..n length pattern getting no of noncontinuous sab array multiply factorial/arrangement
	@Test
	public void subArrayCountNonContinuousTest()
	{
		int a[] = {1,2,3};
		Assert.assertTrue(inc.subArrayCountNonContinuous(a)==36);
	}
	/* Number of subarrays having even product */
	@Test
	public void countSubArrayEvenProd() {

	}

}
