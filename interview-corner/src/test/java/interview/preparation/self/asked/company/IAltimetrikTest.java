package interview.preparation.self.asked.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
}
