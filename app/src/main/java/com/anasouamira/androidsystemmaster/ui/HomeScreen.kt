package com.anasouamira.androidsystemmaster.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Text(
            text = "Android System Master",
            style = MaterialTheme.typography.headlineMedium
        )

        Button(onClick = { navController.navigate("async") }) {
            Text("Asynchronisme (Coroutines)")
        }

        Button(onClick = { navController.navigate("work") }) {
            Text("WorkManager")
        }

        Button(onClick = { navController.navigate("job") }) {
            Text("JobScheduler")
        }

        Button(onClick = { navController.navigate("alarm") }) {
            Text("AlarmManager")
        }

        Button(onClick = { navController.navigate("perm") }) {
            Text("Permissions")
        }

        Button(onClick = { navController.navigate("location") }) {
            Text("Location")
        }

        Button(onClick = { navController.navigate("content") }) {
            Text("ContentResolver")
        }

        Button(onClick = { navController.navigate("bluetooth") }) {
            Text("Bluetooth")
        }

        Button(onClick = { navController.navigate("unit") }) {
            Text("Unit Tests")
        }

        Button(onClick = { navController.navigate("ui") }) {
            Text("UI Tests")
        }
    }
}