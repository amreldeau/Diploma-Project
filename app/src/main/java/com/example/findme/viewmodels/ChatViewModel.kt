package com.example.findme.viewmodels

import android.app.Application
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.findme.FirebaseAuthentication
import com.google.firebase.auth.FirebaseAuth
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.models.InitializationState
import kotlinx.coroutines.launch
import io.getstream.chat.android.models.User
import kotlinx.coroutines.launch
import io.getstream.result.Result.Failure
import io.getstream.result.Result.Success
import io.getstream.video.android.core.Call
import io.getstream.video.android.core.ClientState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ChatViewModel(application: Application) : AndroidViewModel(application) {

    private val chatClient: ChatClient = (application as FirebaseAuthentication).chatClient

    val clientInitialisationState: Flow<InitializationState> = chatClient.clientState.initializationState
}