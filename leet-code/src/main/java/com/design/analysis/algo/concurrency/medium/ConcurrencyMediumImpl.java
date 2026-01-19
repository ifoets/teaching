package com.design.analysis.algo.concurrency.medium;

import java.util.concurrent.Semaphore;

public class ConcurrencyMediumImpl implements IConcurrencyMedium{
    /**1115. Print FooBar Alternately**/
    @Override
    public void printFootBarAlternately(int n)throws InterruptedException {

         class FooBar {

             private final int n;
             private final Semaphore foo = new Semaphore(1); // Foo starts
             private final Semaphore bar = new Semaphore(0);

             public FooBar(int n) {
                 this.n = n;
             }

             public void foo(Runnable printFoo) throws InterruptedException {
                 for (int i = 0; i < n; i++) {
                     foo.acquire();
                     printFoo.run();      // prints "Foo"
                     bar.release();
                 }
             }

             public void bar(Runnable printBar) throws InterruptedException {
                 for (int i = 0; i < n; i++) {
                     bar.acquire();
                     printBar.run();      // prints "Bar"
                     foo.release();
                 }
             }
         }
        FooBar fb = new FooBar(n);
            new Thread(() -> {
                try {
                    fb.foo(() -> System.out.print("Foo"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();

            new Thread(() -> {
                try {
                    fb.bar(() -> System.out.print("Bar"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
    }


}
