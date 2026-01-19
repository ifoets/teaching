package com.design.analysis.algo.concurrency.easy;

import java.util.concurrent.Semaphore;

public class ConcurrencyEasyImpl implements IConcurrencyEasy{

    /**1114. Print in Order**/
    public void printInOrder() throws InterruptedException{

         class Foo {

             Semaphore run2, run3;
            public Foo() throws InterruptedException {
                run2 = new Semaphore(0);
                run3 = new Semaphore(0);
            }

            public void first(Runnable printFirst) throws InterruptedException {

                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                run2.release();
            }

            public void second(Runnable printSecond) throws InterruptedException {
                run2.acquire();
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                run3.release();
            }

            public void third(Runnable printThird) throws InterruptedException {
              run3.acquire();
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();

            }
        }
        Foo fb = new Foo();
        new Thread(() -> {
            try {
                fb.first(() -> System.out.print("first"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        new Thread(() -> {
            try {
                fb.second(() -> System.out.print("second"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        new Thread(() -> {
            try {
                fb.third(() -> System.out.print("third"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}
