package com.anasouamira.androidsystemmaster.modules.permissions

import android.Manifest
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp



@Composable
fun PermissionScreen() {
    val context = LocalContext.current

    // Launcher to request permission
    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) Log.d("PERM", "Permission granted")
        else Log.d("PERM", "Permission denied")
    }

    Column(Modifier.padding(16.dp)) {
        Text("Permissions Module")
        Button(onClick = {
            launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }) {
            Text("Request Location Permission")
        }
    }
}

