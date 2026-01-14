package interview.preparation.company.interviews;


import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import io.reactivex.rxjava3.internal.functions.Functions;

import javax.swing.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Test {

    public static void main(String[] args) throws InterruptedException {
            System.out.println("Hi...");

        Cache<Integer, Character> userCache =
            Caffeine.newBuilder()
                .maximumSize(3)          // LRU size limit
                .recordStats()                // metrics
                .build();

        userCache.put(1,'a');
        userCache.put(2,'b');
        userCache.put(3,'c');
        userCache.put(4,'d');
        print(userCache);

    }
    public static void print(Cache<Integer, Character> userCache)
    {
        System.out.println(userCache.getIfPresent(4));
    }

}
