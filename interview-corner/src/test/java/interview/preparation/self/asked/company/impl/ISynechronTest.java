package interview.preparation.self.asked.company.impl;

import interview.preparation.company.interviews.impl.SynechronImpl;
import interview.preparation.company.interviews.question.ISynechron;
import org.junit.Before;
import org.junit.Test;

public class ISynechronTest {

    ISynechron is ;

    @Before
    public void init()
    {
        is = new SynechronImpl();
    }
    @Test
    public void createListTest() {
       int a []= {0,1,2,3,4,5,6,7,8,9};
       is.display(is.createList(null,a));
    }

    @Test
    public void createCycleTest() {
        int a []= {0,1,2,3,4,5,6,7,8,9};
       is.createCycle(is.createList(null,a));
    }
    @Test
    public void detectRemoveCycleTest() {
        int a []= {0,1,2,3,4,5,6,7,8,9};
        is.detectRemoveCycle(is.createCycle(is.createList(null,a)));
    }

    public void nthNodeFromLastTest()
    {

    }

}
