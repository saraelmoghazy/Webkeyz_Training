package com.webkeyz.batchtwotraining;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.card.MaterialCardView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MaterialCardActivity extends AppCompatActivity {

    private static final String TAG = "MaterialCardActivity";

    MaterialCardView mMaterialCardView1;
    ConstraintLayout mConstraintLayout;
    DraggableCoordinatorLayout draggedContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_card);

        Log.d(TAG, "onCreate: CREATED");

        mConstraintLayout = findViewById(R.id.parent_view);
        mMaterialCardView1 = findViewById(R.id.materialCard1);
        draggedContainer = findViewById(R.id.draggedLayout);
        draggedContainer.addDraggableChild(mMaterialCardView1);
        draggedContainer.setViewDragListener(new DraggableCoordinatorLayout.ViewDragListener() {
            @Override
            public void onViewCaptured(@NonNull View view, int i) {
                mMaterialCardView1.setDragged(true);
            }

            @Override
            public void onViewReleased(@NonNull View view, float v, float v1) {
                mMaterialCardView1.setDragged(false);
            }
        });

        mMaterialCardView1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (!mMaterialCardView1.isChecked()) {
                    mMaterialCardView1.setChecked(true);
                } else {
                    mMaterialCardView1.setChecked(false);
                }
                return false;
            }
        });
    }
}
