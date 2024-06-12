package com.eidarulu.findme.ui.chat

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.eidarulu.findme.FirebaseAuthentication
import io.getstream.chat.android.client.ChatClient

class ChatViewModel(application: Application, private val channelId: String) : AndroidViewModel(application) {

    private val chatClient: ChatClient = (application as FirebaseAuthentication).chatClient

}