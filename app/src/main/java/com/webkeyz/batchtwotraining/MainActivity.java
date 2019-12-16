package com.webkeyz.batchtwotraining;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.webkeyz.batchtwotraining.adapter.AdapterActivity;
import com.webkeyz.batchtwotraining.builder.Car;
import com.webkeyz.batchtwotraining.factory.Vehicle;
import com.webkeyz.batchtwotraining.factory.VehicleFactory;
import com.webkeyz.batchtwotraining.observer.ObserverActivity;
import com.webkeyz.batchtwotraining.singleton.Singleton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = findViewById(R.id.constraintLayoutBuilder);
        findViewById(R.id.observer_button).setOnClickListener(this);
        findViewById(R.id.adapter_button).setOnClickListener(this);
        findViewById(R.id.builder_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Car.Builder carBuilder = new Car.Builder()
                        .setModel("Jeep")
                        .setEngineType("electric")
                        .setNoOfSeats("4");
                Car car = carBuilder.build();
                Snackbar.make(constraintLayout, "car built: " + car.toString(), BaseTransientBottomBar.LENGTH_LONG).show();
            }
        });
        findViewById(R.id.singleton_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singleton singleton1 = Singleton.getInstance();
                singleton1.setName("the only instance");
                Log.d(TAG, "onClick: name1: " + singleton1.getName());
                // trying to get another instance
                Singleton singleton2 = Singleton.getInstance();
                Log.d(TAG, "onClick: name2: " + singleton2.getName());
            }
        });
        findViewById(R.id.factory_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vehicle vehicle = VehicleFactory.getVehicle("truck");
                vehicle.create();
                vehicle = VehicleFactory.getVehicle("motorcycle");
                vehicle.create();
                vehicle = VehicleFactory.getVehicle("sportcar");
                vehicle.create();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.observer_button: {
                startActivity(new Intent(MainActivity.this, ObserverActivity.class));
                break;
            }
            case R.id.adapter_button: {
                startActivity(new Intent(MainActivity.this, AdapterActivity.class));
                break;
            }
        }
    }
}
