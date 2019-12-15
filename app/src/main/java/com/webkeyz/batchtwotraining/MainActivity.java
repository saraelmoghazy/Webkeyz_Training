package com.webkeyz.batchtwotraining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.webkeyz.batchtwotraining.fragments.Main2Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.activityTransition).setOnClickListener(this);
        findViewById(R.id.fragmentTransition).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activityTransition:{
                startActivity(new Intent(MainActivity.this,ActivityTransitionActivity.class));
                break;
            }case R.id.fragmentTransition:{
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
                break;
            }
        }
    }
}
