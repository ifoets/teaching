package interview.advance;

import org.junit.Assert;
import org.junit.Test;

public class ThreadPoolExecutorTest {

    @Test
    public void customThreadPoolExecutorTest()
    {

        MyThreadPoolExecutor poolExecutor = new MyThreadPoolExecutor(3);
        Assert.assertEquals(3,poolExecutor.runningThread());
        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            poolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " executing task " + taskId);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {}
            });
        }

        try {
            Thread.sleep(15000);
        }catch (InterruptedException e)
        {
            System.err.println(e.getMessage());
        }

        poolExecutor.shutdown();
    }
}
