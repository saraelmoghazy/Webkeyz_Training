package com.webkeyz.batchtwotraining.rxJava;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.webkeyz.batchtwotraining.R;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class RxJavaActivity extends AppCompatActivity {
    private static final String TAG = "RxJavaActivity";
    // ui components
    MaterialButton createOperatorButton, justOperatorButton, rangeOperatorButton,
            mapOperatorButton, switchMapOperatorButton;
    // vars
    CompositeDisposable disposable;
    CreatingObservables creatingObservables;
    TransformingObservables transformingObservables;
    List<String> alphabets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);

        createOperatorButton = findViewById(R.id.createOperator_button);
        justOperatorButton = findViewById(R.id.justOperator_button);
        rangeOperatorButton = findViewById(R.id.rangeOperator_button);
        mapOperatorButton = findViewById(R.id.mapOperator_button);
        switchMapOperatorButton = findViewById(R.id.switchMapOperator_button);
        disposable = new CompositeDisposable();
        creatingObservables = new CreatingObservables();
        transformingObservables = new TransformingObservables();
        alphabets = getAlphabetList();
    }

    @Override
    protected void onResume() {
        super.onResume();
        createOperator();
        justOperator();
        rangeOperator();
        mapOperator();
        switchMapOperator();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }

    private void switchMapOperator() {
        switchMapOperatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transformingObservables.switchMapOperator()
                        .subscribe(new Observer<Integer>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                disposable.add(d);
                            }

                            @Override
                            public void onNext(Integer integer) {
                                Log.d(TAG, "onNext: " + integer);
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {
                                Log.d(TAG, "onComplete switch map: CALLED");
                            }
                        });
            }
        });
    }

    private void mapOperator() {
        mapOperatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transformingObservables.mapOperator()
                        .subscribe(new Observer<Integer>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                disposable.add(d);
                            }

                            @Override
                            public void onNext(Integer integer) {
                                Log.d(TAG, "onNext: " + integer);
                            }

                            @Override
                            public void onError(Throwable e) {
                            }

                            @Override
                            public void onComplete() {
                                Log.d(TAG, "onComplete map: CALLED");
                            }
                        });
            }
        });
    }

    private void rangeOperator() {
        rangeOperatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creatingObservables.rangeOperator(3, 8)
                        .subscribe(new Observer<Integer>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                disposable.add(d);
                            }

                            @Override
                            public void onNext(Integer integer) {
                                Log.d(TAG, "onNext: " + integer);
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {
                                Log.d(TAG, "onComplete range: CALLED");
                            }
                        });
            }
        });
    }

    private void justOperator() {
        justOperatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creatingObservables.justOperator(alphabets)
                        .subscribe(new Observer<List<String>>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                disposable.add(d);
                            }

                            @Override
                            public void onNext(List<String> strings) {
                                Log.d(TAG, "onNext: " + strings.toString());
                            }

                            @Override
                            public void onError(Throwable e) {
                            }

                            @Override
                            public void onComplete() {
                                Log.d(TAG, "onComplete just: CALLED");
                            }
                        });
            }
        });
    }

    private void createOperator() {
        createOperatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creatingObservables.createOperator(alphabets)
                        .subscribe(new Observer<String>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                disposable.add(d);
                            }

                            @Override
                            public void onNext(String s) {
                                Log.d(TAG, "onNext: " + s);
                            }

                            @Override
                            public void onError(Throwable e) {
                            }

                            @Override
                            public void onComplete() {
                                Log.d(TAG, "onComplete create: CALLED");
                            }
                        });
            }
        });
    }

    public List<String> getAlphabetList() {
        List<String> alphabet = new ArrayList<>();
        alphabet.add("a");
        alphabet.add("b");
        alphabet.add("c");
        alphabet.add("d");
        alphabet.add("e");
        alphabet.add("f");
        return alphabet;
    }
}
