package com.anasouamira.androidsystemmaster.modules.async_coroutines

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


// Module 1: Async Coroutines
@Composable
fun AsyncScreen(viewModel: AsyncViewModel = AsyncViewModel()) {
    val state = viewModel.uiState
    Column(
        Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("State: $state")
        Button(onClick = { viewModel.loadUser() }) {
            Text("Load User")
        }
        Button(onClick = { viewModel.loadAll() }) {
            Text("Load User + Posts")
        }
    }
}

