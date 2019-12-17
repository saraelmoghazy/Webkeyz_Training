package com.webkeyz.batchtwotraining.rxJava;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class CombiningObservables {

    Observable<String> stringObservable1 = Observable
            .interval(1, TimeUnit.SECONDS)
            .takeWhile(new Predicate<Long>() {
                @Override
                public boolean test(Long aLong) throws Exception {
                    return aLong <= 3;
                }
            })
            .map(new Function<Long, String>() {
                @Override
                public String apply(Long aLong) throws Exception {
                    return "A" + aLong;
                }
            });

    Observable<String> stringObservable2 = Observable
            .interval(1, TimeUnit.SECONDS)
            .takeWhile(new Predicate<Long>() {
                @Override
                public boolean test(Long aLong) throws Exception {
                    return aLong <= 3;
                }
            })
            .map(new Function<Long, String>() {
                @Override
                public String apply(Long aLong) throws Exception {
                    return "B" + aLong;
                }
            });

    public Observable<String> mergeOperator() {
        Observable<String> stringObservable = Observable
                .merge(stringObservable1, stringObservable2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return stringObservable;
    }

}
