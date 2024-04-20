package com.example.findme.screans

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.findme.viewmodels.VideoChatViewModel
import io.getstream.video.android.compose.permission.LaunchCallPermissions
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
    val userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiQWhzb2thX1Rhbm8iLCJpc3MiOiJodHRwczovL3Byb250by5nZXRzdHJlYW0uaW8iLCJzdWIiOiJ1c2VyL0Foc29rYV9UYW5vIiwiaWF0IjoxNzEzNTYwOTUyLCJleHAiOjE3MTQxNjU3NTd9.BWwucSLmkWe1bdhN0hocKp0pY66wGz51i5E_i0mF4mM"
    val userId = "Ahsoka_Tano"
    val callId = "e6c3LOFVnJvS"

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