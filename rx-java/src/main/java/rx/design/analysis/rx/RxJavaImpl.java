package rx.design.analysis.rx;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.*;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.PublishSubject;
import org.apache.commons.lang3.StringUtils;
import rx.design.analysis.rx.model.HttpResponse;
import rx.design.analysis.rx.model.MessageEvent;
import rx.design.analysis.rx.record.*;
import rx.design.analysis.rx.service.UserServiceImpl;
import rx.design.analysis.rx.utils.*;
import rx.design.analysis.rx.validation.EmployeeValidation;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.lang.Thread.sleep;
@SuppressWarnings("ResultOfMethodCallIgnored")
public class RxJavaImpl implements IRxJava{

    /**1.	What is RxJava and how does it work?
     * Ex- Async Data Flow + Operators,* Fetches a list of users,* For each user, fetches a list of orders* Flattens results each UserOrder
     */
    public Single<Map<User, List<Order>>> getUserOrdersByThem(Observable<User> users)   {
     return
         users.flatMap( user-> RxUtils.getOrdersForUser(user)
             .subscribeOn(Schedulers.io())
             .map( order -> new UserOrder(user, order))
         ).observeOn(Schedulers.single())
             .collect(Collectors.groupingBy(
                 UserOrder::user,
                 Collectors.mapping(UserOrder::order, Collectors.toList())
             ));
    }

/* *Beginner Level (Fundamentals - 20 questions)**/
    /**1.	Create an Observable from a list of strings.*/
    @Override
    public Observable<String> fromListOfString(List<String> list){
        return
            Observable.fromIterable(list);
    }
    /**2.	Use map() to convert a list of integers to their squares.**/
    @Override
    public Observable<Integer> toSquare(List<Integer> list){
        return
            Observable.fromIterable(list)
                .map( i-> i*i);
    }

    /**3.	Use filter() to emit only even numbers.*/
    @Override
    public Observable<Integer> emitEvenNo(List<Integer> list){

        return
            Observable.fromIterable(list)
                .filter(i-> i%2==0);
    }

    /**4.	Use flatMap() to flatten a list of List<String>.*/
    @Override
    public Observable<String> flattenListOfList(List<List<String>> list){
        return
            Observable.fromIterable(list)
                .flatMap(Observable::fromIterable);
    }

    /**5.	Convert a Single<List<String>> to Observable<String>.*/
    @Override
    public Observable<String> fromSingleList(Single<List<String>> listSingle){
        return
            Observable.fromSingle(listSingle)
                .flatMap(Observable::fromIterable);
    }

    /**6.	Combine two Observable<Integer> using merge().*/
    @Override
    public Observable<Integer> mergeObservableSort(List<Integer> list1, List<Integer> list2){
        return
            Observable.merge(Observable.fromIterable(list1), Observable.fromIterable(list2))
                .sorted();
    }
    /**7.	Use zip() to pair items from two Observable*/
    @Override
    public Observable<String> zipTwoObservable(List<String> names, List<Integer> ages){

        Observable<String> nameObservable = Observable.fromIterable(names);
        Observable<Integer> ageObservable = Observable.fromIterable(ages);
        return
            Observable.zip(nameObservable,ageObservable, (name,age)-> name +" is "+age+" years");
    }

    /**8.	Use buffer(3) to collect 3 items at a time assume sufficient items*/
    @Override
    public Observable<List<String>> bufferFixedItems(List<String> list, int n){
        return
            Observable.fromIterable(list)
                .buffer(n);
    }

    /**9.	Use debounce() to ignore rapid emissions.*/
    @Override
    public Observable<String> debounceIgnoreRapidEmission(List<String> items, List<Long> delays, long debounceMs, Scheduler scheduler){
        return
            Observable.range(0,items.size())
                .concatMap( i-> Observable.timer(delays.get(i), TimeUnit.MILLISECONDS, scheduler)
                    .map( t-> items.get(i)))
                .debounce(debounceMs,TimeUnit.MILLISECONDS, scheduler);
    }

    /**10.	Apply delay() to delay emission by 1 second.**/
    @Override
    public Observable<Integer> delayEmission(List<Integer> list, int delayInSecond){
        return
            Observable.fromIterable(list)
                .delay(delayInSecond, TimeUnit.SECONDS);//this is delay from subscription
    }
    /**10.	Apply delay() to delay emission by 1 second.**/
    @Override
    public Observable<Integer> delayPerEmission(List<Integer> list, int delayInSecond){
        return
            Observable.fromIterable(list)
                .map(item->
                {
                    sleep(delayInSecond* 1000L);
                    return item;
                });
    }

    /**11.	Use take(5) to limit the number of emissions.**/
    @Override
    public Observable<Integer> limitEmissions(List<Integer> list, int n){
        return
            Observable.fromIterable(list)
                .take(n);
    }

    /**12.	Use skip(3) to ignore the first 3 emissions.**/
    @Override
    public Observable<Integer> skipFirstNEmissions(List<Integer> list, int n){
        return
            Observable.fromIterable(list)
                .skip(n);
    }

    /**13.	Use distinct() to eliminate duplicates.**/
    @Override
    public Observable<Integer> uniqueEmissions(List<Integer> list){
        return
            Observable.fromIterable(list)
                .distinct();
    }

    /**14.	Use reduce() to sum a stream of numbers.**/
    @Override
    public Integer reduceForSum(List<Integer> list){
        return
        Observable.fromIterable(list)
            .reduce(0, Integer::sum).blockingGet();
    }

    /**15.	Use collect() to gather all items into a List.*/
    @Override
    public Single<List<String>> collectInList(List<String> list, List<Integer> ages){
        Observable<String> nameObservable = Observable.fromIterable(list);
        Observable<Integer> ageObservable = Observable.fromIterable(ages);

        return
        Observable.zip(nameObservable,ageObservable, (name, age)-> name+"::"+age)
            .toList();
    }

    /**16.	Use firstElement() and lastElement().**/
    @Override
    public Observable<Integer> userFirstAndLastElem(List<Integer> list){
        return
            Observable.range(0,list.size())
                .filter( i-> i==0 || i==list.size()-1)
                .map(list::get);
    }

    /**17.	Convert a blocking API to Single.**/
    @Override
    public Single<String> blockingApi(){
       return
           Single.fromCallable(RxUtils::blockingApiCall)
               .subscribeOn(Schedulers.io());
    }

    /**18.	Log thread names using subscribeOn() and observeOn().**/
    @Override
    public Observable<Integer> logThreads(List<Integer> list)
    {
        return
            Observable.fromIterable(list)
            .subscribeOn(Schedulers.io())
            .map(item->
            {
                sleep(200);
                System.out.println("Thread running for subscribeOn:- "+Thread.currentThread().getName());
                return item;
            }).observeOn(Schedulers.single())
            .map(item->
            {
                sleep(200);
                System.out.println("Thread running for observeOn: -"+Thread.currentThread().getName());
                return item;
            });
    }

    /**19.	Use interval() to emit every second.**/
    @Override
    public Observable<Long> emitEverySecond(){
        return
            Observable.interval(1,TimeUnit.SECONDS)
                .take(5);
    }

    /**20.	Convert a Future to a Single.*/
    @Override
    public Single<String> convertFutureToSingle(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> future = executorService.submit(
            ()->
            {
                sleep(1000);
                return "Result form Future";
            }
        );
        return
            Single.fromFuture(future);
    }
/* * Intermediate (Transformation and Control - 30 questions)**/

    /**21.	Group a list of strings by their first character.**/
    @Override
    public Single<Map<Character, List<String>>> groupByFirstChar(List<String> list){
        return
            Observable.fromIterable(list)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .collect(Collectors.groupingBy(
                    s-> s.charAt(0),
                    Collectors.toList()
                ));

    }

    /**22.	Switch between two streams using switchMap().**/
    public Observable<String> switchStream() {
        Observable<Long> switchingStream = Observable.interval(1, TimeUnit.SECONDS)
            .take(2); // emit at 0s and 3s only

        return
        switchingStream
            .observeOn(Schedulers.single())
            .doOnNext(i-> System.out.println("Source emitting :-"+i))
            .switchMap(RxUtils::getInnerStream)
            .map(i-> "Received: "+i);

    }

    /**23.	Concatenate multiple Observable<String> in order.**/
    @Override
    public Observable<String> concatManyObserverInOrder(List<String> l1, List<String> l2, List<String> l3){
        return
            Observable.concat(Observable.fromIterable(l1),Observable.fromIterable(l2), Observable.fromIterable(l3));

    }
    /**24.	Use concatMap() vs flatMap() difference.**/
    public Observable<Integer> concatMapVsFlatMap(List<List<Integer>> ll, boolean isFlatMap){
        return
            isFlatMap
                ?
                Observable.fromIterable(ll)
                    .flatMap(Observable::fromIterable)
                :
                Observable.fromIterable(ll)
                .concatMap(Observable::fromIterable);
    }

    /**25.	Chain network-like calls: login → fetchProfile → fetchPosts.**/
    @Override
    public Single<List<Post>> chainCalls(String userId, String name){
        return
            RxUtils.login(userId,name)
                .flatMap(user -> RxUtils.fetchProfile(user.id()))
                .flatMap(profile -> RxUtils.fetchPosts(profile.userId()));
    }

    /**26.	Use retry() to retry a failing stream 3 times.**/
    private static int attempt=1;
    @Override
    public Observable<String> retryUseOnFailing(int n){

        return
            Observable.fromCallable(()-> {
                System.out.println("Attempt# " + attempt);
                if (attempt++ < 3)
                    throw new RuntimeException("Simulated Failure");
                return "Success after retry " + (attempt-1) + " times";
            });
    }

    /**27.	Use retryWhen() with delay strategy.*/
    private static int retry=1;
    @Override
    public Observable<String> retryWhenWithDelay(int n){
        return
            Observable.fromCallable(()-> {
                System.out.println("Attempt# " + retry);
                if (retry++ < 3)
                    throw new RuntimeException("Simulated Failure");
                return "Success after retry " + (retry-1) + " times";
            });
    }

    /**28.	Apply timeout logic using timeout() operator.**/
    @Override
    public Observable<Long> useTimeout(){

        Observable<Long> fallback = Observable.just(-1L);

        Observable<Long> source = Observable.interval(2, TimeUnit.SECONDS) // emits every 2 seconds
            .timeout(1, TimeUnit.SECONDS) // but we require emission every 1 sec
            .doOnNext(i -> System.out.println("Emitted: " + i))
            .doOnError(e -> System.err.println("Error: " + e));
        return
            source.onErrorResumeNext( error ->
            {
               return fallback;
            });
    }
    /**29.	Use onErrorResumeNext() to recover from error.*/
    @Override
    public Observable<String> useOnErrorResumeNextRecoverError(List<String> fallback){

        Observable<String> observable = Observable.create(emitter ->
        {
            emitter.onNext("A");
            emitter.onNext("B");
            emitter.onError(new RuntimeException("Something went wrong"));
        });

        return observable.onErrorResumeNext(error ->
        {
            System.out.println("Recovered from error: " + error.getMessage());
            return Observable.fromIterable(fallback);
        });
    }

    /**30.	Use onErrorReturn() to return fallback value.**/
    @Override
    public Observable<String> useOnErrorResumeReturnFallback(){
        Observable<String> observable = Observable.create(emitter ->
        {
            emitter.onNext("A");
            emitter.onNext("B");
            emitter.onError(new RuntimeException("Oops! Something went wrong"));
        });

        return observable.onErrorReturn(Throwable::getLocalizedMessage);
    }

    /**31.	Compare Observable.create() vs just() vs fromCallable().**/
    @Override
    public Observable<String> createVsJustVsFromCallable(){

           Observable<String> observableCreate = Observable.create(emitter->
           {
               emitter.onNext("A");
               emitter.onNext("B");
           });

           Observable<String> observableJust = Observable.just("P","Q","R");
           Observable<String> observableCallable = Observable.fromCallable(()->
           {
               return "X";
           });

           return Observable.zip(observableCreate,observableJust,observableCallable,
               (s1,s2,s3)->s1+s2+s3);
    }

    /**32.	Apply backpressure strategy using Flowable**/
    @Override
    public Flowable<Integer> applyBackpressureStrategy(){

        return Flowable.create( emitter ->
        {
            for(int i=1;i<=1000;i++)
                emitter.onNext(i);
            emitter.onComplete();
        }, BackpressureStrategy.DROP);
    }

    /**33.	Convert Observable to Flowable with strategy.**/
    @Override
    public Flowable<Integer> convertObservableToFlowable(){

        Observable<Integer> observable = Observable.create(emitter->
        {
           for(int i=1;i<=250;i++){
               emitter.onNext(i);
           }
        });

        return Flowable.fromObservable(observable,BackpressureStrategy.DROP);
    }

    /**34.	Use window(2) and process each window.**/
    @Override
    public Observable<List<Integer>> useWindowN(int n){

     return Observable.range(1, 10)
            .window(n)
            .flatMap(window ->
                window.toList().toObservable()); // convert each window to (Observable<Integer>)

    }

    /**35.	Monitor and print all lifecycle events (doOnNext, doOnComplete).**/
    public Observable<Integer> printLifeCycleEvents() {
        return
            Observable.range(1, 3)
            .doOnSubscribe(disposable -> System.out.println("Subscribed"))
            .doOnNext(item -> System.out.println("Emitting: " + item))
            .doOnComplete(() -> System.out.println("Stream completed"))
            .doOnError(error -> System.out.println("Error: " + error))
            .doFinally(() -> System.out.println("Stream ended (finally)"));
    }
    /**36.	Use scan() to show running total of values.**/
    @Override
    public Observable<Integer> useScanForSum(List<Integer> list){
        return
            Observable.fromIterable(list)
                .scan(Integer::sum);
    }
    /**37.	Use repeat() to repeat a stream N times.**/
    @Override
    public Observable<String> useRepeatObservable(List<String> list, int n){
        return
            Observable.fromIterable(list)
                .repeat(n);
    }

    /**38.	Use takeUntil() with a second observable.**/
    @Override
    public Observable<Long> takUntilAsSecondObservable(){
        Observable<Long> source = Observable.interval(500,TimeUnit.MILLISECONDS);
        Observable<Long> stopper = Observable.interval(2,TimeUnit.SECONDS);
        return source.takeUntil(stopper);

    }

    /**39.	Combine emissions with combineLatest().**/
    @Override
    public Observable<String> combineEmissionsWithCombineLatest()
    {
            Observable<String> letters = Observable
                .just("A", "B", "C")
                .zipWith(Observable.interval(100, TimeUnit.MILLISECONDS), (item, time) -> item);

        Observable<Integer> numbers = Observable
            .just(1, 2, 3)
            .zipWith(Observable.interval(150, TimeUnit.MILLISECONDS), (item, time) -> item);

        return
        Observable
            .combineLatest(
                letters,
                numbers,
                (letter, number) -> letter + number // combining function
            );
    }

    /**40.	Use amb() to emit from the fastest source.*/
    @Override
    public Observable<String> useAmbToGetEmitFromFatest(List<String> slowest, List<String> slower, List<String> fasts){

        Observable<String> slowObs = Observable.fromIterable(slowest).delay(100,TimeUnit.MILLISECONDS);
        Observable<String> normalObs = Observable.fromIterable(slower).delay(50,TimeUnit.MILLISECONDS);
        Observable<String> fasterObs = Observable.fromIterable(fasts).delay(10,TimeUnit.MILLISECONDS);

        return
            Observable.amb(Arrays.asList(slowObs,normalObs,fasterObs));
    }

    /**41.	Test Observable with TestObserver.*/
    public Single<Integer> testWithTestObserver(List<Integer> list){
        return
            Observable.fromIterable(list)
                .reduce(Integer::sum).toSingle();
    }
    /**42.	Test timeout and retry logic using TestScheduler.**/
    @Override
    public Observable<Long> fetchWithTimeoutAndRetry(Scheduler scheduler) {
        // Emits after 2 seconds
        return Observable.timer(2, TimeUnit.SECONDS, scheduler)
            .timeout(1, TimeUnit.SECONDS, scheduler) //accept it only if emit in 1 second
            .retry(2); // retry 2 more times
    }

    /**43.	Create a cold observable that becomes hot using publish().**/
    @Override
    public ConnectableObservable<String> convertColdToHotObservable(List<String> list){

            Observable<String> cold = Observable.interval(1,TimeUnit.SECONDS)
            .map(i-> list.get(i.intValue())).take(list.size());

            ConnectableObservable<String> hot = cold.publish();
            hot.connect();
            return hot;
    }
    /**44.	Use share() to multicast stream.**/
    @Override
    public Observable<Long> useShareToMulticast() {
       return Observable.interval(1, TimeUnit.SECONDS)
            .doOnNext(i -> System.out.println("Source emitted: " + i))
            .share(); // makes it hot and multicast
    }

    /**45.	Cache values with cache().**/
    @Override
    public Observable<String> useCacheValues(List<String> list){
        return
            Observable.fromIterable(list)
                .cache();
    }

    /**46.	Use Single.zip() for dependent API results.**/
    @Override
    public Single<String> useSingleZipForDependentApi(){
        Single<String> userSingle = RxUtils.getUser();
        Single<String> orderSingle = RxUtils.getOrder();

        return Single.zip(userSingle, orderSingle, (user, order) ->
            "Combined result → User: " + user + ", Order: " + order
        );
    }

    /**47.	Use Maybe to return optional result.**/
    @Override
    public Observable<Maybe<String>> useMaybe(List<String> list){
        return
            Observable.fromIterable(list)
                .map(RxUtils::findUserById);
    }

    /**48.	Use Completable to represent task without value.**/
    @Override
    public Completable useCompletable(String user){

        return RxUtils.saveUser(user);
    }
    /**49.	Use blockingGet() in test scenarios.**/
    @Override
    public Observable<Maybe<String>> useBlockingGetInTest(List<String> list){
        return useMaybe(list);
    }

    /**50.	Chain Observable to Single and back.**/
    @Override
    public Observable<String> chainObsToSingleBackObs(List<Integer> list){

        return
            Observable.fromIterable(list)
                .reduce(Integer::sum)
                .toObservable()
                .map(item -> "Sum of list: "+item);
    }

/* *Advanced (Concurrency, Custom Operators, Real-World Scenarios - 30+)*/

    /**51.	Implement a rate limiter using throttleFirst().**/
    @Override
    public Observable<Long> useRateLimiterThrottleFirst(){

        return
            Observable.interval(300,TimeUnit.MILLISECONDS)
                .take(10)
                .throttleFirst(1,TimeUnit.SECONDS);

    }
    /**52.	Design a typeahead/autocomplete using debounce().*/
    @Override
    public void designAutocompleteByDebounce() throws InterruptedException {
        PublishSubject<String> userInput = PublishSubject.create();

        userInput
            .debounce(300, TimeUnit.MILLISECONDS)         // Wait for user to pause typing
            .distinctUntilChanged()                       // Avoid duplicate search terms
            .switchMap(query -> RxUtils.search(query)
                .subscribeOn(Schedulers.io())         // Call API in background
            )
            .subscribe(result -> System.out.println("Suggestions: " + result));

        // Simulating user typing
        userInput.onNext("a");
        sleep(100);
        userInput.onNext("ap");
        sleep(100);
        userInput.onNext("app");
        sleep(400); // Wait > debounce time, triggers search
        userInput.onNext("appl");
        sleep(100);
        userInput.onNext("apple");
        sleep(500); // Triggers another search

        sleep(1000); // Wait to see all results

    }

    /**53.	Perform batch DB insert using buffer() and flatMap().**/
    public void batchInsertByBufferAndFlatMpa() throws InterruptedException {
        Observable.range(1, 20) // Simulate 20 items to insert
            .buffer(5) // Create batches of 5 items
            .flatMap(batch -> RxUtils.insertBatch(batch)
                .subscribeOn(Schedulers.io()) // Simulate async DB call
            )
            .subscribe(result -> System.out.println("Inserted batch: " + result));

        // Wait for all inserts to complete
        sleep(2000);
    }

    /**54.	Create a retry strategy with exponential backoff.**/
    @Override
    public void retryWithExponentialBackoff() throws  InterruptedException{

        AtomicInteger atomicInteger = new AtomicInteger();
        Observable.fromCallable(()->
        {
            int count = atomicInteger.getAndIncrement();
            System.out.println("Attempt: "+count);
            if(count<4)
                throw new RuntimeException("Failing on attempt :"+count);
            return "Success on attempt: "+count;
        })
        .subscribeOn(Schedulers.io())
        .retryWhen( error->
            error.zipWith(Observable.range(1,5),(e,retryCount)->retryCount)
                .flatMap( retryCount->
                {
                    long delay = (long) Math.pow(2, retryCount);
                    System.out.println("Retry #" + retryCount + " in " + delay + " sec");
                    return Observable.timer(delay, TimeUnit.SECONDS);
                })
            )
            .blockingSubscribe(System.out::println, e -> System.out.println("Final Error: " + e));
        sleep(5000);
    }

    /**55.	Parallel execution with flatMap() and Schedulers.io().**/
    @Override
    public Single<Integer> parallelFlatMapAndSchedular(List<Integer> list){

        return
           Observable.fromIterable(list)
               .flatMap( n->
                   Observable.fromCallable(()->
                   {
                       System.out.println("Squaring "+n+" on "+Thread.currentThread().getName());
                       TimeUnit.MILLISECONDS.sleep(200);
                       return n*n;
                   }).subscribeOn(Schedulers.io())
               )
               .observeOn(Schedulers.single())
               .reduce(Integer::sum)
               .toSingle();

    }

    /**56.	Switch execution between main and io thread.**/
    @Override
    public Observable<String> switchBtnMainSndIoThread(String str){

        return
            Observable.just(str)
                .doOnNext(item -> {
                    System.out.println("Before subscribeOn - running on: " + Thread.currentThread().getName());
                })
                .subscribeOn(Schedulers.io()) // Switch to IO thread for source
                .map(item -> {
                    System.out.println("Mapping on IO thread: " + Thread.currentThread().getName());
                    return item.toUpperCase();
                })
                .observeOn(Schedulers.trampoline()) // Switch back to main thread (trampoline = current thread)
                .map(result -> {
                    System.out.println("Received on main thread: " + Thread.currentThread().getName());
                    System.out.println("Final Result: " + result);
                    return result;
                });
    }

    /**57.	Write a custom ObservableTransformer.*/
    @Override
    public Observable<String> customObservableTransformer(List<String> list){


        Observable.fromIterable(list)
            .compose(new RxDesignUtils.CustomTransformer()).subscribe(System.out::println);;
        return
            Observable.fromIterable(list)
                .compose(new RxDesignUtils.CustomTransformer());
    }

    /**58.	Implement a simple EventBus using PublishSubject.**/
    @Override
    public void implEventBusByPublishSubject(List<MessageEvent> list)  {

        RxDesignUtils.RxSimpleEventBus eventBus = RxDesignUtils.RxSimpleEventBus.getInstance();
         eventBus.listen(MessageEvent.class)
             .subscribe(event -> System.out.println("Received: " + event.message));;

             Observable.fromIterable(list)
                 .observeOn(Schedulers.single())
                .subscribe(eventBus::post);
    }

    /**59.	Use BehaviorSubject to always emit the last value.**/
    @Override
    public void useBehaviorSubjectAlwaysEmitLast(){

       BehaviorSubject<String> subject = BehaviorSubject.create();
        // Emit first value
        subject.onNext("First");
        // First observer subscribes — gets "First"
        subject.subscribe(value -> System.out.println("Observer 1: " + value));
        // Emit another value
        subject.onNext("Second");
        // Second observer subscribes — gets "Second" (latest)
        subject.subscribe(value -> System.out.println("Observer 2: " + value));
        // Emit more values
        subject.onNext("Third");
    }
    /**60.	Create a cold observable with side-effect logging.**/
    public Observable<String> coldObserverWithLogging(){

       return
           Observable.<String>create(emitter -> {
                System.out.println("Creating data stream...");
                emitter.onNext("A");
                emitter.onNext("B");
                emitter.onNext("C");
                emitter.onComplete();
            })
            .doOnSubscribe(disposable -> System.out.println("Someone subscribed"))
            .doOnNext(item -> System.out.println("Emitting: " + item))
            .doOnComplete(() -> System.out.println("Stream complete"));
    }

    /**61.	Use ConnectableObservable with refCount().**/
    @Override
    public Observable<Long> useConnectableObservableWithRefCount(){
        Observable<Long> source = Observable
            .interval(1, TimeUnit.SECONDS)
            .doOnSubscribe(d -> System.out.println("!! Subscribed to source"))
            .doOnDispose(() -> System.out.println("X! Unsubscribed from source"));

        // Make it a ConnectableObservable and then auto-connect with refCount
        return source.publish().refCount();
    }
    /**62.	Cache latest result of network call for future subscribers.**/
    @Override
    public Observable<String> cacheLatestResultNetworkCall(){

        return
            Observable.fromCallable(()->
            {
                System.out.println("Calling network...");
                return "API Result: " + System.currentTimeMillis();
            })
                .cache(); // Caches result after first subscription
    }

    /**63.	Cancel an in-progress operation with Disposable.**/
    @Override
    public Observable<Long> cancelInProgressOperWithDisposable(){

        return
            Observable.interval(500,TimeUnit.MILLISECONDS)
                .doOnDispose(() -> System.out.println("X! Decomposing from source"));
    }

    /**64.	Use DisposableObserver to manage lifecycle.**/
    public void UseDisposableObserverToManageLifecycle(List<String> list){

        Observable<String> source = Observable.fromIterable(list);

        DisposableObserver<String> observer = new DisposableObserver<String>() {
            @Override
            public void onNext(@NonNull String s) {
                System.out.println("Received: " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.err.println("Error: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Completed");
            }
        };
        source.subscribe(observer);
        observer.dispose();
    }

    /**65.	Build a countdown timer with intervalRange().*/
    public void countdownTimerWithIntervalRange(int countDown) throws InterruptedException {
         RxDesignUtils.CountDownTimer.runCountDownTimer(countDown);
    }

    /**66.	Use generate() to emit Fibonacci sequence.**/
    @Override
    public void generateToEmitFibonacciSeq(int n){
        Observable.generate(
                () -> new long[]{0, 1, 0}, // {a, b, count}
                (state, emitter) -> {
                    if (state[2] >= 10) {
                        emitter.onComplete();
                    } else {
                        emitter.onNext(state[0]);
                        long next = state[0] + state[1];
                        state[0] = state[1];
                        state[1] = next;
                        state[2]++; // count++
                    }
                    return state;
                })
            .subscribe(
                item -> System.out.println("Fibonacci: " + item),
                Throwable::printStackTrace,
                () -> System.out.println("Done")
            );
    }

    /**67.	Integrate with a REST API returning Single<Response<T>>.**/
    @Override
    public Single<User> getRestAPiResponse(){
        return new UserServiceImpl().getUser("123")
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .flatMap(response -> {
                if ( response.getBody() != null) {
                    return Single.just(response.getBody());
                } else {
                    return Single.error(new RuntimeException("API error: " + response.getStatus()));
                }
            });
    }

    /**68.	Chain validation logic using flatMapCompletable().**/
    @Override
    public Completable chainValidationUsingFlatMapCompletable(Employee employee){
        return
            EmployeeValidation.validateUser(employee);
    }

    /**69.	Combine multiple Completable tasks with mergeArray().**/
    @Override
    public Completable combineManyCompletableUsingMergeArray(){
        Completable saveToDb = CompletableUtils.saveUserToDatabase();
        Completable sendEmail = CompletableUtils.sendWelcomeEmail();
        Completable logActivity = CompletableUtils.logUserRegistration();

        return
            Completable.mergeArray(saveToDb, sendEmail, logActivity);
    }

    /**70.	Collect multi-page API results using recursion and concatMap().**/
    @Override
    public Observable<Item> collectMultiPageResultRecursively(int page){
        return
            ObservableUtils.collectAllPages(page);
    }

/* *Bonus: Challenges & Patterns (20+)**/
    /**71.	Implement mergeSort using reactive recursion.**/
    @Override
    public Single<List<Integer>> implMergeSortRecursion(List<Integer> list){
           return
               RxAlgoUtils.mergeShort(list);
    }

    /**72.	Simulate a scheduler-like job queue.**/
    @Override
    public Observable<String> makeJobAsSchedular(List<Job> list){
        return
            Observable.fromIterable(list)
                .flatMap(ObservableUtils::executeJob)
                .subscribeOn(Schedulers.io());
    }

    /**73.	Retry only on specific exceptions.**/
    @Override
    public void retryOnlyOnSpecificExceptions() throws InterruptedException {

        AtomicInteger atomicInteger = new AtomicInteger(0);
        Observable.fromCallable(()->{
            int count = atomicInteger.getAndIncrement();
            System.out.println("Attempt #" + count);

            if (count < 3) {
                throw new IOException("Network error on attempt " + count);
            } else if (count == 3) {
                throw new IllegalArgumentException("Invalid data"); // should NOT retry
            }

            return "Success at attempt #" + count;

        }).retryWhen(errors ->
            errors.flatMap(error -> {
                if (error instanceof IOException) {
                    System.out.println("Retrying after IOException...");
                    return Observable.timer(1, TimeUnit.SECONDS);
                } else {
                    // Not retryable — propagate the error
                    return Observable.error(error);
                }
            })
        ).subscribe(
            result -> System.out.println("Result: " + result),
            error -> System.err.println("Stream failed: " + error.getMessage())
        );

        sleep(5000);
    }

    /**74.	Aggregate order data by user from stream of Order records.**/
    @Override
    public Observable<OrderSummary> aggDataByUser(List<EmpOrder> list){
        return
            Observable.fromIterable(list)
                .groupBy(EmpOrder::userId)
                .flatMapSingle(groupOrders ->
                    groupOrders.toList()
                        .map(orderList->{
                            double totalAmount = orderList.stream().mapToDouble(EmpOrder::amount).sum();
                            return new OrderSummary(groupOrders.getKey(),totalAmount,orderList.size());
                        })
                );

    }
    /**75.	Monitor service health with timeout and fallback.**/
    @Override
    public Single<String> monitorServiceHealthWithTimeoutAndFallBack(){
        return
            SingleUtils.checkServiceHealth()
            .subscribeOn(Schedulers.io());

    }

    /**76.	Reactive circuit breaker pattern with timeout + fallback.**/
    @Override
    public void designCircuitBreakerPattern() throws InterruptedException {
        RxDesignUtils.ReactiveCircuitBreaker.circuitBreaker();
    }
}

