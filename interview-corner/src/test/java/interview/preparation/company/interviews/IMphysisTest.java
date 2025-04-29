package interview.preparation.company.interviews;

import interview.preparation.company.interviews.impl.MphysisImpl;
import interview.preparation.company.interviews.model.Employee;
import interview.preparation.company.interviews.question.IMphysis;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class IMphysisTest {

	IMphysis imp = null;

	@Before
	public void init() {
		imp = new MphysisImpl();
	}

	/*
	 * You are given an array prices where prices[i] is the price of a given stock
	 * on the ith day.
	 * 
	 * You want to maximize your profit by choosing a single day to buy one stock
	 * and choosing a different day in the future to sell that stock.
	 */
	// O(n)
	@Test
	public void maxProfitSingleStockBuyShellTest() {
		int a[] = { 7, 1, 5, 3, 6, 4 };
		Assert.assertEquals(5, imp.maxProfitSingleStockBuyShell(a) );
	}

	/* find the 2nd max value in array by single iteration */
	@Test
	public void secnodMaxSingleIterationTest() {
		int a[] = { 7, 1, 5, 3, 6, 4 };
		Assert.assertEquals(6,imp.secondMaxSingleIteration(a));
	}
	/*("Australia");"India");("Africa");("Indonesia");("Malaysia"); output ={"AustraliaAA","AfricaAA"};*/
	@Test
	public void concatFilterTest(){
	List<String> list = List.of("Australia","India","Africa","Indonesia","Malaysia");
	System.out.println(imp.concatFilter(list).toString());
	Assert.assertTrue(imp.concatFilter(list).containsAll(List.of("AustraliaAA","AfricaAA")));
	}

    /*remove duplicate char from string*/
    @Test
    public void removeDuplicateCharTest()
    {
        String s ="abhimanyukumar";
        Assert.assertEquals("abhimnyukr",imp.removeDuplicateChar(s));
    }

    /*find highest salary employee in each of department*/
    @Test
    public void maxEarningOnDeprtTest()
    {
        List<String> names = List.of("A","B","C","D","E","F","G","H","I","J");
        List<String> depts = List.of("X","Y","Z","X","Y","X","X","X","Y","Z");
        List<Integer> salaries = List.of(100,200,300,400,300,200,100,50,25,10);

        List<Employee> list = new ArrayList<>();
        for(int i=0;i<names.size();i++)
            list.add(new Employee(names.get(i),salaries.get(i),depts.get(i)));
        Map<String, Optional<Employee>> empMap = imp.maxEarningOnDeprt(list);
        for(Map.Entry entry:empMap.entrySet())
        {
            Optional<Employee> e = (Optional) entry.getValue();
            System.out.println(entry.getKey() +"::"+e.get().salary);
        }

    }
}
