package interview.preparation.company.interviews.interview.product.base;

import interview.preparation.company.interviews.impl.product.base.ProductImpl;
import interview.preparation.company.interviews.question.product.base.IProduct;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class IProductTest {

    IProduct ip;

    @Before
    public void init()
    {
        ip = new ProductImpl();
    }
    /**Find all the Unique numbers from the List of string List<String> strArr = Arrays.asList("1,2,3", "3,4,5", "6,abc,7,-2", "8,9,10", "10,2,4");
     Output:  [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]*/
    @Test
    public void uniqueNosTest()
    {
        List<String> strArr = Arrays.asList("1,2,3", "3,4,5", "6,abc,7,-2", "8,9,10", "10,2,4");
        List<Integer> list = ip.uniqueNos(strArr);
        List<Integer> expList = List.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1,-2);

        Assert.assertEquals(expList,list);
    }

    /**Given an integer n,  the task is to print,
     FizzBuzzRizz if divisible by 3, 5 and 7
     "FizzBuzz" if i is divisible by 3 and 5,
     "FizzRIzz" if divisible by 3 and 7,
     BuzzRizz f divisible by 5 and 7
     "Fizz" if i is divisible by 3,
     "Buzz" if i is divisible by 5
     "Rizz" if i isdivisible by 7
     "n" as a string, if none of the conditions are true**/
    @Test
    public void fizzBuzzRizzTest()
    {
        Assert.assertEquals("1", ip.fizzBuzzRizz(1));
        Assert.assertEquals("Fizz", ip.fizzBuzzRizz(3));
        Assert.assertEquals("Buzz", ip.fizzBuzzRizz(5));
        Assert.assertEquals("Rizz", ip.fizzBuzzRizz(7));

        Assert.assertEquals("FizzBuzz", ip.fizzBuzzRizz(15));   // 3*5
        Assert.assertEquals("FizzRizz", ip.fizzBuzzRizz(21));   // 3*7
        Assert.assertEquals("BuzzRizz", ip.fizzBuzzRizz(35));   // 5*7

        Assert.assertEquals("FizzBuzzRizz", ip.fizzBuzzRizz(105)); // 3*5*7
    }

    @Test
    public void fizzBuzzRizzKizzTest()
    {
        Assert.assertEquals("Fizz", ip.fizzBuzzRizzKizz(3));
        Assert.assertEquals("Buzz", ip.fizzBuzzRizzKizz(5));
        Assert.assertEquals("Rizz", ip.fizzBuzzRizzKizz(7));
        Assert.assertEquals("Kizz", ip.fizzBuzzRizzKizz(11));

        Assert.assertEquals("FizzBuzz", ip.fizzBuzzRizzKizz(15));   // 3*5
        Assert.assertEquals("FizzRizz", ip.fizzBuzzRizzKizz(21));   // 3*7
        Assert.assertEquals("FizzKizz", ip.fizzBuzzRizzKizz(33));   // 3*11
        Assert.assertEquals("BuzzRizz", ip.fizzBuzzRizzKizz(35));   // 5*7
        Assert.assertEquals("BuzzKizz", ip.fizzBuzzRizzKizz(55));   // 5*11
        Assert.assertEquals("RizzKizz", ip.fizzBuzzRizzKizz(77));   // 7*11

        Assert.assertEquals("FizzBuzzRizz", ip.fizzBuzzRizzKizz(105));   // 3*5*7
        Assert.assertEquals("FizzBuzzKizz", ip.fizzBuzzRizzKizz(165));  // 3*5*11
        Assert.assertEquals("FizzRizzKizz", ip.fizzBuzzRizzKizz(231));  // 3*7*11
        Assert.assertEquals("BuzzRizzKizz", ip.fizzBuzzRizzKizz(385));  // 5*7*11

        Assert.assertEquals("1", ip.fizzBuzzRizzKizz(1));
        Assert.assertEquals("2", ip.fizzBuzzRizzKizz(2));
        Assert.assertEquals("4", ip.fizzBuzzRizzKizz(4));
        Assert.assertEquals("8", ip.fizzBuzzRizzKizz(8));
        Assert.assertEquals("13", ip.fizzBuzzRizzKizz(13));
    }

    @Test
    public void fizzBuzzRizzKizzXTest()
    {
        Assert.assertEquals("Fizz", ip.fizzBuzzRizzKizzX(3));
        Assert.assertEquals("Buzz", ip.fizzBuzzRizzKizzX(5));
        Assert.assertEquals("Rizz", ip.fizzBuzzRizzKizzX(7));
        Assert.assertEquals("Kizz", ip.fizzBuzzRizzKizzX(11));

        Assert.assertEquals("FizzBuzz", ip.fizzBuzzRizzKizzX(15));   // 3*5
        Assert.assertEquals("FizzRizz", ip.fizzBuzzRizzKizzX(21));   // 3*7
        Assert.assertEquals("FizzKizz", ip.fizzBuzzRizzKizzX(33));   // 3*11
        Assert.assertEquals("BuzzRizz", ip.fizzBuzzRizzKizzX(35));   // 5*7
        Assert.assertEquals("BuzzKizz", ip.fizzBuzzRizzKizzX(55));   // 5*11
        Assert.assertEquals("RizzKizz", ip.fizzBuzzRizzKizzX(77));   // 7*11

        Assert.assertEquals("FizzBuzzRizz", ip.fizzBuzzRizzKizzX(105));   // 3*5*7
        Assert.assertEquals("FizzBuzzKizz", ip.fizzBuzzRizzKizzX(165));  // 3*5*11
        Assert.assertEquals("FizzRizzKizz", ip.fizzBuzzRizzKizzX(231));  // 3*7*11
        Assert.assertEquals("BuzzRizzKizz", ip.fizzBuzzRizzKizzX(385));  // 5*7*11

        Assert.assertEquals("1", ip.fizzBuzzRizzKizzX(1));
        Assert.assertEquals("2", ip.fizzBuzzRizzKizzX(2));
        Assert.assertEquals("4", ip.fizzBuzzRizzKizzX(4));
        Assert.assertEquals("8", ip.fizzBuzzRizzKizzX(8));
        Assert.assertEquals("13", ip.fizzBuzzRizzKizzX(13));
    }
}
