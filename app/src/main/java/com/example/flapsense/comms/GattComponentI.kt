package com.example.flapsense.comms

import android.bluetooth.BluetoothGattCharacteristic

interface GattComponentI {
    fun requestReset(characteristic: BluetoothGattCharacteristic?)

    fun requestNotify(characteristic: BluetoothGattCharacteristic?)
    fun getCharacteristic(): BluetoothGattCharacteristic?
}