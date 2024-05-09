package com.eidarulu.findme.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.eidarulu.findme.FirebaseAuthentication
import io.getstream.chat.android.client.ChatClient

class ChatMessagesViewModel(application: Application, private val channelId: String) : AndroidViewModel(application) {

    private val chatClient: ChatClient = (application as FirebaseAuthentication).chatClient

}