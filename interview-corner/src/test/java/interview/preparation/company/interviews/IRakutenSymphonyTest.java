package interview.preparation.company.interviews;

import interview.preparation.company.interviews.impl.RakutenSymphonyImpl;
import interview.preparation.company.interviews.question.IRakutenSymphony;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class IRakutenSymphonyTest {

    private IRakutenSymphony irs;

    @Before
    public  void init()
    {
        irs = new RakutenSymphonyImpl();
    }

    /**min cost to join the broken ropes in single rope*/

    @Test
    public void minCostJoinRopesTest()
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(6);
      //  4,3,2,6
        Assert.assertEquals(29, irs.minCostJoinRopes(list,0));
    }

    @Test
    public void minCostJoinRopesXTest()
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(6);
        //  4,3,2,6
        Assert.assertEquals(29, irs.minCostJoinRopesX(list));
    }
}
