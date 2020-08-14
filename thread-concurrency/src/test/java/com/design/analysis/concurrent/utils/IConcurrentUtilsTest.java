package com.design.analysis.concurrent.utils;

import java.util.concurrent.ExecutionException;

import org.junit.Before;
import org.junit.Test;

public class IConcurrentUtilsTest {

	public IConcurrentUtils icu = null;

	@Before
	public void init() {
		icu = new ConcurrentUtilsImpl();
	}

	/** BlockingQueue **/
	/* ArrayBlockingQueue */
	@Test
	public void blockingQueueExapl() throws InterruptedException {
		icu.blockingQueueExapl();
	}

	/** DelayQueue **/
	@Test
	public void delayQueueExapl() throws InterruptedException {
		icu.delayQueueExapl();
	}

	/** LinkedBlockingQueue **/
	@Test
	public void linkedBlockingQueue() throws InterruptedException {
		icu.linkedBlockingQueue();
	}

	/** PriorityBlockingQueue **/
	@Test
	public void priorityBlockingQueue() throws InterruptedException {
		icu.priorityBlockingQueue();
	}

	/** SynchronousQueue **/
	@Test
	public void synchronousQueue() throws InterruptedException {
		icu.synchronousQueue();
	}

	/** BlockingDeque **/
	/* LinkedBlockingDeque */
	@Test
	public void blockingDeque() throws InterruptedException {
		icu.blockingDeque();
	}

	/** concurrent hashmap example **/
	@Test
	public void concurrentMapExpl() throws InterruptedException {
		icu.concurrentMapExpl();
	}

	/** concurrent ConcurrentNavigableMap example **/
	@Test
	public void concurrentNavigableMapExpl() throws InterruptedException {
		icu.concurrentNavigableMapExpl();
	}

	/** CountDownLatch simple example */
	@Test
	public void CountDownLatchExmpl() throws InterruptedException {
		icu.CountDownLatchExmpl();
	}

	/** CyclicBarrier **/
	@Test
	public void cyclicBarrierExmpl() throws InterruptedException {
		icu.cyclicBarrierExmpl();
	}

	@Test
	/** Exchanger **/
	public void exchangerExpl() throws InterruptedException {
		icu.exchangerExpl();
	}

	/** Semaphore **/
	@Test
	public void semaphreExpl() throws InterruptedException {
		icu.semaphreExpl();
	}

	/** ExecutorService **/
	/* simple executor service */
	@Test
	public void executorServiceExpl() throws InterruptedException {
		icu.executorServiceExpl();
	}

	/* Execurot runnable */
	@Test
	public void executorRunnale() throws InterruptedException, ExecutionException {
		icu.executorRunnale();
	}

	/* executor callable */
	@Test
	public void executorCallable() throws InterruptedException, ExecutionException {
		icu.executorCallable();
	}

	/* invoke and invokeAll */
	@Test
	public void invokeExample() throws InterruptedException, ExecutionException {
		icu.invokeExample();
	}

	/* invokeAll example */
	@Test
	public void invokeAllExample() throws InterruptedException, ExecutionException {
		icu.invokeAllExample();
	}

	/* ThreadPoolExecutor example */
	@Test
	public void threadPoolExecutorExmpl() throws InterruptedException, ExecutionException {
		icu.threadPoolExecutorExmpl();
	}

	/* ScheduledExecutorService */
	@Test
	public void scheduledExecutorServiceExmpl() throws InterruptedException, ExecutionException {
		icu.scheduledExecutorServiceExmpl();
	}

	/** Java Fork and Join using ForkJoinPool **/

	/* ForkJoinRecursiveAction example */
	@Test
	public void forkJoinRecursiveAction() throws InterruptedException, ExecutionException {
		icu.forkJoinRecursiveAction();
	}

	/* ForkJoinRecursiveTask */
	@Test
	public void forkJoinRecursiveTask() throws InterruptedException, ExecutionException {
		icu.forkJoinRecursiveTask();
	}
}
