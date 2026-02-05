package com.anasouamira.androidsystemmaster.modules.async_coroutines

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.unit.dp


// Module 1: Async Coroutines
@Composable
fun AsyncModule() {

    val viewModel = remember { AsyncViewModel() } // Create ViewModel
    var state by remember { mutableStateOf(viewModel.uiState) } // Linking the UI to the status

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Module 1: Asynchronisme (Coroutines)")
        Text("State: $state")

        Button(onClick = {
            viewModel.loadUser()
            state = viewModel.uiState // UI update
        }) {
            Text("Load User")
        }

        Button(onClick = {
            viewModel.loadAll()
            state = viewModel.uiState
        }) {
            Text("Load User + Posts")
        }
    }
}

