package com.example.findme

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.client.logger.ChatLogLevel
import io.getstream.chat.android.models.User
import io.getstream.chat.android.state.plugin.config.StatePluginConfig
import io.getstream.chat.android.state.plugin.factory.StreamStatePluginFactory
import io.getstream.chat.android.offline.plugin.factory.StreamOfflinePluginFactory

@HiltAndroidApp
class FirebaseAuthentication: Application() {

    lateinit var chatClient: ChatClient

    override fun onCreate() {
        super.onCreate()

        // Initialize Firebase or any other global setup here

        // 1 - Initializing ChatClient
        // Set up the OfflinePlugin for offline storage
        val offlinePluginFactory = StreamOfflinePluginFactory(appContext = applicationContext)

        // Create a state plugin factory
        val statePluginFactory = StreamStatePluginFactory(
            config = StatePluginConfig(
                // Enables background sync which syncs user actions performed while offline
                backgroundSyncEnabled = true,
                // Enables tracking online states for users
                userPresence = true
            ),
            appContext = this // replaced this with "context"
        )

        // Initialize the ChatClient
        chatClient = ChatClient.Builder("uun7ywwamhs9", applicationContext)
            .withPlugins(offlinePluginFactory, statePluginFactory)
            .logLevel(ChatLogLevel.ALL) // Set to NOTHING in prod
            .build()

        // Authenticate and connect the user
        val user = User(
            id = "tutorial-droid",
            name = "Tutorial Droid",
            image = "https://bit.ly/2TIt8NR"
        )

        chatClient.connectUser(
            user = user,
            token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoidHV0b3JpYWwtZHJvaWQifQ.WwfBzU1GZr0brt_fXnqKdKhz3oj0rbDUm2DqJO_SS5U"
        ).enqueue()
    }
}