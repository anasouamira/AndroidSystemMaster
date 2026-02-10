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
    // The state we display in the UI
    var uiState by mutableStateOf<UiState>(UiState.Idle)
        private set
    // Data class representing the user and their posts
    data class UserData(val name: String, val posts: List<String>)
    // UI case representation
    sealed class UiState {
        object Idle : UiState()
        object Loading : UiState()
        data class Success(val data: UserData) : UiState()
        data class Error(val message: String) : UiState()
    }
    /**
     * User Upload + Posts
     * Note: This is a simulated data setup without a server.
     */
    fun loadUserAndPosts() {
        uiState = UiState.Loading
        viewModelScope.launch {
            try {
                // Data request simulation
                val userDeferred = async { delay(2000); "Anas Ouamira" }
                val postsDeferred = async { delay(3000); listOf("Post 1", "Post 2", "Post 3") }

                val user = userDeferred.await()
                val posts = postsDeferred.await()

                uiState = UiState.Success(UserData(user, posts))
            } catch (e: Exception) {
                uiState = UiState.Error("Failed to load data")
            }
        }
    }
}

