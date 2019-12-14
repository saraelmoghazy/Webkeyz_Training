package com.webkeyz.batchtwotraining;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class ChipsActivity extends AppCompatActivity {

    ConstraintLayout parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chips);

        parent = findViewById(R.id.parentView);

        findViewById(R.id.chip6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(parent,"Action is invoked", BaseTransientBottomBar.LENGTH_SHORT).show();
            }
        });

    }
}
