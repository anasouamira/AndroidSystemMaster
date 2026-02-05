package com.anasouamira.androidsystemmaster.modules.async_coroutines

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


/**
 * ViewModel of the Asynchronism model
 * Contains asynchronous data loading logic
 */
class AsyncViewModel : ViewModel() {

    // The situation we display in the UI
    var uiState: String = "Idle"
        private set

    /**
     *Loading username after a 2-second delay
     */
    fun loadUser() {
        uiState = "Loading User..."
        viewModelScope.launch {
            delay(2000) // Simulating a data request from the network
            uiState = "User: John Doe"
        }
    }

    /**
     *Upload username + posts at the same time
     */
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

