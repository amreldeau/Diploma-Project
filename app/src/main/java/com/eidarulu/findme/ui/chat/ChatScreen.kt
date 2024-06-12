package com.eidarulu.findme.ui.chat

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import io.getstream.chat.android.compose.ui.messages.MessagesScreen
import io.getstream.chat.android.compose.ui.theme.ChatTheme
import io.getstream.chat.android.compose.viewmodel.messages.MessagesViewModelFactory

@Composable
fun ChatMessagesScreen(channelId: String, navController: NavController) {

    val context = LocalContext.current


    ChatTheme {
        MessagesScreen(
            viewModelFactory = MessagesViewModelFactory(
                context = context,
                channelId = channelId,
                messageLimit = 30
            ),
            onBackPressed = {
                navController.popBackStack()
            }
        )
    }
}