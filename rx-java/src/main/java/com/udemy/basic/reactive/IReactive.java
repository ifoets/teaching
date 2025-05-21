package com.udemy.basic.reactive;

import java.util.List;

import com.udemy.basic.reactive.model.Employee;
import com.udemy.basic.reactive.rinterface.ICallBack;
import com.udemy.basic.reactive.rinterface.IPushCallBack;

public interface IReactive {

	/** Section 16: Reactive Programming an Introduction **/

	/* Fundamentals 2 -CallBack Hello Example */
	public void callBackHellExmpl() throws InterruptedException;

	public void runningAsyc(ICallBack callback);

	public void sleep(int duration);

	/* Fundamentals 3 -Push CallBack Example */
	public void pushCallBackExmpl() throws InterruptedException;

	public void runningAsyc(IPushCallBack callback);

	/* Fundamentals 4 -Observer Design Pattern */
	public void observerDesignPatternExmpl();

	/** Section 17: Hello � RxJava **/

	/* Hello RxJava simple Example */
	public void helloRxJavaExmpl();

	/* Observable and Observer Example */
	public void observableObserverExmpl();

	/* various method to create Observable */
	public void createObservableExmples();

	/* create Observer example */
	public void createObserverExampl();

	/* Cold and Hot Observable Example */
	public void coldObservableExmpl();

	/* ConnectableObservable(transform cold to Hot) Example with Hot Observable */
	public void connectableObservableExmpl() throws InterruptedException;

	/* Observable variant Example */
	public void observableVariantExample();

	/* Dispose basic example */
	public void disposeExmple() throws InterruptedException;

	/** Section 19: RxJava Operators **/

	/* Operator basic example */
	public void basicOperatorExmpl();

	/* Operator in action example */
	public void operationInActionExmmpl(final List<Employee> list);

	/** Section 20: Combining RxJava 3 Observables **/

	/* Merging and concatenating Example */
	public void mergingAndConcatenatingExmpl() throws InterruptedException;

	/* flatMap() V/s concatMap() Example */
	public void flatMapConcatMapExmlp() throws InterruptedException;

	/* Disposing Of Duplicate Emitting Sources : amb() Example */
	public void disposingAmbExmpl() throws InterruptedException;

	/* zip() V/s combineLatest()Example */
	public void zipCombinLatestExmpl() throws InterruptedException;

	/* Grouping And Grouped Observable */
	public void groupingGroupedObserExmpl(List<Employee> list);

	/** Section 21: Concurrency And Parallelization **/

	/*
	 * Concurrency Basic Example in java, all observer use different thread to
	 * execute the Observable
	 */
	public void concurrencyInRxExmpl();

	/*
	 * Schedulers(ComputationScheduler) Basic Example it use no of CUP/4/x for no of
	 * thread
	 */
	public void computationSchedulerExmpl() throws InterruptedException;

	/* Schedulers(ioScheduler) Basic Example it use no of thread as u have guided */
	public void ioSchedulerExmpl() throws InterruptedException;

	/*
	 * Schedulers(NewThreadScheduler) Basic Example it create new thread every time
	 */
	public void newThreadSchedulerExmpl() throws InterruptedException;

	/*
	 * Schedulers(SingleThreadScheduler) Basic Example it use single thread for all
	 */
	public void singleThreadSchedulerExmpl() throws InterruptedException;

	/*
	 * Schedulers(CustomScheduler) Basic Example it up to you for no of Thread using
	 * ExecutorService
	 */
	public void customThreadSchedulerExmpl() throws InterruptedException;

	/* subscribeOn() / observeOn() Basic Example */
	public void subscribeOnObserveOnBasicExmpl() throws InterruptedException;

	/* flatMap() To Achieve Concurrency */
	public void flatMapUseInConcurrencyExmpl() throws InterruptedException;

	/** Section 22: Subjects, Replaying and Caching in RxJava 3.x **/

	/* Replay in Rx java basic example */
	public void replayBasicExmpl() throws InterruptedException;

	/* Cache in Rx java basic example */
	public void cacheBasicExmpl() throws InterruptedException;

	/* Subject Demo Example */
	public void subjectDemoExmpl() throws InterruptedException;

	/* Subject Basic Example it behaves/act like both Observable and observer */
	public void subjectBasicExample() throws InterruptedException;

	/* Subject implementation, different types of subject */
	public void subjectImplementationSubjectExmp() throws InterruptedException;

	/* it emits all the items from source observable */
	public void replaySubjectExmp() throws InterruptedException;

	/*
	 * it emits most recent item with the subsequent items of the source observable
	 * from point of subscription, just like missing one previous step in Demo
	 */
	public void behaviorSubjectExmp() throws InterruptedException;

	/* it emits only last value of source observable after onComplete invocation */
	public void uniCastSubjectExmp() throws InterruptedException;

	/*
	 * it buffers all the emissions received by the source until an observer
	 * subscribe to it
	 */
	public void asyncSubjectExmp() throws InterruptedException;

	/** Section 23: Buffering, Throttling and Switching **/

	/* Basic example of BUffering operator */
	public void bufferOpratorExmpl() throws InterruptedException;

	/*
	 * yild observable of observables ie group of observable, emits emission
	 * immediately as soon as they become available
	 */
	public void windowOperatorExmpl() throws InterruptedException;

	/* Basic operation on Throttling */
	public void throttlingOperationExmpl() throws InterruptedException;

	/* Basic swithMap operation, it switch on every dispose action */
	public void switchMapOperationExmpl() throws InterruptedException;

	/** Section 24: Flowable and BackPressure - Reactive Streams Implementation **/

	/* Producer-Consumer Problem - Obseervable Need Of Backpressure */
	public void producerConsumerObserable() throws InterruptedException;

	/* Producer-Consumer Problem - Flowable Need Of Backpressure */
	public void producerConsumerFlowable() throws InterruptedException;

	/* Flowable Creation with subscribe Example */
	public void flowableCreationExmpl() throws InterruptedException;

	/* � BackPressure With Flowable-Subscriber */
	public void backPressureFlowableSubscriber() throws InterruptedException;

	/* Observable and Flowable conversion Example */
	public void observableFlowableConversion() throws InterruptedException;
	
}
