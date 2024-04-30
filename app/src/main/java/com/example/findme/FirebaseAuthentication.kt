package com.example.findme

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.client.logger.ChatLogLevel
import io.getstream.chat.android.state.plugin.config.StatePluginConfig
import io.getstream.chat.android.state.plugin.factory.StreamStatePluginFactory
import io.getstream.chat.android.offline.plugin.factory.StreamOfflinePluginFactory

@HiltAndroidApp
class FirebaseAuthentication: Application() {
    override fun onCreate() {
        super.onCreate()

        // Initialize Firebase or any other global setup here

        // 1 - Set up the OfflinePlugin for offline storage
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
        ChatClient.Builder("uun7ywwamhs9", this)
            .withPlugins(offlinePluginFactory, statePluginFactory)
            .logLevel(ChatLogLevel.ALL)
            .build()

        val client = ChatClient.instance()

    }
}