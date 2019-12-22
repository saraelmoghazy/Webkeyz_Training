package com.webkeyz.batchtwotraining;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkContinuation;
import androidx.work.WorkManager;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WorkManager manager = WorkManager.getInstance(getApplicationContext());
        final Constraints constraints = new Constraints.Builder()
                .setRequiresDeviceIdle(true)
                .setRequiresCharging(true)
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build();
        final OneTimeWorkRequest customRequest = new OneTimeWorkRequest.Builder(CustomWorker.class)
                .setConstraints(constraints)
                .setInitialDelay(5, TimeUnit.SECONDS)
                .setBackoffCriteria(BackoffPolicy.LINEAR, 5, TimeUnit.SECONDS)
                .build();
        final OneTimeWorkRequest secondRequest = new OneTimeWorkRequest.Builder(SecondWorker.class).build();

        WorkContinuation continuation = manager.beginWith(customRequest);
        continuation = continuation.then(secondRequest);

        final WorkContinuation finalContinuation = continuation;
        findViewById(R.id.button_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalContinuation.enqueue();
            }
        });
    }
}