package com.udemy.basic.supplier;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.observables.GroupedObservable;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SupplierImpl implements ISupplier{

    /** 1: Deferred Observable Creation with Observable.defer(), count world*/
    public Observable<GroupedObservable<Integer, String>> supplySting(String str){
        Supplier<Observable<String>> observableSupplier = () -> Observable.just(str);
         return Observable.
             defer(observableSupplier)
             .groupBy(String::length);
    }
}
