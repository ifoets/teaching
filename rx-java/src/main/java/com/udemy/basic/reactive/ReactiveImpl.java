package com.udemy.basic.reactive;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import com.udemy.basic.reactive.demo.EndUser;
import com.udemy.basic.reactive.model.Book;
import com.udemy.basic.reactive.model.Employee;
import com.udemy.basic.reactive.rinterface.ICallBack;
import com.udemy.basic.reactive.rinterface.IPushCallBack;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import io.reactivex.rxjava3.subjects.Subject;
import io.reactivex.rxjava3.subjects.UnicastSubject;

public class ReactiveImpl implements IReactive {

	/**
	 * Section 16: Reactive Programming an Introduction
	 * 
	 * @throws InterruptedException
	 **/

	/* Fundamentals 2 -CallBack Hell Example */
	@Override
	public void callBackHellExmpl() throws InterruptedException {
		System.out.println("Main thread is running");

		Runnable r = new Runnable() {
			@Override
			public void run() {
				new ReactiveImpl().runningAsyc(new ICallBack() {
					@Override
					public void call() {
						System.out.println("CallBack get Called");
					}
				});
			}
		};

		Thread t = new Thread(r);
		t.start();
		Thread.sleep(2000);
		System.out.println("Main Thread completed");
	}

	@Override
	public void runningAsyc(ICallBack callback) {
		System.out.println("I am running in seperate thread");
		sleep(1000);
		callback.call();
	}

	@Override
	public void sleep(int duration) {
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/* Fundamentals 3 -Push CallBack Example */
	@Override
	public void pushCallBackExmpl() throws InterruptedException {
		System.out.println("Main thread is running");

		Runnable r = new Runnable() {
			@Override
			public void run() {
				new ReactiveImpl().runningAsyc(new IPushCallBack() {
					@Override
					public void pushData(String data) {
						System.out.println("CallBack data :" + data);
					}

					@Override
					public void pushComplete() {
						System.out.println("Callback done !");

					}

					@Override
					public void pushError(Exception ex) {
						System.out.println("Callback Error called, Got an Exception :" + ex);
					}
				});
			}
		};

		Thread t = new Thread(r);
		t.start();
		Thread.sleep(2000);
		System.out.println("Main Thread completed");
	}

	@Override
	public void runningAsyc(IPushCallBack callback) {
		System.out.println("I am running in saperate thread");
		sleep(1000);
		callback.pushData("Data1");
		callback.pushData("Data2");
		callback.pushData("Data3");

		callback.pushError(new RuntimeException("Oops!"));
		callback.pushComplete();
	}

	/* Fundamentals 4 -Observer Design Pattern */
	@SuppressWarnings("unused")
	@Override
	public void observerDesignPatternExmpl() {
		Book book = new Book("Goosebumps", "Horror", "Xyz", 200, "SoldOut");

		EndUser user1 = new EndUser("Bob", book);
		EndUser user2 = new EndUser("Rob", book);

		book.unsubscribeObserver(user2);
		System.out.println(book.getInStock());

		book.setInStock("In Stock");
	}

	/* Hello RxJava simple Example */
	@Override
	public void helloRxJavaExmpl() {

		// emitting the events by source Observable
		Observable<String> source = Observable.create(e ->
			{
				e.onNext("Hello");
				e.onNext("Rx-Java");
			});

		// detecting the emission by Observer and doing some operation on that
		source.subscribe(e -> System.out.println("Obsrver 1: + " + e));
		source.subscribe(e -> System.out.println("Observer 2: " + e));
	}

	/* Observable and Observer Example */
	@Override
	public void observableObserverExmpl() {

		Observable<Integer> source = new ObservableCreate<>(new ObservableOnSubscribe<Integer>() {

			@Override
			public void subscribe(@NonNull ObservableEmitter<@NonNull Integer> emitter) throws Throwable {
				try {
					emitter.onNext(10);
					emitter.onNext(11);
					emitter.onNext(12);
					emitter.onComplete();
				} catch (Throwable t) {
					emitter.onError(t);
				}

			}
		});

		Observer<Integer> observer = new Observer<Integer>() {

			@Override
			public void onSubscribe(@NonNull Disposable d) {
				System.out.println("Subscribed");

			}

			@Override
			public void onNext(@NonNull Integer t) {
				System.out.println("On Next:- " + t);

			}

			@Override
			public void onError(@NonNull Throwable e) {
				e.printStackTrace();
			}

			@Override
			public void onComplete() {
				System.out.println("Completed");

			}
		};
		source.subscribe(observer);
	}

	/* various method to create Observable */
	@Override
	public void createObservableExmples() {
		// create()
		Observable<Integer> source = Observable.create(

		        e ->
			        {
				        e.onNext(10);
				        e.onNext(11);
				        e.onNext(12);
				        e.onComplete();
			        });

		source.subscribe(System.out::println);

		// just()
		Observable<Integer> just = Observable.just(1, 2, 3);
		just.subscribe(System.out::println);

		// fromIterable
		// List<String> list = List.of("Ram", "Shyam", "Mike");
		List<String> list = new ArrayList<>();
		list.add("Ram");
		list.add("Shyam");

		@NonNull
		Observable<String> fromIterable = Observable.fromIterable(list);
		list.add("Rahin");
		fromIterable.subscribe(System.out::println);
	}

	/* create Observer example */
	@Override
	public void createObserverExampl() {
		Observable<String> source = Observable.just("Orange", "Black", "Red");

		source.subscribe(i -> System.out.println(i), Throwable::printStackTrace,
		        () -> System.out.println("Completed!"));

		System.out.println("--------X------X-------");
		source.subscribe(i -> System.out.println(i), Throwable::printStackTrace);

		System.out.println("--------X----------X--------");
		source.subscribe(i -> System.out.println(i));
	}

	/* Cold and Hot Observable Example */
	@Override
	public void coldObservableExmpl() {
		List<Integer> list = new ArrayList<>();

		list.add(16);
		list.add(17);
		list.add(18);

		Observable<Integer> source = Observable.fromIterable(list);
		source.subscribe(System.out::println);
		System.out.println("--------X-----------X-------");
		list = getData(list);
		source.subscribe(System.out::println);

	}

	private static List<Integer> getData(List<Integer> list) {
		list.add(19);
		return list;
	}

	/* ConnectableObservable(transform cold to Hot) Example with Hot Observable */
	@Override
	public void connectableObservableExmpl() throws InterruptedException {
		io.reactivex.rxjava3.observables.@NonNull ConnectableObservable<@NonNull Long> source = Observable
		        .interval(1, TimeUnit.SECONDS)
		        .publish();

		source.connect();

		source.subscribe(e -> System.out.println("Sub1- " + e));

		Thread.sleep(10000);
		System.out.println("---------X--------X---------");

		source.subscribe(e -> System.out.println("Sub2- " + e));

		Thread.sleep(10000);
	}

	/* Observable variant Example */
	@Override
	public void observableVariantExample() {
		Observable<String> source = Observable.just("Alex", "Justin", "Jack");
		Observable<String> source1 = Observable.empty();

		source.first("Name")
		        .subscribe(System.out::println);

		Single.just("Alex")
		        .subscribe(System.out::println);

		source.firstElement()
		        .subscribe(System.out::println, e -> e.printStackTrace(), () -> System.out.println("Completed"));

		Completable completable = Completable.complete();

		System.out.println("--------------------X-----------------X------------------");

		completable.subscribe(() -> System.out.println("Completed"));

		Completable.fromRunnable(() -> System.out.println("Some process executing"))
		        .subscribe(() -> System.out.println("The process executed succesfully"));

		System.out.println("--------------------X-----------------X------------------");

		source1.first("Name")
		        .subscribe(System.out::println);
		source1.firstElement()
		        .subscribe(System.out::println, e -> e.printStackTrace(), () -> System.out.println("Completed"));

	}

	/* Dispose basic example */
	@Override
	public void disposeExmple() throws InterruptedException {
		CompositeDisposable disp = new CompositeDisposable();
		@NonNull
		Observable<Long> src = Observable.interval(1, TimeUnit.SECONDS);

		@NonNull
		Disposable d1 = src.subscribe(e -> System.out.println("Observer 1 : " + e));
		Disposable d2 = src.subscribe(e -> System.out.println("Observer 2 : " + e));

		Thread.sleep(5000);
		disp.addAll(d1, d2);

		disp.dispose();
		Thread.sleep(10000);
	}

	/** Section 19: RxJava Operators **/

	/* Operator basic example */
	@Override
	public void basicOperatorExmpl() {

		Observable.just(60, 57, 89, 90, 25, 97, 100)
		        .filter(e -> e > 75)
		        .sorted()
		        .subscribe(e -> System.out.println("Grad A with Marks :-" + e));
		/*
		 * Exp- filter is Observer for Observable.just(60, 57, 89, 90, 25, 97, 100)
		 * sorted is Observer for produced Observable by.filter(e -> e > 75) subscribe
		 * is Observer for produced Observable by sorted
		 */
	}

	/* Operator in action example */
	@Override
	public void operationInActionExmmpl(final List<Employee> list) {

		Observable<Employee> obs = Observable.fromIterable(list);
		obs.filter(e -> e.getRating() > 4) // collect rating >4
		        .sorted((e1, e2) -> Double.compare(e2.getRating(), e1.getRating())) // sort in DEC order
		        .map(e -> e.getName())// collect only name
		        .take(4) // collect the first 4
		        // .toList() //collect in list
		        .subscribe(System.out::println);
	}

	/* Merging and concatenating Example */
	@Override
	public void mergingAndConcatenatingExmpl() throws InterruptedException {
		// this is Synk so see sequential result
		// Observable<String> src1 = Observable.just("Ella","Alexa","Lily");
		// Observable<String> src2 = Observable.just("Priya","Chloe");

		// Here Asnyk 2 different thread running parallly and can see result
		Observable<String> src1 = Observable.interval(1, TimeUnit.SECONDS)
		        .map(e -> "src1 : " + e)
		        .take(5);
		Observable<String> src2 = Observable.interval(1, TimeUnit.SECONDS)
		        .map(e -> "src2 : " + e);
		// Observable.merge(src1, src2).subscribe(System.out::println);
		// Observable.concat(src1, src2)
		// .subscribe(e -> System.out.println("Received : "+ e));

		src1.concatWith(src2)
		        .subscribe(e -> System.out.println("Received : " + e));
		Thread.sleep(10000);
	}

	/* flatMap() V/s concatMap() Example */
	@Override
	public void flatMapConcatMapExmlp() throws InterruptedException {
		List<String> list = List.of("Hello", "Reactive", "Programming");
		Observable.fromIterable(list)
		        .flatMap(e -> Observable.fromArray(e.split("")))
		        .subscribe(e -> System.out.print(e + " "));

		System.out.println("\n------------------X------------X------------------");
		// this not gives proper result since Synk, need to Asynk ie by 2 different
		// thread
		Observable.fromIterable(list)
		        .concatMap(e -> Observable.fromArray(e.split("")))
		        .subscribe(e -> System.out.print(e + " "));
	}

	/* Disposing Of Duplicate Emitting Sources : amb() Example */
	@Override
	public void disposingAmbExmpl() throws InterruptedException {
		Observable<String> ob1 = Observable.interval(1, TimeUnit.SECONDS)
		        .take(10)
		        .map(e -> "Ob 1 :" + e);
		Observable<String> ob2 = Observable.interval(10, TimeUnit.MILLISECONDS)
		        .take(10)
		        .map(e -> "Ob 2 :" + e);

		Observable.amb(Arrays.asList(ob1, ob2))
		        .subscribe(System.out::println);

		Thread.sleep(11000);
	}

	/* zip() V/s combineLatest()Example */
	@Override
	public void zipCombinLatestExmpl() throws InterruptedException {
		Observable<Long> src1 = Observable.interval(200, TimeUnit.MILLISECONDS)
		        .take(5);

		Observable<Long> src2 = Observable.interval(1, TimeUnit.SECONDS)
		        .take(5);

		// Observable.zip(src1, src2, (e1, e2) -> "Source 1 : " + e1 + " Source 2: " +
		// e2).subscribe(System.out::println);

		Observable.combineLatest(src1, src2, (e1, e2) -> "Source 1 : " + e1 + " Source 2: " + e2)
		        .subscribe(System.out::println);

		Thread.sleep(20000);
	}

	/* Grouping And Grouped Observable */
	@Override
	public void groupingGroupedObserExmpl(List<Employee> list) {
		Observable<Employee> obs = Observable.fromIterable(list);

		// obs.groupBy(e -> e.getRating()).flatMapSingle(e ->
		// e.toList()).subscribe(System.out::println);
		obs.groupBy(e -> e.getRating())
		        .flatMapSingle(e -> e.toMultimap(key -> e.getKey(), emp -> emp.getName()))
		        .subscribe(System.out::println);
	}

	/** Section 21: Concurrency And Parallelization **/

	/*
	 * Concurrency Basic Example in java, all observer use different thread to
	 * execute the Observable
	 */
	@Override
	public void concurrencyInRxExmpl() {
		Observable<String> source = Observable.create(

		        e ->
			        {
				        new Thread(() ->
					        {
						        e.onNext("Hello");
						        e.onNext("RxJava");
					        }).start();
			        });

		source.subscribe(e -> System.out.println("Observer 1 :" + e + " Thread is :" + Thread.currentThread()
		        .getName()));

		source.subscribe(e -> System.out.println("Observer 2 :" + e + " Thread is :" + Thread.currentThread()
		        .getName()));
	}

	/* Schedulers(ComputationScheduler) Basic Example */
	@Override
	public void computationSchedulerExmpl() throws InterruptedException {
		Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
		        .subscribeOn(Schedulers.computation()); // it automatic get threads=no of CUP

		src.subscribe(e -> compute());
		src.subscribe(e -> compute());
		src.subscribe(e -> compute());
		src.subscribe(e -> compute());
		src.subscribe(e -> compute());

		Thread.sleep(50000);

	}

	public static void compute() throws InterruptedException {

		Thread.sleep(1000);
		System.out.println("Computation Done By : " + Thread.currentThread()
		        .getName());
	}

	/*
	 * Schedulers(ComputationScheduler) Basic Example it use no of thread as u have
	 * guided
	 */
	@Override
	public void ioSchedulerExmpl() throws InterruptedException {
		Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
		        .subscribeOn(Schedulers.io());

		src.subscribe(e -> ioOeration());

		Thread.sleep(6000);

		src.subscribe(e -> ioOeration());
		src.subscribe(e -> ioOeration());
		src.subscribe(e -> ioOeration());
		src.subscribe(e -> ioOeration());
		src.subscribe(e -> ioOeration());

		Thread.sleep(500000);
	}

	public static void ioOeration() throws InterruptedException {

		Thread.sleep(1000);
		System.out.println("Computation Done By : " + Thread.currentThread()
		        .getName());
	}

	/*
	 * Schedulers(newThreadScheduler) Basic Example it create new thread every time
	 */
	@Override
	public void newThreadSchedulerExmpl() throws InterruptedException {
		Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
		        .subscribeOn(Schedulers.newThread());

		src.subscribe(e -> task());

		Thread.sleep(6000);
		src.subscribe(e -> task());
		src.subscribe(e -> task());
		src.subscribe(e -> task());
		src.subscribe(e -> task());

		Thread.sleep(500000);
	}

	public static void task() throws InterruptedException {

		Thread.sleep(1000);
		System.out.println("Computation Done By : " + Thread.currentThread()
		        .getName());
	}

	/*
	 * Schedulers(SingleThreadScheduler) Basic Example it use single thread for all
	 */
	@Override
	public void singleThreadSchedulerExmpl() throws InterruptedException {
		Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
		        .subscribeOn(Schedulers.single());

		src.subscribe(e -> sensitiveTask());
		src.subscribe(e -> sensitiveTask());
		src.subscribe(e -> sensitiveTask());
		src.subscribe(e -> sensitiveTask());
		src.subscribe(e -> sensitiveTask());
		src.subscribe(e -> sensitiveTask());

		Thread.sleep(500000);
	}

	public static void sensitiveTask() throws InterruptedException {

		Thread.sleep(1000);
		System.out.println("Computation Done By : " + Thread.currentThread()
		        .getName());
	}

	/*
	 * Schedulers(CustomScheduler) Basic Example it up to you for no of Thread using
	 * ExecutorService
	 */
	@Override
	public void customThreadSchedulerExmpl() throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(20);

		@NonNull
		Scheduler scheduler = Schedulers.from(executor);

		Observable<String> src = Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
		        .subscribeOn(scheduler)
		        .doFinally(executor::shutdown);// u required to shutdown other wise it running

		src.subscribe(e -> compute());
		src.subscribe(e -> compute());
		src.subscribe(e -> compute());
		src.subscribe(e -> compute());
		src.subscribe(e -> compute());
		src.subscribe(e -> compute());

		Thread.sleep(10000);
	}

	/* subscribeOn() / observeOn() Basic Example */
	@Override
	public void subscribeOnObserveOnBasicExmpl() throws InterruptedException {

		Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
		        .subscribeOn(Schedulers.computation())
		        .map(e -> e.toUpperCase())
		        .doOnNext(e -> System.out.println(Thread.currentThread()
		                .getName()))
		        .observeOn(Schedulers.newThread())
		        .filter(e -> e.startsWith("P"))
		        .observeOn(Schedulers.io())
		        .subscribe(e -> System.out.println(e));

		Thread.sleep(6000);
	}

	/* flatMap() To Achieve Concurrency */
	public void flatMapUseInConcurrencyExmpl() throws InterruptedException {
		Observable.just("Pasta", "Pizza", "Fries", "Curry", "Chow mein")
		        .flatMap(e -> Observable.just(e)
		                .subscribeOn(Schedulers.computation())
		                .map(str -> compute(str)))
		        .subscribe(System.out::println);

		Thread.sleep(7000);
	}

	public static String compute(String element) throws InterruptedException {

		String s = element + " : Printed By : " + Thread.currentThread()
		        .getName() + " at : " + LocalTime.now();
		return s;
	}

	/** Section 22: Subjects, Replaying and Caching in RxJava 3.x **/
	/*
	 * Replay in Rx java basic example , it replay based on function used to other
	 * observer downstream
	 */
	@Override
	public void replayBasicExmpl() throws InterruptedException {

		@NonNull
		Observable<@NonNull Long> src = Observable.interval(1, TimeUnit.SECONDS)
		        // .replay()//replay from initial emission
		        // .replay(x)//replay from x previous emission
		        //// .replay(x y, TimeUnit.SECONDS) replay x emission fromm last y emission
		        .replay(2, 4, TimeUnit.SECONDS)
		        .autoConnect();// autoConnect when we want to connect it is not in chache
		src.subscribe(e -> System.out.println("Observer 1 : " + e));

		Thread.sleep(5000);
		src.subscribe(e -> System.out.println("Observer 2 : " + e));

		Thread.sleep(3000);
	}

	/*
	 * Cache in Rx java basic example it cache all previous emission and reply for
	 * all downstream observers
	 */
	@Override
	public void cacheBasicExmpl() throws InterruptedException {
		@NonNull
		Observable<@NonNull Long> src = Observable.interval(1, TimeUnit.SECONDS)
		        .cache();

		src.subscribe(e -> System.out.println("Observer 1 : " + e));
		Thread.sleep(5000);
		src.subscribe(e -> System.out.println("Observer 2 : " + e));
		Thread.sleep(3000);
	}

	/* Subject Demo Example */
	public void subjectDemoExmpl() throws InterruptedException {
		@NonNull
		PublishSubject<String> subject = PublishSubject.create();
		@NonNull
		Subject<String> serialized = subject.toSerialized(); // Thread safe

		serialized.subscribe(e -> System.out.println("Observer 1 " + e));
		serialized.subscribe(e -> System.out.println("Observer 2 " + e));

		serialized.onNext("Hello");
		serialized.onNext("BasicsStrong");
		serialized.onComplete();// no emission except after complete
		serialized.onNext("BasicsStrong");
	}

	/* Subject Basic Example it behaves/act like both Observable and observer */
	@Override
	public void subjectBasicExample() throws InterruptedException {
		@NonNull
		Observable<Integer> src1 = Observable.just(5, 10, 15, 20)
		        .subscribeOn(Schedulers.computation());
		Observable<Integer> src2 = Observable.just(50, 100, 150, 200)
		        .subscribeOn(Schedulers.computation());

		// src1.subscribe(e -> System.out.println(e));
		// src2.subscribe(e -> System.out.println(e));

		@NonNull
		Subject<Object> subject = PublishSubject.create();

		subject.subscribe(e -> System.out.println(e)); // Observer 1
		subject.subscribe(e -> System.out.println("The Eleemnt is :-" + e)); // Observer 2
		// newly added emission also get and it execute first even
		subject.onNext("Hello");
		subject.onNext("BasicsStrong");

		src1.subscribe(subject); // source 1
		src2.subscribe(subject); // source 2

		Thread.sleep(9000);
	}

	/* Subject implementation, different types of subject */
	@Override
	public void subjectImplementationSubjectExmp() throws InterruptedException {
		/* can't get previously emitted data like television */
		Subject<String> subject = PublishSubject.create();

		Thread.sleep(2000);
		subject.subscribe(e -> System.out.println("Subscriber 1: " + e));
		Thread.sleep(2000);
		subject.onNext("a");
		subject.onNext("b");
		subject.onNext("c");

		subject.subscribe(e -> System.out.println("Subscriber 2: " + e));

		subject.onNext("d");
		subject.onNext("e");
		subject.onComplete();
	}

	/*
	 * it emits all the items from source observable regardless of when the
	 * subscriber subscribe
	 */
	@Override
	public void replaySubjectExmp() throws InterruptedException {
		/* can't get all previously emitted data like youtube */
		Subject<String> subject = ReplaySubject.create();

		Thread.sleep(2000);
		subject.subscribe(e -> System.out.println("Subscriber 1: " + e));
		Thread.sleep(2000);
		subject.onNext("a");
		subject.onNext("b");
		subject.onNext("c");

		subject.subscribe(e -> System.out.println("Subscriber 2: " + e));

		subject.onNext("d");
		subject.onNext("e");
		subject.onComplete();
	}

	/*
	 * it emits most recent item with the subsequent items of the source observable
	 * from point of subscription, just like missing one previous step in Demo
	 */
	@Override
	public void behaviorSubjectExmp() throws InterruptedException {
		/* can't get one previously emitted data like Demo */
		Subject<String> subject = BehaviorSubject.create();

		Thread.sleep(2000);
		subject.subscribe(e -> System.out.println("Subscriber 1: " + e));
		Thread.sleep(2000);
		subject.onNext("a");
		subject.onNext("b");
		subject.onNext("c");

		subject.subscribe(e -> System.out.println("Subscriber 2: " + e));

		subject.onNext("d");
		subject.onNext("e");
		subject.onComplete();
	}

	/* it emits only last value of source observable after onComplete invocation */
	@Override
	public void asyncSubjectExmp() throws InterruptedException {
		/* can get only the last emits on every subscriber/observers */
		Subject<String> subject = AsyncSubject.create();

		Thread.sleep(2000);
		subject.subscribe(e -> System.out.println("Subscriber 1: " + e));
		Thread.sleep(2000);
		subject.onNext("a");
		subject.onNext("b");
		subject.onNext("c");

		subject.subscribe(e -> System.out.println("Subscriber 2: " + e));

		subject.onNext("d");
		subject.onNext("e");
		subject.onComplete();
	}

	/* it emits only last value of source observable after onComplete invocation */
	@Override
	public void uniCastSubjectExmp() throws InterruptedException {
		/* it keep the buffered and subscribed all buffered at a time */
		Subject<Long> subject = UnicastSubject.create();

		Observable.interval(500, TimeUnit.MILLISECONDS)
		        .subscribe(subject);
		Thread.sleep(2000);
		subject.subscribe(e -> System.out.println("Subscriber 1: " + e));
		Thread.sleep(2000);
	}

	/** Section 23: Buffering, Throttling and Switching **/

	/* Basic example of BUffering operator */
	@Override
	public void bufferOpratorExmpl() throws InterruptedException {
		// buffer(x) meas chunk of X element, buffer(x,y) means chunk of x in each y
		// buffer(x,HashSet::new) get set of x chunk
		Observable.range(1, 30)
		        .buffer(4, 5)
		        .subscribe(System.out::println);

		System.out.println("----------X--------------X----------");
		// when ever reach to 1 second
		// get chunk of buffered
		// emission
		Observable.interval(500, TimeUnit.MILLISECONDS)
		        .buffer(1, TimeUnit.SECONDS, 2)
		        .subscribe(System.out::println);
		Thread.sleep(4000);
		System.out.println("----------X--------------X----------");
		@NonNull
		Observable<Long> interval = Observable.interval(500, TimeUnit.MILLISECONDS);

		Observable.interval(1000, TimeUnit.MILLISECONDS)
		        .buffer(interval)
		        .subscribe(System.out::println);

		Thread.sleep(4000);

	}

	/*
	 * yild obserable of observables ie group of observable, emits emission
	 * immediately as soon as they become available
	 */
	@Override
	public void windowOperatorExmpl() throws InterruptedException {
		@NonNull
		Observable<Long> interval = Observable.interval(500, TimeUnit.MILLISECONDS);

		Observable.interval(1000, TimeUnit.MILLISECONDS)
		        .window(interval)
		        .subscribe(System.out::println);

		Thread.sleep(8000);
	}

	/* Basic operation on Throttling */
	@Override
	public void throttlingOperationExmpl() throws InterruptedException {
		Observable<String> obs = Observable.create(emitter ->
			{
				emitter.onNext("A");

				Thread.sleep(200);
				emitter.onNext("B");

				Thread.sleep(100);
				emitter.onNext("C");

				Thread.sleep(400);
				emitter.onNext("D");

				Thread.sleep(300);
				emitter.onNext("E");

				Thread.sleep(800);
				emitter.onNext("F");

				Thread.sleep(900);
				emitter.onNext("X");

				Thread.sleep(600);
				emitter.onNext("Y");

				Thread.sleep(1000);
				emitter.onNext("Z");

				emitter.onComplete();
			});

		obs.throttleFirst(1000, TimeUnit.MILLISECONDS)
		        .subscribe(item -> System.out.println("onNext: " + item), Throwable::printStackTrace,
		                () -> System.out.println("onComplete"));
		Thread.sleep(2000);
		// obs.throttleLast or obs.sample alias
		obs.sample(100, TimeUnit.MILLISECONDS)
		        .subscribe(item -> System.out.println("onNext: " + item), Throwable::printStackTrace,
		                () -> System.out.println("onComplete"));
		Thread.sleep(2000);
		// obs.ThrotalWithtimout or obs.debounce alis
		obs.debounce(700, TimeUnit.MILLISECONDS)
		        .subscribe(item -> System.out.println("onNext: " + item), Throwable::printStackTrace,
		                () -> System.out.println("onComplete"));
	}

	/* Basic swithMap operation, it switch on every dispose action */
	@Override
	public void switchMapOperationExmpl() throws InterruptedException {
		Observable<String> source = Observable.just("John", "Lily", "Emma", "Reyan", "Darshin")
		        .concatMap(s -> Observable.just(s)
		                .delay(ThreadLocalRandom.current()
		                        .nextInt(1000), TimeUnit.MILLISECONDS));

		Observable.interval(2, TimeUnit.SECONDS)
		        .switchMap(s -> source.doOnDispose(() -> System.out.println("Disposing and starting again!")))
		        .subscribe(System.out::println);

		Thread.sleep(10000);
	}

	/* Producer-Consumer Problem - Need Of Backpressure */
	@Override
	public void producerConsumerObserable() throws InterruptedException {

		Observable.range(1, 10000)
		        .map(e ->
			        {
				        System.out.println("Produce item-: " + e + " : " + Thread.currentThread()
				                .getName());
				        return e;
			        })
		        .observeOn(Schedulers.io())
		        .subscribe(e ->
			        {
				        Thread.sleep(100);
				        System.out.println("Consume item- " + e + " : " + Thread.currentThread()
				                .getName());
			        });

		Thread.sleep(100000);
	}

	/* Producer-Consumer Problem - Flowable Need Of Backpressure */
	@Override
	public void producerConsumerFlowable() throws InterruptedException {
		Observable.range(1, 1000000)
		        .map(e ->
			        {
				        System.out.println("Produce item-: " + e + " : " + Thread.currentThread()
				                .getName());
				        return e;
			        })
		        .observeOn(Schedulers.io())
		        .subscribe(e ->
			        {
				        // Thread.sleep(100);
				        System.out.println("Consume item- " + e + " : " + Thread.currentThread()
				                .getName());
			        });

		Thread.sleep(100000);
	}

	/* Flowable Creation with subscribe Example */
	@Override
	public void flowableCreationExmpl() throws InterruptedException {
		Flowable.create(emitter ->
			{
				for (int i = 0; i <= 5000; i++) {
					if (emitter.isCancelled())
						return;
					emitter.onNext(i);
				}

				emitter.onComplete();
			}, BackpressureStrategy.BUFFER)
		        .observeOn(Schedulers.io())
		        .subscribe(System.out::println);

		Thread.sleep(2000);
	}

	/* BackPressure With Flowable-Subscriber */
	@Override
	public void backPressureFlowableSubscriber() throws InterruptedException {

		Flowable.range(1, 1000000)
		        .map(e ->
			        {
				        System.out.println("Produced item is : " + e + " : " + Thread.currentThread()
				                .getName());
				        return e;
			        })
		        .observeOn(Schedulers.io())
		        .subscribe(new Subscriber<Integer>() {

			        Subscription s;
			        AtomicInteger count = new AtomicInteger(0);

			        @Override
			        public void onSubscribe(Subscription s) {
				        this.s = s;
				        System.out.println("Asking for 20 items");
				        s.request(20);

			        }

			        @Override
			        public void onNext(Integer t) {

				        if (count.getAndIncrement() % 20 == 0) {
					        System.out.println("Asking for next 20 items ");
					        s.request(20);
				        }
				        System.out.println("The subscriber consumed : " + t);
				        sleep(100);
			        }

			        @Override
			        public void onError(Throwable t) {
				        t.printStackTrace();
			        }

			        @Override
			        public void onComplete() {
				        System.out.println("Completed");
			        }
		        }

				);

		sleep(100000000);
	}

	/* Observable and Flowable conversion Example */
	@Override
	public void observableFlowableConversion() throws InterruptedException {

		Flowable.range(1, 100)
		        .toObservable()
		        .observeOn(Schedulers.io())
		        .subscribe(e -> System.out.println(e + " " + Thread.currentThread()
		                .getName()));

		Observable.range(1, 100)
		        .toFlowable(BackpressureStrategy.BUFFER)
		        .observeOn(Schedulers.io())
		        .subscribe(e -> System.out.println(e + " " + Thread.currentThread()
		                .getName()));

		Thread.sleep(5000);
	}
}
