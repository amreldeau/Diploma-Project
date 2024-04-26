package com.example.findme.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.getstream.chat.android.client.ChatClient
import io.getstream.video.android.model.User
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {
    /*fun connectUser(user: User, token: String) {

        viewModelScope.launch {

            val client = ChatClient.instance()

            client.connectUser(user, token).enqueue { result ->
                when (result) {
                    is Result.Success -> {
                        // Handle success, e.g., navigate to chat screen
                    }
                    is Result.Failure -> {
                        // Handle error, e.g., show error message
                    }
                }
            }
        }
    }*/
}