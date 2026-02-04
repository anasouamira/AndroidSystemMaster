package com.anasouamira.androidsystemmaster.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.androidsystemmaster.modules.async_coroutines.AsyncModule
import com.example.androidsystemmaster.modules.workmanager.WorkManagerModule
import com.example.androidsystemmaster.modules.jobscheduler.JobSchedulerModule
import com.example.androidsystemmaster.modules.alarmmanager.AlarmManagerModule
import com.example.androidsystemmaster.modules.permissions.PermissionsModule
import com.example.androidsystemmaster.modules.location.LocationModule
import com.example.androidsystemmaster.modules.contentresolver.ContentResolverModule
import com.example.androidsystemmaster.modules.bluetooth.BluetoothModule
import com.example.androidsystemmaster.modules.unittests.UnitTestsModule
import com.example.androidsystemmaster.modules.uitests.UITestsModule
import com.example.androidsystemmaster.ui.HomeScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {

        composable("home") { HomeScreen(navController) }

        composable("async") { AsyncModule() }
        composable("work") { WorkManagerModule() }
        composable("job") { JobSchedulerModule() }
        composable("alarm") { AlarmManagerModule() }
        composable("perm") { PermissionsModule() }
        composable("location") { LocationModule() }
        composable("content") { ContentResolverModule() }
        composable("bluetooth") { BluetoothModule() }
        composable("unit") { UnitTestsModule() }
        composable("ui") { UITestsModule() }
    }
}