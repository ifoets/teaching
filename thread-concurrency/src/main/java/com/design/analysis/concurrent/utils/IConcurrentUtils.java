package com.design.analysis.concurrent.utils;

import java.util.concurrent.ExecutionException;

public interface IConcurrentUtils {

	/** BlockingQueue **/
	/* ArrayBlockingQueue */
	public void blockingQueueExapl() throws InterruptedException;

	/** DelayQueue **/
	// TODO take is not working properly need to work out
	public void delayQueueExapl() throws InterruptedException;

	/** LinkedBlockingQueue **/
	public void linkedBlockingQueue() throws InterruptedException;

	/** PriorityBlockingQueue **/
	public void priorityBlockingQueue() throws InterruptedException;

	/** SynchronousQueue **/
	public void synchronousQueue() throws InterruptedException;

	/** BlockingDeque **/
	/* LinkedBlockingDeque */
	public void blockingDeque() throws InterruptedException;

	/** concurrent hashmap example **/
	public void concurrentMapExpl() throws InterruptedException;

	/** concurrent ConcurrentNavigableMap example **/
	public void concurrentNavigableMapExpl() throws InterruptedException;

	/** CountDownLatch simple example */
	public void CountDownLatchExmpl() throws InterruptedException;

	/** CyclicBarrier **/
	public void cyclicBarrierExmpl() throws InterruptedException;

	/** Exchanger **/
	public void exchangerExpl() throws InterruptedException;

	/** Semaphore **/
	public void semaphreExpl() throws InterruptedException;

	/** ExecutorService **/
	/* simple executor service */
	public void executorServiceExpl() throws InterruptedException;

	/* Execurot runnable */
	public void executorRunnale() throws InterruptedException, ExecutionException;

	/* executor callable */
	public void executorCallable() throws InterruptedException, ExecutionException;

	/* invoke example */
	public void invokeExample() throws InterruptedException, ExecutionException;

	/* invokeAll example */
	public void invokeAllExample() throws InterruptedException, ExecutionException;

	/* ThreadPoolExecutor example */
	public void threadPoolExecutorExmpl() throws InterruptedException, ExecutionException;

	/* ScheduledExecutorService */
	public void scheduledExecutorServiceExmpl() throws InterruptedException, ExecutionException;

	/** Java Fork and Join using ForkJoinPool **/

	/* ForkJoinRecursiveAction example */
	public void forkJoinRecursiveAction() throws InterruptedException, ExecutionException;

	/* ForkJoinRecursiveTask */
	public void forkJoinRecursiveTask() throws InterruptedException, ExecutionException;
}
