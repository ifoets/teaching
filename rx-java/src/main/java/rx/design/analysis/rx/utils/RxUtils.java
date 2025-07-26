package rx.design.analysis.rx.utils;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import rx.design.analysis.rx.record.Order;
import rx.design.analysis.rx.record.Post;
import rx.design.analysis.rx.record.Profile;
import rx.design.analysis.rx.record.User;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RxUtils {

    public static Observable<User> getUsers() {
        List<User> users = Arrays.asList(
            new User("1", "Alice"),
            new User("2", "Bob")
        );
        return Observable.fromIterable(users).delay(500, TimeUnit.MILLISECONDS);
    }

    public static Observable<Order> getOrdersForUser(User user) {
        List<Order> orders = Arrays.asList(
            new Order("Order1 for " + user.name()),
            new Order("Order2 for " + user.name())
        );
        return Observable.fromIterable(orders).delay(300, TimeUnit.MILLISECONDS);
    }
    // Simulated blocking API (e.g., JDBC call, HTTP client, etc.)
    public static String blockingApiCall() {
        try {
            Thread.sleep(1000); // Simulate blocking delay
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Blocking result";
    }

    // Each inner observable emits 5 items, 1 per second
    public static Observable<String> getInnerStream(Long id) {
        return Observable.interval(100, TimeUnit.MILLISECONDS)
            .take(5)
            .map(i -> "Inner(" + id + "): " + i);
    }

    public static Single<User> login(String username, String password) {
        return Single.fromCallable(() -> {
            System.out.println("Logging in...");
            TimeUnit.SECONDS.sleep(1); // simulate network delay
            return new User("u123", username);
        });
    }

    public static Single<Profile> fetchProfile(String userId) {
        return Single.fromCallable(() -> {
            System.out.println("Fetching profile for userId: " + userId);
            TimeUnit.SECONDS.sleep(1);
            return new Profile("p456", userId);
        });
    }

    public static Single<List<Post>> fetchPosts(String profileId) {
        return Single.fromCallable(() -> {
            System.out.println("Fetching posts for profileId: " + profileId);
            TimeUnit.SECONDS.sleep(1);
            return List.of(
                new Post("post1", "Hello World!"),
                new Post("post2", "RxJava is awesome!")
            );
        });
    }

    // Simulate API call to get user
    public static Single<String> getUser() {
        return Single.fromCallable(() -> {
            Thread.sleep(1000); // simulate delay
            return "John Doe";
        });
    }

    // Simulate API call to get order
    public static Single<String> getOrder() {
        return Single.fromCallable(() -> {
            Thread.sleep(500); // simulate delay
            return "Order#123";
        });
    }

    public static Maybe<String> findUserById(String id) {
        if ("123".equals(id)) {
            return Maybe.just("John Doe"); // user exists
        }else if("234".equals(id))
        {
            return Maybe.just("Abhi kumar");
        }
        else {
            return Maybe.empty();         // user not found
        }
    }

    public static Completable saveUser(String name) {
        return Completable.fromRunnable(() -> {
            // Simulate save operation
            try {
                Thread.sleep(1000); // pretend saving
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Saving user: " + name);
            // throw new RuntimeException("DB error"); // uncomment to test failure
        });
    }
    // Simulate a search call
    public static Observable<List<String>> search(String query) {
        System.out.println("Searching for: " + query);
        return Observable.just(Arrays.asList(query + "1", query + "2", query + "3"))
            .delay(200, TimeUnit.MILLISECONDS); // Simulate network delay
    }

    // Simulate batch DB insert
    public static Observable<List<Integer>> insertBatch(List<Integer> batch) {
        System.out.println("Inserting: " + batch);
        return Observable.just(batch)
            .delay(100, TimeUnit.MILLISECONDS); // Simulate DB latency
    }

}
