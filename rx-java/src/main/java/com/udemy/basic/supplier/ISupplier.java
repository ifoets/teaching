package com.udemy.basic.supplier;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.GroupedObservable;

public interface ISupplier {

    /** 1: Deferred Observable Creation with Observable.defer()*/
    Observable<GroupedObservable<Integer, String>> supplySting(String str);
}
