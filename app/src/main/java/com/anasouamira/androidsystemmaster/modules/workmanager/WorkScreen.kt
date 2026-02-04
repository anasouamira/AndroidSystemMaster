package com.anasouamira.androidsystemmaster.modules.workmanager

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

@Composable
fun WorkScreen() {
    val context = LocalContext.current
    Column(Modifier.padding(16.dp)) {
        Button(onClick = {
            val workRequest = OneTimeWorkRequestBuilder<DemoWorker>().build()
            WorkManager.getInstance(context).enqueue(workRequest)
        }) {
            Text("Start Background Work")
        }
    }
}