package com.example.findme

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.getstream.chat.android.client.ChatClient

@HiltAndroidApp
class FirebaseAuthentication: Application() {
    override fun onCreate() {
        super.onCreate()

        // Initialize Firebase or any other global setup here

        // Initialize the ChatClient
        ChatClient.Builder("YOUR_API_KEY", this)
            // Set other configurations if needed
            .build()

        // Static reference to initialised client
        val client = ChatClient.instance()
    }
}