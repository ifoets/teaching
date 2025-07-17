package interview.advance;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPoolExecutor {

    private final BlockingQueue<Runnable> blockingQueue;
    private final Worker[] workers;
    private volatile boolean isShutdown  = false;

    public MyThreadPoolExecutor(int numOfThreads)
    {
        blockingQueue = new LinkedBlockingQueue<>();
        workers = new Worker[numOfThreads];
        for(int i=0;i<numOfThreads;i++) {
            workers[i] = new Worker("CustomPool-Thread "+i);
            workers[i].start();
        }
    }
    public int runningThread()
    {
        if(!isShutdown)
            return workers.length;
        return 0;
    }
    public void execute(Runnable runnable)
    {
        if(isShutdown)
        {
            throw new IllegalStateException("ThreadPool is shutdown");
        }
        blockingQueue.offer(runnable);
    }
    public void shutdown()
    {
        isShutdown = true;
        for(Worker worker: workers)
        {
            worker.interrupt();;
        }
    }
    private class Worker extends Thread
    {
        Worker(String name)
        {
            super(name);
        }

        public void run()
        {
            while (!isShutdown || !blockingQueue.isEmpty())
            {
                try
                {
                    Runnable task = blockingQueue.take();
                    task.run();
                }catch (InterruptedException e)
                {
                    //exists is shutdown else continue
                    if(isShutdown)break;
                }catch (Throwable t)
                {
                    System.err.println("Error in task "+t.getMessage());
                }
            }
        }

    }
}
