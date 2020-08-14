package com.design.analysis.concurrent.utils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.design.analysis.concurrent.utils.running.ConcurrentMapExpl;
import com.design.analysis.concurrent.utils.running.ConcurrentNavigableMapExpl;
import com.design.analysis.concurrent.utils.running.CountDownLatchDecrementer;
import com.design.analysis.concurrent.utils.running.CountDownLatchWaiter;
import com.design.analysis.concurrent.utils.running.CyclicBarrierRunnable;
import com.design.analysis.concurrent.utils.running.ExchangerRunnable;
import com.design.analysis.concurrent.utils.running.SemaphoreExpl;
import com.design.analysis.concurrent.utils.running.blockingqueue.BlockingQueConsumer;
import com.design.analysis.concurrent.utils.running.blockingqueue.BlockingQueProducer;
import com.design.analysis.concurrent.utils.running.blockingqueue.DelayElement;
import com.design.analysis.concurrent.utils.running.blockingqueue.DelayQueueConsumer;
import com.design.analysis.concurrent.utils.running.blockingqueue.DelayQueueProducer;
import com.design.analysis.concurrent.utils.running.blockingqueue.ElementAdd;
import com.design.analysis.concurrent.utils.running.blockingqueue.ElementGet;
import com.design.analysis.concurrent.utils.running.blockingqueue.PriorityBlockingConsumer;
import com.design.analysis.concurrent.utils.running.blockingqueue.PriorityBlockingProducer;
import com.design.analysis.concurrent.utils.running.blockingqueue.SynchronousQueueConsumer;
import com.design.analysis.concurrent.utils.running.blockingqueue.SynchronousQueueProducer;
import com.design.analysis.concurrent.utils.running.executorservice.ExecutorServiceExecute;
import com.design.analysis.concurrent.utils.running.executorservice.ExecutorServiceSubmit;
import com.design.analysis.concurrent.utils.running.executorservice.InvokeExmpl;
import com.design.analysis.concurrent.utils.running.executorservice.RejectedExecutionHandlerImpl;
import com.design.analysis.concurrent.utils.running.executorservice.ScheduledExecutorServiceExpl;
import com.design.analysis.concurrent.utils.running.executorservice.ThreadPoolExecutorExmpl;
import com.design.analysis.concurrent.utils.running.executorservice.WorkerThread;
import com.design.analysis.concurrent.utils.running.joinandfork.ForkJoinRecursiveAction;
import com.design.analysis.concurrent.utils.running.joinandfork.ForkJoinRecursiveTask;

public class ConcurrentUtilsImpl implements IConcurrentUtils {

	/** BlockingQueue **/
	/* ArrayBlockingQueue */
	@Override
	public void blockingQueueExapl() throws InterruptedException {

		BlockingQueue<String> queue = new ArrayBlockingQueue<>(1024);

		BlockingQueProducer producer = new BlockingQueProducer(queue);
		BlockingQueConsumer consumer = new BlockingQueConsumer(queue);

		new Thread(producer).start();
		new Thread(consumer).start();

		Thread.sleep(4000);
	}

	/** DelayQueue **/
	@Override
	public void delayQueueExapl() throws InterruptedException {
		final BlockingQueue<DelayElement> queue = new DelayQueue<DelayElement>();

		DelayQueueProducer queueProducer = new DelayQueueProducer(queue);
		new Thread(queueProducer).start();

		DelayQueueConsumer queueConsumer1 = new DelayQueueConsumer(queue);
		new Thread(queueConsumer1).start();

		DelayQueueConsumer queueConsumer2 = new DelayQueueConsumer(queue);
		new Thread(queueConsumer2).start();
	}

	/** LinkedBlockingQueue **/
	@Override
	public void linkedBlockingQueue() throws InterruptedException {
		BlockingQueue<String> queue = new LinkedBlockingQueue<>(1024);

		BlockingQueProducer producer = new BlockingQueProducer(queue);
		BlockingQueConsumer consumer = new BlockingQueConsumer(queue);

		new Thread(producer).start();
		new Thread(consumer).start();

		Thread.sleep(4000);
	}

	/** PriorityBlockingQueue **/
	@Override
	public void priorityBlockingQueue() throws InterruptedException {
		final BlockingQueue<Integer> queue = new PriorityBlockingQueue<>();
		new Thread(new PriorityBlockingProducer(queue)).start();
		new Thread(new PriorityBlockingConsumer(queue)).start();

		Thread.sleep(4000);
	}

	/** SynchronousQueue **/
	@Override
	public void synchronousQueue() throws InterruptedException {
		BlockingQueue<String> queue = new SynchronousQueue<>();

		SynchronousQueueProducer producer = new SynchronousQueueProducer(queue);
		SynchronousQueueConsumer consumer = new SynchronousQueueConsumer(queue);

		new Thread(producer).start();
		new Thread(consumer).start();

		Thread.sleep(4000);
	}

	/** BlockingDeque **/
	/* LinkedBlockingDeque */
	@Override
	public void blockingDeque() throws InterruptedException {
		BlockingDeque<String> bd = new LinkedBlockingDeque<String>(1);

		ExecutorService exService = Executors.newFixedThreadPool(2);

		ElementAdd elementAdd = new ElementAdd(bd);
		ElementGet elementGet = new ElementGet(bd);
		exService.execute(elementAdd);
		exService.execute(elementGet);
		exService.shutdown();
	}

	/** concurrent hashmap example **/
	@Override
	public void concurrentMapExpl() throws InterruptedException {

		ConcurrentMapExpl smd = new ConcurrentMapExpl();
		new Thread(smd, "a").start();
		new Thread(smd, "b").start();
		new Thread(smd, "c").start();
		new Thread(smd, "d").start();
		new Thread(smd, "e").start();
		String a[] = { "a", "b", "c", "d", "e" };

		for (int i = 0; i < a.length; i++)
			System.out.println(smd.cmap.get(a[i]));
	}

	/** concurrent ConcurrentNavigableMap example **/
	@Override
	public void concurrentNavigableMapExpl() throws InterruptedException {
		ConcurrentNavigableMapExpl smd = new ConcurrentNavigableMapExpl();
		new Thread(smd, "a").start();
		new Thread(smd, "b").start();
		new Thread(smd, "c").start();
		new Thread(smd, "d").start();
		new Thread(smd, "e").start();
		String a[] = { "e", "b", "c", "d", "a" };
		smd.cmap.tailMap("c");
		for (int i = 0; i < a.length; i++)
			System.out.println(smd.cmap.get(a[i]));

	}

	/** CountDownLatch simple example */
	@Override
	public void CountDownLatchExmpl() throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(3);

		CountDownLatchWaiter waiter = new CountDownLatchWaiter(latch);
		CountDownLatchDecrementer decrementer = new CountDownLatchDecrementer(latch);

		new Thread(waiter).start();
		new Thread(decrementer).start();

		Thread.sleep(4000);
	}

	/** CyclicBarrier **/
	@Override
	public void cyclicBarrierExmpl() throws InterruptedException {
		Runnable barrier1Action = new Runnable() {
			public void run() {
				System.out.println("BarrierAction 1 executed ");
			}
		};
		Runnable barrier2Action = new Runnable() {
			public void run() {
				System.out.println("BarrierAction 2 executed ");
			}
		};

		CyclicBarrier barrier1 = new CyclicBarrier(2, barrier1Action);
		CyclicBarrier barrier2 = new CyclicBarrier(2, barrier2Action);

		CyclicBarrierRunnable barrierRunnable1 = new CyclicBarrierRunnable(barrier1, barrier2);

		CyclicBarrierRunnable barrierRunnable2 = new CyclicBarrierRunnable(barrier1, barrier2);

		new Thread(barrierRunnable1).start();
		new Thread(barrierRunnable2).start();
	}

	/** Exchanger **/
	@Override
	public void exchangerExpl() throws InterruptedException {
		Exchanger<Object> exchanger = new Exchanger<>();

		ExchangerRunnable exchangerRunnable1 = new ExchangerRunnable(exchanger, "A");

		ExchangerRunnable exchangerRunnable2 = new ExchangerRunnable(exchanger, "B");

		new Thread(exchangerRunnable1).start();
		new Thread(exchangerRunnable2).start();
	}

	/** Semaphore **/
	@SuppressWarnings("static-access")
	@Override
	public void semaphreExpl() throws InterruptedException {
		SemaphoreExpl semaphore = new SemaphoreExpl();
		System.out.println("Total available Semaphore permits : " + semaphore.semaphore.availablePermits());

		new Thread(semaphore, "a").start();
		new Thread(semaphore, "b").start();
		new Thread(semaphore, "c").start();
		new Thread(semaphore, "d").start();
		new Thread(semaphore, "e").start();
	}

	/** ExecutorService **/
	/* simple executor service */
	@Override
	public void executorServiceExpl() throws InterruptedException {
		ExecutorServiceExecute ese = new ExecutorServiceExecute();
		ese.excute();
	}

	/* Execurot runnable */
	@Override
	public void executorRunnale() throws InterruptedException, ExecutionException {
		ExecutorServiceSubmit ess = new ExecutorServiceSubmit();
		ess.runnable();
	}

	/* executor callable */
	@Override
	public void executorCallable() throws InterruptedException, ExecutionException {
		ExecutorServiceSubmit ess = new ExecutorServiceSubmit();
		ess.callable();
	}

	/* invoke and invokeAll */
	@Override
	public void invokeExample() throws InterruptedException, ExecutionException {
		InvokeExmpl ie = new InvokeExmpl();
		ie.invokeAny();

	}

	/* invokeAll example */
	@Override
	public void invokeAllExample() throws InterruptedException, ExecutionException {
		InvokeExmpl ieall = new InvokeExmpl();
		ieall.invokeAll();
	}

	/* ThreadPoolExecutor example */
	@Override
	public void threadPoolExecutorExmpl() throws InterruptedException, ExecutionException {
		// RejectedExecutionHandler implementation
		RejectedExecutionHandlerImpl rejectionHandler = new RejectedExecutionHandlerImpl();
		// Get the ThreadFactory implementation to use
		ThreadFactory threadFactory = Executors.defaultThreadFactory();
		// creating the ThreadPoolExecutor
		ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(2), threadFactory, rejectionHandler);
		// start the monitoring thread
		ThreadPoolExecutorExmpl monitor = new ThreadPoolExecutorExmpl(executorPool, 3);
		Thread monitorThread = new Thread(monitor);
		monitorThread.start();
		// submit work to the thread pool
		for (int i = 0; i < 10; i++) {
			executorPool.execute(new WorkerThread("cmd" + i));
		}

		Thread.sleep(30000);
		// shut down the pool
		executorPool.shutdown();
		// shut down the monitor thread
		Thread.sleep(5000);
		monitor.shutdown();
	}

	/* ScheduledExecutorService */
	@Override
	public void scheduledExecutorServiceExmpl() throws InterruptedException, ExecutionException {
		ScheduledExecutorServiceExpl ses = new ScheduledExecutorServiceExpl();
		ses.excute();
	}

	/** Java Fork and Join using ForkJoinPool **/

	/* ForkJoinRecursiveAction example */
	@Override
	public void forkJoinRecursiveAction() throws InterruptedException, ExecutionException {
		ForkJoinRecursiveAction fjra = new ForkJoinRecursiveAction(32);
		fjra.compute();
	}

	/* ForkJoinRecursiveTask */
	@Override
	public void forkJoinRecursiveTask() throws InterruptedException, ExecutionException {
		ForkJoinRecursiveTask fjra = new ForkJoinRecursiveTask(32);
		fjra.compute();
	}
}
