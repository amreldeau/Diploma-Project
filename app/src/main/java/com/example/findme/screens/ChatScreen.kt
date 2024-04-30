package com.example.findme.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.findme.R
import com.example.findme.components.AppBar
import com.example.findme.components.Chats
import com.example.findme.components.Friends
import com.example.findme.components.Tabs
import com.example.findme.data.INITIAL_SCREEN_INDEX
import com.example.findme.data.tabs
import com.example.findme.viewmodels.ChatViewModel
import io.getstream.chat.android.compose.ui.channels.ChannelsScreen
import io.getstream.chat.android.compose.ui.theme.ChatTheme
import io.getstream.chat.android.models.InitializationState
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChatScreen() {

    val viewModel: ChatViewModel = viewModel()

    val clientToBeProvidedToVCS by viewModel.clientToBeProvidedToVCS.collectAsState()


    val clientInitialisationState by clientToBeProvidedToVCS?.clientState?.initializationState!!.collectAsState()


    // Use LaunchedEffect to call joinCall when the Composable is first composed
    LaunchedEffect(Unit) {
        viewModel.connectUser()
    }


    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(
        initialPage = INITIAL_SCREEN_INDEX
    ) {
        tabs.size
    }

    Column {
        AppBar()
        Tabs(
            pagerState = pagerState,
            initialIndex = INITIAL_SCREEN_INDEX,
            onTabSelected = {selectedPage ->
                scope.launch {
                    pagerState.animateScrollToPage(selectedPage)
                }
            }
        )
        ChatTheme { // Theme wrapper
            when (clientInitialisationState) {
                InitializationState.COMPLETE -> {
                    ChannelsScreen(
                        title = stringResource(id = R.string.app_name),
                        isShowingSearch = true,
                        onItemClick = {},
                        onBackPressed = {}
                    )
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

        /*HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            state = pagerState
        ) { page ->
            when(page) {
                0 -> Chats()
                1 -> Friends()
            }
        }*/
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ChatScreenPreview() {
    ChatScreen()
}
