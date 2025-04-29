package interview.preparation.company.interviews;

import interview.preparation.company.interviews.impl.AltimetrikImpl;
import interview.preparation.company.interviews.question.IAltimetrik;
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
    public void minimumCandiesPerHourTest()
    {
        int a[] = {1, 0, 2};
        Assert.assertEquals(5,ial.minimumCandiesPerHour(a));
        int b[]={1,2,2};
        Assert.assertEquals(4,ial.minimumCandiesPerHour(b));
        int c[]={8,3,2,1,4,5,2,3,4};
        System.out.println(ial.minimumCandiesPerHour(c));
        Assert.assertEquals(21,ial.minimumCandiesPerHour(c));
        int d[]={4, 9, 11, 17};
        System.out.println(ial.minimumCandiesPerHour(d));
        Assert.assertEquals(10,ial.minimumCandiesPerHour(d));
    }

    @Test
    public void minimumCandiesPerHourXTest()
    {
        int a[] = {1, 0, 2};
        Assert.assertEquals(5,ial.minimumCandiesPerHourX(a));
        int b[]={1,2,2};
        Assert.assertEquals(4,ial.minimumCandiesPerHourX(b));
        int c[]={8,3,2,1,4,5,2,3,4};
        System.out.println(ial.minimumCandiesPerHourX(c));
        Assert.assertEquals(21,ial.minimumCandiesPerHourX(c));
        int d[]={4, 9, 11, 17};
        System.out.println(ial.minimumCandiesPerHourX(d));
        Assert.assertEquals(10,ial.minimumCandiesPerHourX(d));
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

    @Test
    public void findVowlesIndexTest(){
        List<Integer> rsList = List.of(0,3,5,8,11,13);
        Assert.assertEquals(rsList,ial.findVowlesIndex("abhimanyu kumar"));
        System.out.print(ial.findVowlesIndex("abhimanyu kumar"));
    }
}