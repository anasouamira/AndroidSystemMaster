package com.anasouamira.androidsystemmaster.modules.workmanager

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

@Composable
fun WorkScreen() {
    val context = LocalContext.current

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Module 2: WorkManager")

        Button(onClick = {
            // مهمة مرة واحدة
            val workRequest =
                OneTimeWorkRequestBuilder<SyncPostsWorker>().build()

            WorkManager.getInstance(context).enqueue(workRequest)
        }) {
            Text("Sync Posts Once")
        }

        Button(onClick = {
            // مهمة متكررة كل 15 دقيقة
            val periodicWork =
                PeriodicWorkRequestBuilder<SyncPostsWorker>(
                    15, TimeUnit.MINUTES
                ).build()

            WorkManager.getInstance(context).enqueue(periodicWork)
        }) {
            Text("Auto Sync Every 15 min")
        }
    }
}