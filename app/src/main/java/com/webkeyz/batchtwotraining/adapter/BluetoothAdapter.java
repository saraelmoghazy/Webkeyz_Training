package com.webkeyz.batchtwotraining.adapter;

public class BluetoothAdapter {

    private RedtoothDevice redtoothDevice;
    private Device device;

    public BluetoothAdapter(Device device) {
        this.device = device;
    }

    public void connectRedtoothDevice(RedtoothDevice redtoothDevice) {
        this.redtoothDevice = redtoothDevice;
        BluetoothDevice bluetoothDevice = new BluetoothDevice(redtoothDevice.getName());
        device.connect(bluetoothDevice);
    }
}
