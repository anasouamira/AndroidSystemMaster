package com.anasouamira.androidsystemmaster.modules.async_coroutines

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anasouamira.androidsystemmaster.ui.theme.AndroidSystemMasterTheme


// Module 1: Async Coroutines
@Composable
fun AsyncScreen() {
    val viewModel = remember { AsyncViewModel() }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Module 1: Asynchronisme (Coroutines)",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.loadUserAndPosts() }) {
            Text("Load User + Posts")
        }
        Spacer(modifier = Modifier.height(16.dp))
        when (val current = viewModel.uiState) {
            is AsyncViewModel.UiState.Idle -> Text("Press the button to load data")
            is AsyncViewModel.UiState.Loading -> Text("Loading...")
            is AsyncViewModel.UiState.Success -> {
                Text("User: ${current.data.name}", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(8.dp))
                LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(current.data.posts) { post ->
                        // Each post is in the form of a card
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    color = Color(0xFFE0F7FA),
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .padding(12.dp)
                        ) {
                            Text(post)
                        }
                    }
                }
            }
            is AsyncViewModel.UiState.Error -> Text("Error: ${current.message}", color = Color.Red)
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidSystemMasterTheme {
        AsyncScreen()
    }
}

