package interview.preparation.self.asked.company.impl;

import interview.preparation.self.asked.company.question.IAltimetrik;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class IAltimetrikTest {

	public IAltimetrik ial;
	
	@Before
	public void init()
	{
		ial = new AltimetrikImpl();
	}
	@Test
	public void checkDuplicateCountValTest()
	{
        int a[] = {4,6, 6,7,7,7,9,9,9,9};
		Assert.assertTrue(ial.checkDuplicateCountVal(a));
		int b[] ={1, 2,3,1};
		Assert.assertTrue(!ial.checkDuplicateCountVal(b));
	}

	@Test
	public  void get2ndMaxNoTest() {
		List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2, 2, 2, 3),
				Arrays.asList(4, 4, 4, 5, 5, 6),
				Arrays.asList(6, 6, 7, 7, 7, 8, 8, 8));
		Assert.assertTrue(ial.get2ndMaxNo(lists)==7);
	}
}
