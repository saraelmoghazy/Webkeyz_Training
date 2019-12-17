package com.webkeyz.batchtwotraining.rxJava;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CreatingObservables {

    public Observable<Integer> rangeOperator(int startingPoint, int length) {
        Observable<Integer> integerObservable = Observable.range(startingPoint, length)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return integerObservable;
    }

    public Observable<List<String>> justOperator(List<String> alphabets) {
        Observable<List<String>> stringObservable = Observable.just(alphabets)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return stringObservable;
    }

    public Observable<String> createOperator(final List<String> alphabets) {
        Observable<String> stringObservable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                for (String alphabet : alphabets) {
                    emitter.onNext(alphabet);
                }
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return stringObservable;
    }

}
