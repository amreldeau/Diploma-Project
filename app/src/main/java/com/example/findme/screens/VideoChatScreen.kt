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
    val userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiR2VuZXJhbF9Hcmlldm91cyIsImlzcyI6Imh0dHBzOi8vcHJvbnRvLmdldHN0cmVhbS5pbyIsInN1YiI6InVzZXIvR2VuZXJhbF9Hcmlldm91cyIsImlhdCI6MTcxNDQzMjE2NSwiZXhwIjoxNzE1MDM2OTcwfQ.PrmO2xXU--XWwCIw8-sa4SdDaSsr8oK5QmAmb1-zEbE"
    val userId = "General_Grievous"
    val callId = "9fLrdT6PbXrU"

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