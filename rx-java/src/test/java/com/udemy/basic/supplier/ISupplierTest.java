package com.udemy.basic.supplier;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.GroupedObservable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ISupplierTest {

    ISupplier is;

    @Before
    public void init()
    {
        is = new SupplierImpl();
    }

    /** 1: Deferred Observable Creation with Observable.defer()*/
    @Test
    public void supplyStingTest()
    {
        String str = "Hello Supplier!!!";
        Observable<GroupedObservable<Integer, String>> observable = is.supplySting(str) ;
        System.out.println(observable);
    }
}
