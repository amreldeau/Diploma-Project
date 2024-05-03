package com.example.findme.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.findme.R
import com.example.findme.navigation.Screens
import com.example.findme.viewmodels.ChatViewModel
import io.getstream.chat.android.compose.ui.channels.ChannelsScreen
import io.getstream.chat.android.compose.ui.theme.ChatTheme
import io.getstream.chat.android.models.InitializationState


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChatScreen(navController: NavController) {

    val viewModel: ChatViewModel = viewModel()
    val clientInitialisationState by viewModel.clientInitialisationState.collectAsState(initial = InitializationState.NOT_INITIALIZED)

    ChatTheme {
        when (clientInitialisationState) {
            InitializationState.COMPLETE -> {
                // Display chat UI here
                ChannelsScreen(
                    title = stringResource(id = R.string.app_name),
                    isShowingSearch = true,
                    onItemClick = {
                        val c = it.cid
                        navController.navigate("${Screens.ChatMessagesScreen.name}/$c")
                    },
                    onBackPressed = {}
                )
                // You can navigate to a specific channel or display a list of channels
            }

            InitializationState.INITIALIZING -> {
                Text(
                    text = "Initialising...",
                    color = Color.Black
                )
            }

            InitializationState.NOT_INITIALIZED -> {
                Text(
                    text = "Not initialized...",
                    color = Color.Black
                )
            }
        }
    }
}