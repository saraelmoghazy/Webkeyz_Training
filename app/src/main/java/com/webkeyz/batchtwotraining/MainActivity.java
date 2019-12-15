package com.webkeyz.batchtwotraining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.webkeyz.batchtwotraining.fragments.Main2Activity;
import com.webkeyz.batchtwotraining.lottie_animation.LottieAnimationsActivity;
import com.webkeyz.batchtwotraining.recyclerview_animation.RecyclerViewAnimationActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.activityTransition).setOnClickListener(this);
        findViewById(R.id.fragmentTransition).setOnClickListener(this);
        findViewById(R.id.recyclerAnimationButton).setOnClickListener(this);
        findViewById(R.id.shimmerLayout_button).setOnClickListener(this);
        findViewById(R.id.lottieAnimation_button).setOnClickListener(this);

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
            }case R.id.recyclerAnimationButton:{
                startActivity(new Intent(MainActivity.this, RecyclerViewAnimationActivity.class));
                break;
            }case R.id.shimmerLayout_button:{
                startActivity(new Intent(MainActivity.this, ShimmerLayoutActivity.class));
                break;
            }case R.id.lottieAnimation_button:{
                startActivity(new Intent(MainActivity.this, LottieAnimationsActivity.class));
                break;
            }
        }
    }
}
