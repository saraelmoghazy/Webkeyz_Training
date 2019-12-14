package com.webkeyz.batchtwotraining;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class BottomSheetsActivity extends AppCompatActivity {

    private static final String TAG = "BottomSheetsActivity";

    BottomSheetBehavior mSheetBehavior;
    ConstraintLayout constraint;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheets);

        Log.d(TAG, "onCreate: CREATED");

        constraint = findViewById(R.id.bottom_sheet_constraint);
        mButton = findViewById(R.id.buttonSheet);

        mSheetBehavior = BottomSheetBehavior.from(constraint);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

    }
}
