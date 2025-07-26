package rx.design.analysis.rx;

import io.reactivex.rxjava3.core.*;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.observers.TestObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.schedulers.TestScheduler;
import io.reactivex.rxjava3.subscribers.TestSubscriber;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rx.design.analysis.rx.model.MessageEvent;
import rx.design.analysis.rx.record.*;
import rx.design.analysis.rx.utils.RxDesignUtils;
import rx.design.analysis.rx.utils.RxUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class IRxJavaTest {

    IRxJava iRxJava;

    @Before
    public void init()
    {
        iRxJava = new RxJavaImpl();
    }

    /* *1.	What is RxJava and how does it work?
     * Ex- Async Data Flow + Operators,* Fetches a list of users,* For each user, fetches a list of orders* Flattens results each UserOrder
     */
    @Test
    public void getUserOrdersByThemTest() throws InterruptedException {
        Single<Map<User, List<Order>>> single= iRxJava.getUserOrdersByThem(RxUtils.getUsers());
        System.out.println(single.blockingGet());
        TestObserver<Map<User, List<Order>>> testObserver = single.test(); // subscribe using TestObserver

        testObserver.awaitDone(3,TimeUnit.SECONDS)
            .assertValue(map -> map.size() == 2
                && map.containsKey(new User("1", "Alice"))
                && map.get(new User("2", "Bob")).size() == 2
                && map.get(new User("1","Alice")).get(1).desc().equals("Order2 for Alice"));
    }

    /* *Beginner Level (Fundamentals - 20 questions)**/
    /**1.	Create an Observable from a list of strings.*/
    @Test
    public void fromListOfString()
    {
        Observable<String> observable = iRxJava.fromListOfString(List.of("A","B","C","D","E"));
        TestObserver<String> testObserver = observable.test();
        testObserver.awaitDone(1,TimeUnit.SECONDS)
            .assertValueCount(5)
            .assertValueAt(4,"E")
            .assertValueSequence(List.of("A","B","C","D","E"));
    }

    /**2.	Use map() to convert a list of integers to their squares.**/
    @Test
    public void toSquareTest()
    {
        Observable<Integer> observable = iRxJava.toSquare(List.of(0,1,2,3,4,5));
        TestObserver<Integer> testObserver = observable.test();

        testObserver.awaitDone(1,TimeUnit.SECONDS)
            .assertValueCount(6)
            .assertValueAt(3,9)
            .assertValueAt(5,25)
            .assertValueSequence(List.of(0,1,4,9,16,25));
    }


    /**3.	Use filter() to emit only even numbers.*/
    @Test
    public void emitEvenNoTest()
    {
        Observable<Integer> observable = iRxJava.emitEvenNo(List.of(0,1,2,3,4,5,6,7,8,9));
        TestObserver<Integer> testObserver = observable.test();

        testObserver.awaitDone(1,TimeUnit.SECONDS)
            .assertValueCount(5)
            .assertValueAt(3,6)
            .assertValueAt(4,8)
            .assertValueSequence(List.of(0,2,4,6,8));
    }

    /**4.	Use flatMap() to flatten a list of List<String>.*/
    @Test
    public void flattenListOfListTest()
    {
        Observable<String> observable = iRxJava.flattenListOfList(RxJavaDataUtils.getListOfString());
        TestObserver<String> testObserver = observable.test();

        testObserver.awaitDone(1,TimeUnit.SECONDS)
            .assertValueCount(5)
            .assertValueAt(4,"E")
            .assertValueSequence(List.of("A","B","C","D","E"));
    }

    /**5.	Convert a Single<List<String>> to Observable<String>.*/
    @Test
    public void fromSingleListTest()
    {
        Single<List<String>> single = Single.fromCallable(()-> List.of("A","B","C","D","E"));
        Observable<String> observable = iRxJava.fromSingleList(single);

        TestObserver<String> testObserver = observable.test();
        testObserver.awaitDone(1,TimeUnit.SECONDS)
            .assertValueCount(5)
            .assertValueAt(4,"E")
            .assertValueSequence(List.of("A","B","C","D","E"));
    }

    /**6.	Combine two Observable<Integer> using merge() and sort.*/
    @Test
    public void mergeObservableSorTest()
    {
        Observable<Integer> observable = iRxJava.mergeObservableSort(List.of(4,2,1), List.of(0,3,5));

        TestObserver<Integer> testObserver = observable.test();
        testObserver.awaitDone(1,TimeUnit.SECONDS)
            .assertValueCount(6)
            .assertValueAt(3,3)
            .assertValueAt(5,5)
            .assertValueSequence(List.of(0,1,2,3,4,5));
    }

    /**7.	Use zip() to pair items from two Observable*/
    @Test
    public void zipTwoObservableTest()
    {
        Observable<String> observable = iRxJava.zipTwoObservable(List.of("Abhi","Kumar","Suman"), List.of(40,41));

        TestObserver<String> testObserver = observable.test();
        testObserver.awaitDone(2,TimeUnit.SECONDS)
            .assertValueCount(2);
    }

    /**8.	Use buffer(3) to collect 3 items at a time assume sufficient items*/
    @Test
    public void bufferFixedItemsTest()
    {
        Observable<List<String>> observable = iRxJava.bufferFixedItems(List.of("A","B","C","D","E","F","G","H"),3);

        TestObserver<List<String>> testObserver = observable.test();
        testObserver.assertValueCount(3); // Should emit 3 lists: [A,B,C], [D,E,F], [G]

        testObserver.assertValueAt(0, list -> list.equals(List.of("A", "B", "C")));
        testObserver.assertValueAt(1, list -> list.equals(List.of("D", "E", "F")));
        testObserver.assertValueAt(2, list -> list.equals(List.of("G","H")));

        testObserver.assertComplete();
        testObserver.assertNoErrors();
    }

    /**9.	Use debounce() to ignore rapid emissions.*/
    @Test
    public void debounceIgnoreRapidEmissionTest()   {
        List<String> items = Arrays.asList("A", "B", "C", "D");
        List<Long> delays = Arrays.asList(0L, 100L, 400L, 100L); // emission delays in ms
        long debounceMs = 300;

        TestScheduler scheduler = new TestScheduler();

        TestObserver<String> testObserver = iRxJava
            .debounceIgnoreRapidEmission(items, delays, debounceMs, scheduler)
            .test();

        scheduler.advanceTimeBy(1000, TimeUnit.MILLISECONDS);

        // Verify output
        List<String> expected = Arrays.asList("B", "D");
        testObserver.assertValueCount(expected.size());
        testObserver.assertValues(expected.toArray(new String[0]));
        testObserver.assertComplete();

        Assert.assertEquals(expected, testObserver.values());
    }

    /**10.	Apply delay() to delay emission by 1 second.**/

    @Test
    public void delayEmissionTest() throws InterruptedException {
        Observable<Integer> observable = iRxJava.delayEmission(List.of(0,1,2,3,4,5,6,7,8,9),1);
        long startSub = System.currentTimeMillis();
        observable.subscribe(System.out::println);
        long endOfSub= System.currentTimeMillis();
        System.out.println((endOfSub-startSub));
        sleep(3000);
    }

    /**10.	Apply delay() to delay emission by 1 second.**/
    @Test
    public void delayPerEmissionTest() throws InterruptedException {
        Observable<Integer> observable = iRxJava.delayPerEmission(List.of(0,1,2,3,4,5,6,7,8,9),1);
        observable.subscribe(System.out::println).dispose();
        sleep(11000);
    }

    /**11.	Use take(5) to limit the number of emissions.**/
    @Test
    public void limitEmissionsTest()
    {
        Observable<Integer> observable = iRxJava.limitEmissions(List.of(0,1,2,3,4,5,6,7,8,9),5);

        TestObserver<Integer> testObserver = observable.test();
        testObserver.assertValueCount(5)
            .assertValueAt(4,4).assertValueSequence(List.of(0,1,2,3,4));
    }
    /**12.	Use skip(n) to ignore the first n emissions.**/
    @Test
    public void skipFirstNEmissionsTest()
    {
        Observable<Integer> observable = iRxJava.skipFirstNEmissions(List.of(0,1,2,3,4,5,6,7,8,9),5);

        TestObserver<Integer> testObserver = observable.test();
        testObserver.assertValueCount(5)
            .assertValueAt(4,9).assertValueSequence(List.of(5,6,7,8,9));
    }

    /**13.	Use distinct() to eliminate duplicates.**/
    @Test
    public void uniqueEmissionsTest()
    {
        Observable<Integer> observable = iRxJava.uniqueEmissions(List.of(0,1,2,3,4,4,4,3,3,2,2,1,1,2,4));

        TestObserver<Integer> testObserver = observable.test();
        testObserver.assertValueCount(5)
            .assertValueAt(4,4).assertValueSequence(List.of(0,1,2,3,4));
    }

    /**14.	Use reduce() to sum a stream of numbers.**/
    @Test
    public void reduceForSumTest(){
        Integer integer = iRxJava.reduceForSum(List.of(1,2,3,4,5,6,7,8,9,10));
        Assert.assertEquals(55,integer.intValue());
    }

    /**15.	Use collect() to gather all items into a List.*/
    @Test
    public void collectInListTest()
    {
        Single<List<String>> single = iRxJava.collectInList(List.of("Abhi","Kumar","Suman"), List.of(40,41,42));

        System.out.println(single.blockingGet());
        TestObserver<List<String>> testObserver = single.test(); // subscribe using TestObserver

        testObserver.awaitDone(3,TimeUnit.SECONDS)
            .assertValue(list -> list.size() == 3
                && list.contains("Abhi::40")
                &&list.get(1).equals("Kumar::41"));
    }

    /**16.	Use firstElement() and lastElement().**/
    @Test
    public void userFirstAndLastElemTest()
    {
        Observable<Integer> observable = iRxJava.userFirstAndLastElem(List.of(1,2,3,4,5,6));

        TestObserver<Integer> testObserver = observable.test();
        testObserver.assertValueCount(2)
            .assertValueAt(0,1)
            .assertValueAt(1,6)
            .assertValueSequence(List.of(1,6));
    }
    /**17.	Convert a blocking API to Single.**/
    @Test
    public void blockingApiTest() throws InterruptedException {
        Single<String> single = iRxJava.blockingApi();
        TestObserver<String> testObserver = single.test();
        testObserver.awaitDone(2,TimeUnit.SECONDS)
            .assertValue("Blocking result");

        sleep(2000);
    }
    /**18.	Log thread names using subscribeOn() and observeOn().**/
    @Test
    public void logThreadsTest() throws InterruptedException {
        Observable<Integer> observable = iRxJava.logThreads(List.of(1,2,3,4,5));
        TestObserver<Integer> testObserver = observable.test();
        testObserver.awaitDone(5,TimeUnit.SECONDS)
            .assertValueCount(5);
        sleep(3000);
    }
    /**19.	Use interval() to emit every second.**/
    @Test
    public void emitEverySecondTest() throws InterruptedException {
        Observable<Long> observable = iRxJava.emitEverySecond();

        TestObserver<Long> testObserver = observable.test();
        testObserver.awaitDone(5,TimeUnit.SECONDS)
            .assertValueCount(5);
        sleep(5000);
    }
    /**20.	Convert a Future to a Single.*/
    @Test
    public void convertFutureToSingleTest()
    {
        Single<String> single = iRxJava.convertFutureToSingle();

        TestObserver<String> testObserver = single.test();

        testObserver.awaitDone(2,TimeUnit.SECONDS)
            .assertValue("Result form Future")
            .assertValueCount(1)
            .assertComplete();
    }

    /* ** Intermediate (Transformation and Control - 30 questions)**/

    /**21.	Group a list of strings by their first character.**/
    @Test
    public void groupByFirstCharTest() {
        Single<Map<Character, List<String>>> single = iRxJava.groupByFirstChar(RxJavaDataUtils.getStrings());

        TestObserver<Map<Character,List<String>>> testObserver = single.test();
        testObserver.awaitDone(1,TimeUnit.SECONDS)
            .assertValueCount(1)
            .assertValue( e-> e.get('a').size()==4)
            .assertValue(e->e.get('k').size()==2)
            .assertValue(e->e.get('s').getFirst().equals("suman"));
    }

    /**22.	Switch between two streams using switchMap().**/
    @Test
    public void switchStreamTest() throws InterruptedException {
        Observable<String> observable = iRxJava.switchStream();

        TestObserver<String> testObserver = observable.test();
        testObserver.awaitDone(3,TimeUnit.SECONDS)
            .assertValueCount(10)
            .assertValueAt(0,"Received: Inner(0): 0")
            .assertValueAt(9,"Received: Inner(1): 4");
        sleep(10000);
    }

    /**23.	Concatenate multiple Observable<String> in order.**/
    @Test
    public void concatManyObserverInOrderTest()
    {
        Observable<String> observable = iRxJava.concatManyObserverInOrder(
            List.of("A","B","C"),
            List.of("E","F"),
            List.of("G")
        );
        TestObserver<String> testObserver = observable.test();
        testObserver.awaitDone(2,TimeUnit.SECONDS)
            .assertValueCount(6)
            .assertValueAt(0,"A")
            .assertValueAt(3,"E")
            .assertValueAt(5,"G")
            .assertValueSequence(List.of("A","B","C","E","F","G"));
    }

    /**24.	Use concatMap() vs flatMap() difference.**/
    @Test
    public void concatMapVsFlatMap(){
        Observable<Integer> observable = iRxJava.concatMapVsFlatMap(List.of(List.of(1,2,3),List.of(4,5)), true);
        TestObserver<Integer> testObserver = observable.test();
        testObserver.awaitDone(2,TimeUnit.SECONDS)
            .assertValueCount(5);

        observable = iRxJava.concatMapVsFlatMap(List.of(List.of(1,2,3),List.of(4,5)), false);
        testObserver = observable.test();
        testObserver.awaitDone(2,TimeUnit.SECONDS)
            .assertValueCount(5)
            .assertValueSequence(List.of(1,2,3,4,5));
    }

    /**25.	Chain network-like calls: login → fetchProfile → fetchPosts.**/
    @Test
    public void chainCallsTest() {

        Single<List<Post>> single = iRxJava.chainCalls("admin","1234");
        TestObserver<List<Post>> testObserver = single.test();
        testObserver.awaitDone(3,TimeUnit.SECONDS)
            .assertValueCount(1)
            .assertValueAt(0, item-> item.getFirst().equals(new Post("post1", "Hello World!")))
            .assertValueAt(0, item-> item.getLast().equals(new Post("post2", "RxJava is awesome!")))
            .assertComplete();
    }
    /**26.	Use retry() to retry a failing stream 3 times.**/
    @Test
    public void retryUseOnFailingTest(){
        Observable<String> observable = iRxJava.retryUseOnFailing(3).retry(3);

        TestObserver<String> testObserver = observable.test();
        testObserver.awaitDone(1,TimeUnit.SECONDS)
            .assertValueCount(1)
            .assertValue("Success after retry 3 times");

    }

    /**27.	Use retryWhen() with delay strategy.*/
    @Test
    public void retryWhenWithDelayTest() throws InterruptedException {
        Observable<String> stringObservable = iRxJava.retryWhenWithDelay(3)
            .retryWhen( errors ->
                errors.zipWith(Observable.range(1,3), (error,retryCount)-> retryCount)
                    .flatMap(retryCount->
                    {
                        System.out.println("Retry #" + retryCount);
                        return Observable.timer(1, TimeUnit.SECONDS); // 1 sec delay between retries
                    })
            );

        TestObserver<String> testObserver = stringObservable.test();
        testObserver.awaitDone(5,TimeUnit.SECONDS)
            .assertValueCount(1)
            .assertValue("Success after retry 3 times");
        sleep(5000);
    }

    /**28.	Apply timeout logic using timeout() operator.**/
    @Test
    public void useTimeoutTest() {
        Observable<Long> observable = iRxJava.useTimeout();

        TestObserver<Long> testObserver = observable.test();
        testObserver.awaitDone(2,TimeUnit.SECONDS)
            .assertValueCount(1)
            .assertValue(-1L);
    }

    /**29.	Use onErrorResumeNext() to recover from error.*/
    @Test
    public void useOnErrorResumeNextRecoverErrorTest()
    {
        Observable<String> observable = iRxJava.useOnErrorResumeNextRecoverError(List.of("X", "Y","Z"));

        TestObserver<String> testObserver = observable.test();
        testObserver.awaitDone(2,TimeUnit.SECONDS)
            .assertValueCount(5)
            .assertValueAt(0,"A")
            .assertValueAt(4,"Z");

    }

    /**30.	Use onErrorReturn() to return fallback value.**/
    @Test
    public void useOnErrorResumeReturnFallbackTest()
    {
        Observable<String> observable = iRxJava.useOnErrorResumeReturnFallback();

        TestObserver<String> testObserver = observable.test();
        testObserver.awaitDone(2,TimeUnit.SECONDS)
            .assertValueCount(3)
            .assertValueAt(0,"A")
            .assertValueAt(1,"B")
            .assertValueAt(2,"Oops! Something went wrong");

    }

    /**31.	Compare Observable.create() vs just() vs fromCallable().**/
    @Test
    public void createVsJustVsFromCallableTest()
    {
        Observable<String> observable = iRxJava.createVsJustVsFromCallable();
        TestObserver<String> testObserver = observable.test();
        testObserver.awaitDone(2,TimeUnit.SECONDS)
            .assertValueCount(1)
            .assertValue("APX");
    }

    /**32.	Apply backpressure strategy using Flowable**/
    @Test
    public void applyBackpressureStrategyTest() throws InterruptedException {
        Flowable<Integer> fastProducer = iRxJava.applyBackpressureStrategy();

        TestSubscriber<Integer> testSubscriber = new TestSubscriber<>();
        // Simulate slow subscriber using observeOn
        fastProducer
            .observeOn(Schedulers.computation())
            .subscribe(testSubscriber);

        testSubscriber.awaitDone(2, java.util.concurrent.TimeUnit.SECONDS);
        assert testSubscriber.values().size() < 10_000;

        fastProducer
            .observeOn(Schedulers.io())
            .subscribe(
                item -> {
                    sleep(10);  // Simulate slow consumer
                    System.out.println("Received: " + item);
                },
                Throwable::printStackTrace
            );

        sleep(5000);
    }

    /**33.	Convert Observable to Flowable with strategy.**/
    @Test
    public void convertObservableToFlowableTest() throws InterruptedException {
        Flowable<Integer> fastProducer = iRxJava.convertObservableToFlowable();

        TestSubscriber<Integer> testSubscriber = new TestSubscriber<>();
        // Simulate slow subscriber using observeOn
        fastProducer
            .observeOn(Schedulers.computation())
            .subscribe(testSubscriber);

        testSubscriber.awaitDone(2, java.util.concurrent.TimeUnit.SECONDS);
        assert testSubscriber.values().size() < 250;
        // sleep(10000);

        fastProducer
            .observeOn(Schedulers.io())
            .subscribe(
                item -> {
                    sleep(10);  // Simulate slow consumer
                    System.out.println("Received: " + item);
                },
                Throwable::printStackTrace
            );

        sleep(5000);
    }

    /**34.	Use window(2) and process each window.**/
    @Test
    public void useWindowNTest()
    {
        Observable<List<Integer>> observable = iRxJava.useWindowN(3);

        TestObserver<List<Integer>> testObserver = observable.test();
        testObserver.awaitDone(2,TimeUnit.SECONDS)
            .assertValueCount(4)
            .assertValueAt(0,List.of(1,2,3))
            .assertValueAt(3,List.of(10));
    }

    /**35.	Monitor and print all lifecycle events (doOnNext, doOnComplete).**/
    @Test
    public void printLifeCycleEventsTest()
    {
        Observable<Integer> observable = iRxJava.printLifeCycleEvents();
        observable.subscribe(
            item -> System.out.println("Received: " + item),
            Throwable::printStackTrace,
            () -> System.out.println("onComplete called in subscribe")
        );

        TestObserver<Integer> testObserver = observable.test();
        testObserver.awaitDone(2,TimeUnit.SECONDS)
            .assertValueCount(3)
            .assertValueSequence(List.of(1,2,3));
    }
    /**36.	Use scan() to show running total of values.**/
    @Test
    public void useScanForSumTest()
    {
        Observable<Integer> observable = iRxJava.useScanForSum(List.of(10,20,30,40,50));

        TestObserver<Integer> testObserver = observable.test();
        testObserver.awaitDone(2,TimeUnit.SECONDS)
            .assertValueAt(1,30)
            .assertValueSequence(List.of(10,30,60,100,150));
    }

    /**37.	Use repeat() to repeat a stream N times.**/
    @Test
    public void useRepeatObservableTest()
    {
        Observable<String> observable = iRxJava.useRepeatObservable(List.of("A","B","C"), 2);

        TestObserver<String> testObserver = observable.test();
        testObserver.awaitDone(3,TimeUnit.SECONDS)
            .assertValueCount(6)
            .assertValueAt(1,"B")
            .assertValueSequence(List.of("A","B","C","A","B","C"));
    }

    /**38.	Use takeUntil() with a second observable.**/
    @Test
    public void takUntilAsSecondObservableTest()
    {
        Observable<Long>  observable = iRxJava.takUntilAsSecondObservable();

        TestObserver<Long> testObserver = observable.test();
        testObserver.awaitDone(3,TimeUnit.SECONDS)
            .assertValueCount(4)
            .assertValueAt(2,2L);
    }

    /**39.	Combine emissions with combineLatest().**/
    @Test
    public void combineEmissionsWithCombineLatestTest() {
        Observable<String> observable = iRxJava.combineEmissionsWithCombineLatest();

        TestObserver<String> testObserver = observable.test();
        testObserver.awaitDone(2,TimeUnit.SECONDS)
            .assertValueCount(5)
            .assertValueAt(0,"A1")
            .assertValueAt(1,"B1");
    }

    /**40.	Use amb() to emit from the fastest source.*/
    @Test
    public void useAmbToGetEmitFromFatestTest()
    {
        Observable<String> observable = iRxJava.useAmbToGetEmitFromFatest(List.of("A","B","C"), List.of("P","Q","R"),List.of("X","Y","Z"));

        TestObserver<String> testObserver = observable.test();
        testObserver.awaitDone(3,TimeUnit.SECONDS)
            .assertValueCount(3)
            .assertValueAt(0,"X")
            .assertValueSequence(List.of("X","Y","Z"));
    }

    /**41.	Test Observable with TestObserver.*/
    @Test
    public void testWithTestObserverTest()
    {
        Single<Integer> integerSingle = iRxJava.testWithTestObserver(IntStream.rangeClosed(1,10).boxed().toList());

        TestObserver<Integer> testObserver = integerSingle.test();
        testObserver.awaitDone(1,TimeUnit.SECONDS)
            .assertValueCount(1)
            .assertValue(55);
    }

    /**42.	Test timeout and retry logic using TestScheduler.**/
    @Test
    public void fetchWithTimeoutAndRetryTest()
    {
        TestScheduler testScheduler = new TestScheduler();

        // Act
        TestObserver<Long> testObserver = iRxJava.fetchWithTimeoutAndRetry(testScheduler).test();

        // Assert: Nothing yet, timeout hasn't occurred
        testObserver.assertNotComplete();
        testObserver.assertNoValues();

        // Advance 1 second for first timeout
        testScheduler.advanceTimeBy(1, TimeUnit.SECONDS);

        // Still no emission, retry #1
        testObserver.assertNotComplete();
        testObserver.assertNoValues();

        // Advance 1 second again — retry #2
        testScheduler.advanceTimeBy(1, TimeUnit.SECONDS);
        testObserver.assertNotComplete();

        // Final retry attempt — advance 1 more second
        testScheduler.advanceTimeBy(1, TimeUnit.SECONDS);

        // Still nothing, all retries exhausted
        testScheduler.advanceTimeBy(1, TimeUnit.SECONDS);

        testObserver.assertError(throwable -> throwable instanceof java.util.concurrent.TimeoutException);
        testObserver.assertNoValues();

    }

    /**43.	Create a cold observable that becomes hot using publish().**/
    @Test
    public void convertColdToHotObservableTest() throws InterruptedException {
        ConnectableObservable<String> hot = iRxJava.convertColdToHotObservable(List.of("A","B","C","D","E"));
        sleep(2000);
        TestObserver<String> testObserver = hot.test();
        testObserver.awaitDone(5,TimeUnit.SECONDS)
            .assertValueCount(3)
            .assertValueSequence(List.of("C","D","E"));
        assert testObserver.values().size() < 5;
    }

    /**44.	Use share() to multicast stream.**/
    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    public void useShareToMulticast() throws InterruptedException {
        Observable<Long>  sharedObservable = iRxJava.useShareToMulticast();
        // First observer subscribes immediately
        sharedObservable.subscribe(i -> System.out.println("Observer 1: " + i));
        sleep(3000); // wait 3 seconds
        // Second observer subscribes late
        sharedObservable.subscribe(i -> System.out.println("Observer 2: " + i));
        sleep(4000); // let it run for 4 more seconds
    }

    /**45.	Cache values with cache().**/
    @Test
    public void useCacheValuesTest()
    {
        Observable<String> source = iRxJava.useCacheValues(List.of("A","B","C"));
        // First subscriber triggers actual data fetch
        source.subscribe(val -> System.out.println("Observer 1: " + val));

        System.out.println("---- Second subscription ----");

        // Second subscriber gets cached data (no new fetch)
        source.subscribe(val -> System.out.println("Observer 2: " + val));

        //it will use cached values
        TestObserver<String> testObserver = source.test();
        testObserver.awaitDone(2,TimeUnit.SECONDS)
            .assertValueCount(3)
            .assertValueSequence(List.of("A","B","C"));
    }

    /**46.	Use Single.zip() for dependent API results.**/
    @Test
    public void useSingleZipForDependentApiTest()
    {
        Single<String> single = iRxJava.useSingleZipForDependentApi();

        TestObserver<String> testObserver = single.test();
        testObserver.awaitDone(2,TimeUnit.SECONDS)
            .assertValueCount(1)
            .assertValue("Combined result → User: John Doe, Order: Order#123");
    }

    /**47.	Use Maybe to return optional result.**/
    @Test
    public void useMaybeTest()
    {
        Observable<Maybe<String>> observable = iRxJava.useMaybe(List.of("123","345","234"));

        observable.subscribe(e->System.out.println(e.blockingGet()));
        TestObserver<Maybe<String>> testObserver = observable.test();
        testObserver.awaitDone(3,TimeUnit.SECONDS)
            .assertValueCount(3).
            assertValueAt(0,e-> e.blockingGet().equals("John Doe"))
            .assertValueAt(1,e-> e.blockingGet()==null);
    }

    /**48.	Use Completable to represent task without value.**/
    @Test
    public void useCompletableTest()
    {
        Completable completable = iRxJava.useCompletable("Abhi kumar");
        completable.subscribe();
    }
    /**49.	Use blockingGet() in test scenarios.**/
    @Test
    public void useBlockingGetInTestTest()
    {
        Observable<Maybe<String>> observable = iRxJava.useBlockingGetInTest(List.of("123","345","234"));

        observable.subscribe(e->System.out.println(e.blockingGet()));
        TestObserver<Maybe<String>> testObserver = observable.test();
        testObserver.awaitDone(3,TimeUnit.SECONDS)
            .assertValueCount(3).
            assertValueAt(0,e-> e.blockingGet().equals("John Doe"))
            .assertValueAt(1,e-> e.blockingGet()==null);
    }

    /**50.	Chain Observable to Single and back.**/
    @Test
    public void chainObsToSingleBackObsTest()
    {
        Observable<String> stringObservable = iRxJava.chainObsToSingleBackObs(IntStream.rangeClosed(1,10).boxed().toList());

        TestObserver<String> testObserver = stringObservable.test();
        testObserver.awaitDone(1,TimeUnit.SECONDS)
            .assertValueCount(1)
            .assertValue("Sum of list: 55");
    }

    /* *Advanced (Concurrency, Custom Operators, Real-World Scenarios - 30+)*/

    /**51.	Implement a rate limiter using throttleFirst().**/
    @Test
    public void useRateLimiterThrottleFirstTest()  {
        Observable<Long> observable = iRxJava.useRateLimiterThrottleFirst();
        TestObserver<Long> testObserver = observable.test();
        testObserver.awaitDone(4,TimeUnit.SECONDS)
            .assertValueCount(3)
            .assertValueAt(1,4L)
            .assertValueSequence(List.of(0L,4L,8L));
    }

    /**52.	Design a typeahead/autocomplete using debounce().*/
    @Test
    public void designAutocompleteByDebounceTest() throws InterruptedException {
       iRxJava.designAutocompleteByDebounce();
        sleep(1000); // Wait to see all results
    }

    /**53.	Perform batch DB insert using buffer() and flatMap().**/
    @Test
    public void batchInsertByBufferAndFlatMpaTest() throws InterruptedException{
        iRxJava.batchInsertByBufferAndFlatMpa();
        sleep(2000);
    }

    /**54.	Create a retry strategy with exponential backoff.**/
    @Test
    public void retryWithExponentialBackoffTest() throws InterruptedException {
        iRxJava.retryWithExponentialBackoff();
    }

    /**55.	Parallel execution with flatMap() and Schedulers.io().**/
    @Test
    public void parallelFlatMapAndSchedularTest()
    {
        Single<Integer> single= iRxJava.parallelFlatMapAndSchedular(IntStream.rangeClosed(1,100).boxed().toList());

        TestObserver<Integer> testObserver = single.test();
        testObserver.awaitDone(3,TimeUnit.SECONDS)
            .assertValueCount(1)
            .assertValue(100*101*(2*100+1)/6);
    }

    /**56.	Switch execution between main and io thread.**/
    @Test
    public void switchBtnMainSndIoThreadTest()
    {
        Observable<String> observable = iRxJava.switchBtnMainSndIoThread("RxJava Thread Switch");

        TestObserver<String> testObserver = observable.test();
        testObserver.awaitDone(3,TimeUnit.SECONDS)
            .assertValueCount(1)
            .assertValue("RXJAVA THREAD SWITCH");
    }

    /**57.	Write a custom ObservableTransformer.*/
    @Test
    public void customObservableTransformerTest()
    {
        Observable<String> observable = iRxJava.customObservableTransformer(Arrays.asList(" hello ", " rxjava","","abkumar"));
        TestObserver<String> testObserver = observable.test();
        testObserver.awaitDone(3,TimeUnit.SECONDS)
            .assertValueCount(3)
            .assertValueAt(1,"RXJAVA")
            .assertValueSequence(List.of("HELLO","RXJAVA","ABKUMAR"));
    }

    /**58.	Implement a simple EventBus using PublishSubject.**/
    @Test
    public void implEventBusByPublishSubjectTest() throws InterruptedException {

        iRxJava.implEventBusByPublishSubject(List.of(new MessageEvent("Hello from Rx EventBus!"),new MessageEvent("Another message")));
    }
    
   
    /**59.	Use BehaviorSubject to always emit the last value.**/
    @Test
    public void useBehaviorSubjectAlwaysEmitLast(){
        iRxJava.useBehaviorSubjectAlwaysEmitLast();
    }

    /**60.	Create a cold observable with side-effect logging.**/
    @Test
    public void coldObserverWithLoggingTest()
    {
        Observable<String> coldObservable = iRxJava.coldObserverWithLogging();

        System.out.println("Subscriber 1 subscribing...");
        coldObservable.subscribe(
            item -> System.out.println("Subscriber 1 received: " + item),
            Throwable::printStackTrace,
            () -> System.out.println("Subscriber 1 done")
        );

        System.out.println("\nSubscriber 2 subscribing...");
        coldObservable.subscribe(
            item -> System.out.println("Subscriber 2 received: " + item),
            Throwable::printStackTrace,
            () -> System.out.println("Subscriber 2 done")
        );
    }

    /**61.	Use ConnectableObservable with refCount().**/
    @Test
    public void useConnectableObservableWithRefCountTest() throws InterruptedException {
        Observable<Long> shared = iRxJava.useConnectableObservableWithRefCount();
    // First subscriber
        var disposable1 = shared.subscribe(i -> System.out.println("Observer 1: " + i));

        sleep(3000); // Let it emit 3 times

        // Second subscriber joins
        var disposable2 = shared.subscribe(i -> System.out.println("Observer 2: " + i));

        sleep(3000); // Let both observe for 3 more seconds

        // Unsubscribe both
        disposable1.dispose();
        disposable2.dispose();

        sleep(2000); // Wait to see if it stops emitting
    }

    /**62.	Cache latest result of network call for future subscribers.**/
    @Test
     public void cacheLatestResultNetworkCallTest() throws InterruptedException {
        Observable<String> cachedNetworkCall = iRxJava.cacheLatestResultNetworkCall();

        // First subscriber (triggers network call)
        cachedNetworkCall.subscribe(result -> System.out.println("Subscriber 1: " + result));

        sleep(2000); // Delay

        // Second subscriber (gets cached result)
        cachedNetworkCall.subscribe(result -> System.out.println("Subscriber 2: " + result));

        // Third subscriber
        cachedNetworkCall.subscribe(result -> System.out.println("Subscriber 3: " + result));
    }

    /**63.	Cancel an in-progress operation with Disposable.**/
    @Test
    public void cancelInProgressOperWithDisposableTest() throws InterruptedException {
        Observable<Long> observable = iRxJava.cancelInProgressOperWithDisposable();

        Disposable disposable11 = observable.subscribe(e -> System.out.println("Emmit:Observer1:- "+e));
        TimeUnit.SECONDS.sleep(2); //let 4 emit get then wil cancel

        Disposable disposable21 = observable.subscribe(e -> System.out.println("Emmit:Observer2:- "+e));
        TimeUnit.SECONDS.sleep(2); //let 4 emit get then wil cancel

        disposable11.dispose();
        disposable21.dispose();
    }

    /**64.	Use DisposableObserver to manage lifecycle.**/
    @Test
    public void UseDisposableObserverToManageLifecycleTest()
    {
        iRxJava.UseDisposableObserverToManageLifecycle(List.of("Hello","Rx-3","Java"));
    }

    /**65.	Build a countdown timer with intervalRange().*/
    @Test
    public void countdownTimerWithIntervalRangeTest() throws InterruptedException {
        iRxJava.countdownTimerWithIntervalRange(10);
    }

    /**66.	Use generate() to emit Fibonacci sequence.**/
    @Test
    public void generateToEmitFibonacciSeqTest()
    {
        iRxJava.generateToEmitFibonacciSeq(10);
    }

    /**67.	Integrate with a REST API returning Single<Response<T>>.**/
    @Test
    public void getRestAPiResponseTest()
    {
        Single<User> single = iRxJava.getRestAPiResponse();

        TestObserver<User> testObserver = single.test();

        testObserver.awaitDone(1,TimeUnit.SECONDS)
            .assertValueCount(1)
            .assertValue(new User("123", "John Doe"));
    }
    /**68.	Chain validation logic using flatMapCompletable().**/
    @Test
    public void chainValidationUsingFlatMapCompletableTest()
    {
        Completable completable = iRxJava.chainValidationUsingFlatMapCompletable(new Employee("john@example.com", "StrongPass123"));

        TestObserver<Void> testObserver = completable.test();
        testObserver.awaitDone(2,TimeUnit.SECONDS).
        assertError(IllegalArgumentException.class).
        assertError(e->e.getMessage().equals("Email already registered"));
    }

    /**69.	Combine multiple Completable tasks with mergeArray().**/
    @Test
    public void combineManyCompletableUsingMergeArrayTest() throws InterruptedException {
        Completable completable = iRxJava.combineManyCompletableUsingMergeArray();
        completable.subscribe(
            () -> System.out.println("All tasks completed successfully."),
            error -> System.out.println("At least one task failed: " + error.getMessage())
        );
    }

    /**70.	Collect multi-page API results using recursion and concatMap().**/
    @Test
    public void collectMultiPageResultRecursivelyTest()
    {
        Observable<Item> observable = iRxJava.collectMultiPageResultRecursively(1);

        TestObserver<Item> testObserver = observable.test();
        testObserver.awaitDone(3,TimeUnit.SECONDS)
            .assertValueCount(6);
    }

/* *Bonus: Challenges & Patterns (20+)**/
    /**71.	Implement mergeSort using reactive recursion.**/
    @Test
    public void implMergeSortRecursionTest() throws InterruptedException {

        Single<List<Integer>> single = iRxJava.implMergeSortRecursion(List.of(1,9,2,8,3,7,4,6,5));

        System.out.println(single.blockingGet());
        TestObserver<List<Integer>> testObserver = single.test();
        testObserver.awaitDone(2,TimeUnit.SECONDS)
            .assertValue(List.of(1,2,3,4,5,6,7,8,9));

    }

    /**72.	Simulate a scheduler-like job queue.**/
    @Test
    public void makeJobAsSchedularTest() throws InterruptedException {
        List<Job> jobs = Arrays.asList(
            new Job("Job-1", 2),
            new Job("Job-2", 1),
            new Job("Job-3", 3)
        );
        Observable<String> observable = iRxJava.makeJobAsSchedular(jobs);

        TestObserver<String> testObserver = observable.test();
        testObserver.awaitDone(10,TimeUnit.SECONDS)
                .assertValueCount(3)
                    .assertValueAt(0,"Job-2 done")
                        .assertValueAt(2,"Job-3 done");
    }
    /**73.	Retry only on specific exceptions.**/
    @Test
    public void retryOnlyOnSpecificExceptionsTest() throws InterruptedException {
           iRxJava.retryOnlyOnSpecificExceptions();
    }

    /**74.	Aggregate order data by user from stream of Order records.**/
    @Test
    public void aggDataByUserTest()
    {
        Observable<OrderSummary> observable = iRxJava.aggDataByUser(RxJavaDataUtils.getEmpOrders());

        TestObserver<OrderSummary> testObserver = observable.test();
        testObserver.awaitDone(2,TimeUnit.SECONDS)
            .assertValueCount(3)
            .assertValueAt(0, e-> e.userId().equals("user1") && e.orderCount()==2 && e.totalAmount()==250)
            .assertValueAt(1, e-> e.userId().equals("user2") && e.orderCount()==2 && e.totalAmount()==250)
            .assertValueAt(2, e-> e.userId().equals("user3") && e.orderCount()==1 && e.totalAmount()==300);

    }

    /**75.	Monitor service health with timeout and fallback.**/
    @Test
    public void monitorServiceHealthWithTimeoutAndFallBackTest() throws InterruptedException {
        Single<String> single = iRxJava.monitorServiceHealthWithTimeoutAndFallBack();
        single.subscribe(
        result -> System.out.println("Health check result: " + result),
        error -> System.err.println("Error: " + error)
        );
            sleep(3000);

    }

    /**76.	Reactive circuit breaker pattern with timeout + fallback.**/
    @Test
    public void designCircuitBreakerPatternTest() throws InterruptedException {
        iRxJava.designCircuitBreakerPattern();
    }

}

