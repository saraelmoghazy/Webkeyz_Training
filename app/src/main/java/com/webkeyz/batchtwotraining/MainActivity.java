package com.webkeyz.batchtwotraining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.webkeyz.batchtwotraining.rxJava.RxJavaActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.rxActivity_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rxActivity_button:{
                startActivity(new Intent(MainActivity.this, RxJavaActivity.class));
                break;
            }
        }
    }
}
