package com.anasouamira.androidsystemmaster.modules.async_coroutines

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AsyncViewModel : ViewModel() {

    // UI state
    var uiState by mutableStateOf("Idle")
        private set

    // Load user after delay
    fun loadUser() {
        uiState = "Loading User..."
        viewModelScope.launch {
            delay(2000) // simulate network
            uiState = "User: John Doe"
        }
    }

    // Load user + posts in parallel
    fun loadAll() {
        uiState = "Loading User and Posts..."
        viewModelScope.launch {
            val userDeferred = async { delay(2000); "John Doe" }
            val postsDeferred = async { delay(3000); listOf("Post 1", "Post 2") }

            val user = userDeferred.await()
            val posts = postsDeferred.await()

            uiState = "User: $user, Posts: ${posts.size}"
        }
    }
}
