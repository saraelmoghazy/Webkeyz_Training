package com.webkeyz.batchtwotraining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MaterialDesignComponentsActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MaterialDesignComponent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_design_components);

        Log.d(TAG, "onCreate: Material design created");

        findViewById(R.id.dialogButton).setOnClickListener(this);
        findViewById(R.id.bottomActionButton).setOnClickListener(this);
        findViewById(R.id.bottomSheet).setOnClickListener(this);
        findViewById(R.id.materialCard).setOnClickListener(this);
        findViewById(R.id.chipsButton).setOnClickListener(this);
        findViewById(R.id.textFieldButton).setOnClickListener(this);
        findViewById(R.id.collapsingToolBar).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.dialogButton:{
                new MaterialAlertDialogBuilder(this)
                        .setTitle("I am a Dialogue")
                        .setMessage("This item is not available")
                        .setPositiveButton("Ok", null)
                        .show();
                break;
            }
            case R.id.bottomActionButton:{
                startActivity(new Intent(MaterialDesignComponentsActivity.this, BottomAppBarActivity.class));
                break;
            }
            case R.id.bottomSheet:{
                startActivity(new Intent(MaterialDesignComponentsActivity.this,BottomSheetsActivity.class));
            }
            case R.id.materialCard:{
                startActivity(new Intent(MaterialDesignComponentsActivity.this,MaterialCardActivity.class));
            }case R.id.chipsButton:{
                startActivity(new Intent(MaterialDesignComponentsActivity.this,ChipsActivity.class));
            }case R.id.textFieldButton:{
                startActivity(new Intent(MaterialDesignComponentsActivity.this,TextFieldActivity.class));
            }case R.id.collapsingToolBar:{
                startActivity(new Intent(MaterialDesignComponentsActivity.this,CollapsingToolBarActivity.class));
            }
        }
    }
}
