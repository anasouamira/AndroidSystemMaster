package com.anasouamira.androidsystemmaster.modules.jobscheduler

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun JobScreen() {
    val context = LocalContext.current
    Column(Modifier.padding(16.dp)) {
        Button(onClick = {
            val component = ComponentName(context, DemoJobService::class.java)
            val jobInfo = JobInfo.Builder(1, component)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setRequiresCharging(true)
                .build()
            val scheduler = context.getSystemService(JobScheduler::class.java)
            scheduler.schedule(jobInfo)
        }) {
            Text("Schedule Job")
        }
    }
}
