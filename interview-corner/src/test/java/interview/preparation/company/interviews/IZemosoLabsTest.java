package interview.preparation.company.interviews;

import interview.preparation.company.interviews.impl.ZemosoLabsImpl;
import interview.preparation.company.interviews.question.IZemosoLabs;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IZemosoLabsTest {

    IZemosoLabs izl;

    @Before
    public  void inti()
    {
        izl = new ZemosoLabsImpl();
    }

    /**find unique char in string**/
    @Test
    public void uniqueCharTest(){
        Map<Character,Long>  map = izl.uniqueChar("abhimanyukumar");
        Map<Character,Long> expMap = Map.of('b',1L, 'h',1L, 'i',1L, 'k',1L, 'n',1L, 'r',1L, 'y',1L);
        System.out.println(map);
        Assert.assertEquals(expMap,map);
    }

    /**collect all the arrangement of String**/
    @Test
    public void permutationTest()
    {
        List<String> rsList = new ArrayList<>();
        List<String> rsExpList = List.of("ABC", "ACB", "BAC", "BCA", "CBA", "CAB");
        izl.permutation("ABC",0,2,rsList);
        System.out.println(rsList);
        Assert.assertEquals(rsExpList,rsList);
    }
}
