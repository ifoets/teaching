package interview.preparation.company.interviews;

import interview.preparation.company.interviews.question.IUnknown;
import interview.preparation.company.interviews.question.UnknownImpl;
import org.junit.Before;
import org.junit.Test;

public class IKnownTestl {

    private IUnknown ik;

    @Before
    public void init(){
        ik = new UnknownImpl();
    }

    /**Handle exception thrown by one thread in another thread using
     Future and ExecutorService**/
    @Test
    public void exceptionHandleByDiffThreadTest()
    {
        ik.exceptionHandleByDiffThread();
    };

    /**Handle exception thrown by one thread in another thread using
     Thread.setUncaughtExceptionHandler()**/
    @Test
    public void exceptionHandleByDiffThreadX(){
        ik.exceptionHandleByDiffThreadX();
    }
}
