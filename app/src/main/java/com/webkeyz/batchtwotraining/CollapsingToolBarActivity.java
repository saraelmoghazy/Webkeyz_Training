package com.webkeyz.batchtwotraining;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.List;

public class CollapsingToolBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_tool_bar);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbarLayout));

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingToolBarLayout);
        collapsingToolbarLayout.setTitle("This Is Egypt");
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.white));
    }
}
