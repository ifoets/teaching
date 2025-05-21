package com.udemy.basic.reactive;

import org.junit.Before;
import org.junit.Test;

import com.udemy.basic.reactive.input.utils.RxInputUtils;

public class IReactiveTest {

	IReactive ir = null;

	@Before
	public void init() {
		ir = new ReactiveImpl();
	}

	/** Section 16: Reactive Programming an Introduction **/

	/* Fundamentals 2 -CallBack Hell Example */
	@Test
	public void callBackHellExmplTest() throws InterruptedException {
		ir.callBackHellExmpl();
	}

	/* Fundamentals 3 -Push CallBack Example */
	@Test
	public void pushCallBackExmplTest() throws InterruptedException {
		ir.pushCallBackExmpl();
	}

	/* Fundamentals 4 -Observer Design Pattern */
	@Test
	public void observerDesignPatternExmplTest() {
		ir.observerDesignPatternExmpl();
	}

	/* Hello RxJava simple Example */
	@Test
	public void helloRxJavaExmplTest() {
		ir.helloRxJavaExmpl();
	}

	/* Observable and Observer Example */
	@Test
	public void observableObserverExmplTest() {
		ir.observableObserverExmpl();
	}

	/* various method to create Observable */
	@Test
	public void createObservableExplesTest() {
		ir.createObservableExmples();
	}

	/* create Observer example */
	@Test
	public void createObserverExamplTest() {
		ir.createObserverExampl();
	}

	/* Cold and Hot Observable Example */
	@Test
	public void coldObservableExmplTest() {
		ir.coldObservableExmpl();
	}

	/* ConnectableObservable(transform cold to Hot) Example with Hot Observable */
	@Test
	public void connectableObservableExmplTest() throws InterruptedException {
		ir.connectableObservableExmpl();
	}

	/* Observable variant Example */
	@Test
	public void observableVariantExampleTest() {
		ir.observableVariantExample();
	}

	/* Dispose basic example */
	@Test
	public void disposeExmpleTest() throws InterruptedException {
		ir.disposeExmple();
	}

	/** Section 19: RxJava Operators **/

	/* Operator basic example */
	@Test
	public void basicOperatorExmplTest() {
		ir.basicOperatorExmpl();
	}

	/* Operator in action example */
	@Test
	public void operationInActionExmmplTest() {
		ir.operationInActionExmmpl(RxInputUtils.getEmployees());
	}

	/* Merging and concatenating Example */
	@Test
	public void mergingAndConcatenatingExmplTest() throws InterruptedException {
		ir.mergingAndConcatenatingExmpl();
	}

	/* flatMap() V/s concatMap() Example */
	@Test
	public void flatMapConcatMapExmlpTest() throws InterruptedException {
		ir.flatMapConcatMapExmlp();
	}

	/* Disposing Of Duplicate Emitting Sources : amb() Example */
	@Test
	public void disposingAmbExmplTest() throws InterruptedException {
		ir.disposingAmbExmpl();
	}

	/* zip() V/s combineLatest()Example */
	@Test
	public void zipCombinLatestExmplTest() throws InterruptedException {
		ir.zipCombinLatestExmpl();
	}

	/* Grouping And Grouped Observable */
	@Test
	public void groupingGroupedObserExmpl() throws InterruptedException {
		ir.groupingGroupedObserExmpl(RxInputUtils.getEmployees());
	}

	/** Section 21: Concurrency And Parallelization **/

	/*
	 * Concurrency Basic Example in java, all observer use different thread to
	 * execute the Observable
	 */
	@Test
	public void concurrencyInRxExmplTest() {
		ir.concurrencyInRxExmpl();
	}

	/* Schedulers(ComputationScheduler) Basic Example */
	@Test
	public void schedulersBasicExmplTest() throws InterruptedException {
		ir.computationSchedulerExmpl();
	}

	/*
	 * Schedulers(ComputationScheduler) Basic Example it use no of thread as u have
	 * guided
	 */
	@Test
	public void ioSchedulerExmplTest() throws InterruptedException {
		ir.ioSchedulerExmpl();
	}

	/*
	 * Schedulers(newThreadScheduler) Basic Example it create new thread every time
	 */
	@Test
	public void newThreadSchedulerExmplTest() throws InterruptedException {
		ir.newThreadSchedulerExmpl();
	}

	/*
	 * Schedulers(SingleThreadScheduler) Basic Example it use single thread for all
	 */
	@Test
	public void singleThreadSchedulerExmplTest() throws InterruptedException {
		ir.singleThreadSchedulerExmpl();
	}

	/*
	 * Schedulers(CustomScheduler) Basic Example it up to you for no of Thread using
	 * ExecutorService
	 */
	@Test
	public void customThreadSchedulerExmplTest() throws InterruptedException {
		ir.customThreadSchedulerExmpl();
	}

	/* subscribeOn() / observeOn() Basic Example */
	@Test
	public void subscribeOnObserveOnBasicExmplTest() throws InterruptedException {
		ir.subscribeOnObserveOnBasicExmpl();
	}

	/* flatMap() To Achieve Concurrency */
	@Test
	public void flatMapUseInConcurrencyExmplTest() throws InterruptedException {
		ir.flatMapUseInConcurrencyExmpl();
	}

	/** Section 22: Subjects, Replaying and Caching in RxJava 3.x **/
	/* Replay in Rx java basic example */
	@Test
	public void replayBasicExmplTest() throws InterruptedException {
		ir.replayBasicExmpl();
	}

	/*
	 * Cache in Rx java basic example it cache all previous emission and reply for
	 * all downstream observers
	 */
	@Test
	public void cacheBasicExmplTest() throws InterruptedException {
		ir.cacheBasicExmpl();
	}

	/* Subject Demo Example */
	@Test
	public void subjectDemoExmplTest() throws InterruptedException {
		ir.subjectDemoExmpl();
	}

	/* Subject Basic Example it behaves/act like both Observable and observer */
	@Test
	public void subjectBasicExampleTest() throws InterruptedException {
		ir.subjectBasicExample();
	}

	/* Subject implementation, different types of subject */
	@Test
	public void subjectImplementationSubjectExmpTest() throws InterruptedException {
		ir.subjectImplementationSubjectExmp();
	}

	/*
	 * it emits all the items from source observable regardless of when the
	 * subscriber subscribe
	 */
	@Test
	public void replaySubjectExmpTest() throws InterruptedException {
		ir.replaySubjectExmp();
	}

	/*
	 * it emits most recent item with the subsequent items of the source observable
	 * from point of subscription, just like missing one previous step in Demo
	 */
	@Test
	public void behaviorSubjectExmpTest() throws InterruptedException {
		ir.behaviorSubjectExmp();
	}

	/* it emits only last value of source observable after onComplete invocation */
	@Test
	public void asyncSubjectExmpTest() throws InterruptedException {
		ir.asyncSubjectExmp();
	}

	/* it emits only last value of source observable after onComplete invocation */
	@Test
	public void uniCastSubjectExmpTest() throws InterruptedException {
		ir.uniCastSubjectExmp();
	}

	/** Section 23: Buffering, Throttling and Switching **/

	/* Basic example of BUffering operator */
	@Test
	public void bufferOpratorExmplTest() throws InterruptedException {
		ir.bufferOpratorExmpl();
	}

	/*
	 * yild observable of observables ie group of observable, emits emission
	 * immediately as soon as they become available
	 */
	@Test
	public void windowOperatorExmplTest() throws InterruptedException {
		ir.windowOperatorExmpl();
	}

	/* Basic operation on Throttling */
	@Test
	public void throttlingOperationExmplTest() throws InterruptedException {
		ir.throttlingOperationExmpl();
	}

	/* Basic swithMap operation, it switch on every dispose action */
	@Test
	public void switchMapOperationExmpl() throws InterruptedException {
		ir.switchMapOperationExmpl();
	}

	/** Section 24: Flowable and BackPressure - Reactive Streams Implementation **/

	/* Producer-Consumer Problem - Need Of Backpressure */
	@Test
	public void producerConsumerObserableTest() throws InterruptedException {
		ir.producerConsumerObserable();
	}

	/* Producer-Consumer Problem - Flowable Need Of Backpressure */
	@Test
	public void producerConsumerFlowable() throws InterruptedException {
		ir.producerConsumerFlowable();
	}

	/* Flowable Creation with subscribe Example */
	@Test
	public void flowableCreationExmpl() throws InterruptedException {
		ir.flowableCreationExmpl();
	}

	/* BackPressure With Flowable-Subscriber */
	@Test
	public void backPressureFlowableSubscriberTest() throws InterruptedException {
		ir.backPressureFlowableSubscriber();
	}

	/* Observable and Flowable conversion Example */
	@Test
	public void observableFlowableConversion() throws InterruptedException {
		ir.observableFlowableConversion();
	}
}
