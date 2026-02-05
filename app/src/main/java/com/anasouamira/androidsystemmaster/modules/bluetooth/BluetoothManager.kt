package com.anasouamira.androidsystemmaster.modules.bluetooth

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.Context
import androidx.annotation.RequiresPermission

class BluetoothManager(private val context: Context) {

    private val bluetoothAdapter: BluetoothAdapter? =
        (context.getSystemService(Context.BLUETOOTH_SERVICE)
                as android.bluetooth.BluetoothManager).adapter

    fun isEnabled() = bluetoothAdapter?.isEnabled == true

    @RequiresPermission(Manifest.permission.BLUETOOTH_CONNECT)
    fun getPairedDevices(): Set<BluetoothDevice> {
        return bluetoothAdapter?.bondedDevices ?: emptySet()
    }
}

