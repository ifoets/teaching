package interview.preparation.self.asked.company.impl;

import interview.preparation.self.asked.company.question.IInnovasolutions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class IInnovasolutionsTest {

    IInnovasolutions is;

    @Before
    public void init()
    {
        is = new InnovasolutionsImpl();
    }

    /*return integer start with 1*/
    @Test
   public void getIntStartWithITest()
   {
       List<Integer> list = List.of(10,15,8,49,25,98,32);
       Assert.assertTrue(is.getIntStartWithI(list,1,true).containsAll(List.of(10,15)));
       Assert.assertTrue(is.getIntStartWithI(list,8,false).containsAll(List.of(8,98)));
   }

    /*return max length sub string having unique char*/
    @Test
    public void getMaxLenSubStrUniqueCharTest()
    {
        String str1 = "ABCDEFGABEF";
        String str2 = "GEEKSFORGEEKS";

        Assert.assertTrue(is.getMaxLenSubStrUniqueChar(str1).equals("ABCDEFG"));
        Assert.assertTrue(is.getMaxLenSubStrUniqueChar(str2).equals("EKSFORG"));
    }
}
