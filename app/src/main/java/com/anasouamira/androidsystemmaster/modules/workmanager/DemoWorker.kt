package com.anasouamira.androidsystemmaster.modules.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class DemoWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
        Thread.sleep(3000) // simulate background work
        Log.d("WORK", "Task finished")
        return Result.success()
    }
}
