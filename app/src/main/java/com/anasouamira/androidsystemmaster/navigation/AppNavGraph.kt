package com.anasouamira.androidsystemmaster.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import com.anasouamira.androidsystemmaster.modules.async_coroutines.AsyncScreen
import com.anasouamira.androidsystemmaster.modules.workmanager.WorkScreen
import com.anasouamira.androidsystemmaster.modules.jobscheduler.JobScreen
import com.anasouamira.androidsystemmaster.modules.alarmmanager.AlarmScreen
import com.anasouamira.androidsystemmaster.modules.permissions.PermissionScreen
import com.anasouamira.androidsystemmaster.modules.location.LocationScreen
import com.anasouamira.androidsystemmaster.modules.contentresolver.ContentScreen
import com.anasouamira.androidsystemmaster.modules.bluetooth.BluetoothScreen
import com.anasouamira.androidsystemmaster.ui.HomeScreen
import com.anasouamira.androidsystemmaster.ui.theme.AndroidSystemMasterTheme


@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {

        composable("home") { HomeScreen(navController) }

        composable("async") { AsyncScreen() }
        composable("work") { WorkScreen() }
        composable("job") { JobScreen() }
        composable("alarm") { AlarmScreen() }
        composable("perm") { PermissionScreen() }
        composable("location") { LocationScreen() }
        composable("content") { ContentScreen() }
        composable("bluetooth") { BluetoothScreen() }
//        composable("unit") { UnitTestsModule() }
//        composable("ui") { UITestsModule() }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidSystemMasterTheme {
        AppNavGraph()
    }
}