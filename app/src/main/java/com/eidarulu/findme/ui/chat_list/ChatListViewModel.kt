package com.eidarulu.findme.ui.chat_list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.eidarulu.findme.FirebaseAuthentication
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.models.InitializationState
import kotlinx.coroutines.flow.Flow

class ChatListViewModel(application: Application) : AndroidViewModel(application) {

    private val chatClient: ChatClient = (application as FirebaseAuthentication).chatClient

    val clientInitialisationState: Flow<InitializationState> = chatClient.clientState.initializationState
}