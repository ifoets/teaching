package rx.design.analysis.rx.utils;

import io.reactivex.rxjava3.core.Observable;
import rx.design.analysis.rx.model.ApiResponse;
import rx.design.analysis.rx.record.Item;
import rx.design.analysis.rx.record.Job;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ObservableUtils {

    // Recursive page collector
   public static Observable<Item> collectAllPages(int page) {
        return fetchPage(page)
            .concatMap(response -> {
                Observable<Item> currentItems = Observable.fromIterable(response.items);
                if (response.hasNextPage) {
                    return currentItems.concatWith(collectAllPages(page + 1));
                } else {
                    return currentItems;
                }
            });
    }

    // Simulated paginated API
    public static Observable<ApiResponse> fetchPage(int page) {
        return Observable.fromCallable(() -> {
            // Simulated data
            List<Item> items = Arrays.asList(new Item("Item-" + page + "-A"), new Item("Item-" + page + "-B"));
            boolean hasNext = page < 3; // Simulate 3 pages
            System.out.println("Fetching page " + page);
            return new ApiResponse(items, hasNext);
        });
    }

    public static Observable<String> executeJob(Job job) {
        return Observable.just(job)
            .delay(job.durationSeconds(), TimeUnit.SECONDS)
            .doOnNext(j -> System.out.println("Executing " + j.name()))
            .map(j -> j.name() + " done");
    }
}
