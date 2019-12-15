package com.webkeyz.batchtwotraining.recyclerview_animation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.webkeyz.batchtwotraining.R;

public class RecyclerViewAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_animation);

        findViewById(R.id.linearRecyclerViewButton).setOnClickListener(this);
        findViewById(R.id.staggeredRecyclerViewButton).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.linearRecyclerViewButton:{
                startActivity(new Intent(RecyclerViewAnimationActivity.this, LinearRecyclerViewActivity.class));
                break;
            } case R.id.staggeredRecyclerViewButton:{
                startActivity(new Intent(RecyclerViewAnimationActivity.this, StaggeredRecyclerViewActivity.class));
                break;
            }
        }
    }
}
