package com.webkeyz.batchtwotraining.adapter;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.webkeyz.batchtwotraining.R;

public class AdapterActivity extends AppCompatActivity {
    Device device;
    BluetoothDevice bluetoothDevice;
    RedtoothDevice redtoothDevice;
    BluetoothAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);

        device = new Device();

        bluetoothDevice = new BluetoothDevice("bluetooth");
        redtoothDevice = new RedtoothDevice("redtooth");

        adapter = new BluetoothAdapter(device);

        connectDevices();

    }

    public void connectDevices() {
        device.connect(bluetoothDevice);
        adapter.connectRedtoothDevice(redtoothDevice);
    }
}
