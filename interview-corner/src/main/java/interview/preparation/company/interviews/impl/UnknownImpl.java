package interview.preparation.company.interviews.impl;

import interview.preparation.company.interviews.question.IUnknown;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UnknownImpl implements IUnknown {

    /**Handle exception thrown by one thread in another thread using
     Future and ExecutorService**/
    @Override
    public void exceptionHandleByDiffThread(){
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<?> future = executor.submit(() -> {
            throw new RuntimeException("Exception in thread");
        });

        try {
            future.get();  // This will throw ExecutionException
        } catch (ExecutionException e) {
            System.out.println("Caught exception: " + e.getCause());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // best practice
        }

        executor.shutdown();
    }

    /**Handle exception thrown by one thread in another thread using
     Thread.setUncaughtExceptionHandler()**/
    @Override
    public void exceptionHandleByDiffThreadX(){
        Thread thread = new Thread(() -> {
            throw new RuntimeException("Error in child thread");
        });

        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("Caught exception from thread: " + t.getName() + " - " + e.getMessage());
        });

        thread.start();
    }
}
