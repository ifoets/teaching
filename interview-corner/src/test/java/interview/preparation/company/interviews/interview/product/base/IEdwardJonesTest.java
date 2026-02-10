package interview.preparation.company.interviews.interview.product.base;

import interview.preparation.company.interviews.impl.product.base.EdwardJonesImpl;
import interview.preparation.company.interviews.impl.product.base.model.Address;
import interview.preparation.company.interviews.impl.product.base.model.Employee;
import interview.preparation.company.interviews.impl.product.base.model.Transaction;
import interview.preparation.company.interviews.question.product.base.IEdwardJones;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class IEdwardJonesTest {

    IEdwardJones idj;
    @Before
    public void init()
    {
        idj = new EdwardJonesImpl();
    }

    /**
     * Given a numeric array, re arrange the elements to form the highest possible value.
     * input is: int arr[] = {1, 34, 3, 98, 9, 76, 45, 4};
     * output should be: 998764543431
     */
    @Test
    public void arrangeHeigestValuesTest()
    {
        int[] arr = {1, 34, 3, 98, 9, 76, 45, 4};
        Assert.assertEquals("998764543431",idj.arrangeHeigestValues(arr));
    }
    /**
     Find sum of all digits of a number in Java 8?
     int i = 236839**/
    @Test
    public void sumOfAllDigitsOfANumberTest()
    {
        Assert.assertEquals(31,idj.sumOfAllDigitsOfANumber(236839));
    }

    /**filter out those employees who have at least one address in Pune**/
    @Test
    public void atleastOneAddressPuneTest()
    {
        Employee emp1 = new Employee("AA",List.of(new Address("pune"), new Address("pune"),new Address("bang")));
        Employee em2 = new Employee("AA",List.of(new Address("abc"), new Address("pune"),new Address("bang")));
        Employee em3 = new Employee("AA",List.of(new Address("pune"), new Address("xx"),new Address("yy")));
        Employee em4 = new Employee("AA",List.of(new Address("zz"), new Address("fff"),new Address("bang")));
        Employee em5 = new Employee("AA",List.of(new Address("xx"), new Address("yy"),new Address("pune")));

        List<Employee> list = List.of(emp1,em2,em3,em4,em5);
        Assert.assertEquals(4,idj.atleastOneAddressPune(list).size());
    }

    /**1.Perform cube on list elements and filter numbers greater than 50 and sort in descending order.**/
    @Test
    public void cubeGreaterThanTest()
    {
        List<Integer> list = List.of(9,1,8,2,7,3,6,4,5);
        Assert.assertEquals(5,idj.cubeGreaterThan(list,100).size());
    }
    /**find COMPLETED Transaction sum**/
    @Test
    public void completedTransSunTest()
    {

        List<Transaction> list = List.of(
            new Transaction(1, new BigDecimal("100.50"), "USD", "COMPLETED"),
            new Transaction(2, new BigDecimal("200.00"), "EUR", "PENDING"),
            new Transaction(3, new BigDecimal("50.00"), "USD", "COMPLETED"),
            new Transaction(4, new BigDecimal("300.75"), "EUR", "COMPLETED")
        );
        System.out.println(idj.completedTransSun(list));
        Assert.assertEquals(new BigDecimal("451.25"),idj.completedTransSun(list).get("COMPLETED"));
    }

    /**String[] numbers = {"123","abc",null,"456"};**/
    @Test
    public void filterOnlyNumberTest()
    {
        String[] numbers = {"123","abc",null,"456"};
        List<String> list =  idj.filterOnlyNumber(numbers);
        List<String> exp = List.of("123","456");
        Assert.assertEquals(exp,list);
        System.out.println(exp);
    }

    /**group anagram strings**/
    @Test
    public void groupAnagramsTest()
    {
       List<String> list = List.of("eat","tea","tan","ate","nat","bat");
       List<List<String>> rList = idj.groupAnagrams(list);
       Assert.assertEquals(3,rList.size());
       for(List<String> ll:rList)
        System.out.println(ll);
    }

    @Test
    public void getDaysOfYearTest()
    {
      Assert.assertEquals(40,idj.getDaysOfYear(2,9,2025));
    }
}
