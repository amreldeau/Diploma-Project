package com.example.findme.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.findme.viewmodels.VideoChatViewModel
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
    val userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiQWRtaXJhbF9BY2tiYXIiLCJpc3MiOiJodHRwczovL3Byb250by5nZXRzdHJlYW0uaW8iLCJzdWIiOiJ1c2VyL0FkbWlyYWxfQWNrYmFyIiwiaWF0IjoxNzE0MDczMDI3LCJleHAiOjE3MTQ2Nzc4MzJ9.lAaZpwl9dlnCz92Nf16aW_9O9ZN8sCmjPv4E_DlCl9s"
    val userId = "Admiral_Ackbar"
    val callId = "WnTJkiHtEIUx"

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