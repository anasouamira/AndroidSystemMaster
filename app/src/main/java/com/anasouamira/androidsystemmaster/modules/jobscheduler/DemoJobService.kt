package com.anasouamira.androidsystemmaster.modules.jobscheduler

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log

class DemoJobService : JobService() {
    override fun onStartJob(params: JobParameters?): Boolean {
        Thread {
            Thread.sleep(3000)
            Log.d("JOB", "Job finished")
            jobFinished(params, false)
        }.start()
        return true
    }

    override fun onStopJob(params: JobParameters?) = true
}
