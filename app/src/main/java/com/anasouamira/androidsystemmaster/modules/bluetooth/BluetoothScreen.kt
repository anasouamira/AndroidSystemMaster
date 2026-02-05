package com.anasouamira.androidsystemmaster.modules.bluetooth

import android.bluetooth.BluetoothManager
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun BluetoothScreen() {
    val context = LocalContext.current
    val manager = remember { BluetoothManager(context) }
    var devices by remember { mutableStateOf(listOf<String>()) }

    Column(Modifier.padding(16.dp)) {
        Button(onClick = {
            devices = manager.getPairedDevices()?.map { it.name } ?: emptyList()
        }) {
            Text("Load Paired Devices")
        }
        LazyColumn {
            items(devices) { Text(it) }
        }
    }
}
