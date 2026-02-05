package com.anasouamira.androidsystemmaster.modules.location

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
fun LocationScreen() {
    val context = LocalContext.current
    val manager = remember { LocationManager(context) }

    var locationText by remember { mutableStateOf("No location yet") }

    Column(Modifier.padding(16.dp)) {
        Text(locationText)
        Button(onClick = {
            manager.getLastLocation { loc ->
                if (loc != null) locationText = "Lat: ${loc.latitude}, Lng: ${loc.longitude}"
            }
        }) {
            Text("Get Location")
        }
    }
}
