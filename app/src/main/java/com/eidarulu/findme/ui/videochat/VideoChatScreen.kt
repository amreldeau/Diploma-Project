package com.eidarulu.findme.ui.videochat

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import io.getstream.video.android.compose.theme.VideoTheme
import io.getstream.video.android.compose.ui.components.call.activecall.CallContent

@Composable
fun VideoChatScreen() {

    // Obtain the ViewModel
    val viewModel: VideoChatViewModel = viewModel()
    val callToBeProvidedToVCS by viewModel.callToBeProvidedToVCS.collectAsState()


    // Define your userToken, userId, and callId
    // val user = userRepository.getUser(userId)
    // val token = userRepository.getToken(userId)
    val userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiTHVrZV9Ta3l3YWxrZXIiLCJpc3MiOiJodHRwczovL3Byb250by5nZXRzdHJlYW0uaW8iLCJzdWIiOiJ1c2VyL0x1a2VfU2t5d2Fsa2VyIiwiaWF0IjoxNzE1MTc0MjcyLCJleHAiOjE3MTU3NzkwNzd9.eo5yScmtTmuUz_jDzOwXh22X2543QucAjWhcAiI0iFw"
    val userId = "Luke_Skywalker"
    val callId = "PeU8tUfEyQMJ"

    // Use LaunchedEffect to call joinCall when the Composable is first composed
    LaunchedEffect(Unit) {
        viewModel.joinCall(userId, callId, userToken)
    }

    // Your UI logic here, observing LiveData or StateFlow from the ViewModel
    // For example, showing a loading indicator while the call is being joined

    VideoTheme {
        callToBeProvidedToVCS?.let {
            CallContent(
                modifier = Modifier.fillMaxSize(),
                call = it
            )
        }
    }
}