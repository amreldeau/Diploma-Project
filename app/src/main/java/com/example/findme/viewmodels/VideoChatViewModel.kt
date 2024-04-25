package com.example.findme.viewmodels

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import io.getstream.video.android.core.Call
import io.getstream.video.android.core.GEO
import io.getstream.video.android.core.StreamVideoBuilder
import io.getstream.video.android.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

import kotlinx.coroutines.launch

class VideoChatViewModel(private val application: Application) : AndroidViewModel(application) {

    private val _callToBeProvidedToVCS = MutableStateFlow<Call?>(null)
    val callToBeProvidedToVCS: StateFlow<Call?> = _callToBeProvidedToVCS

    fun joinCall(userId: String, callId: String, userToken: String) {
        viewModelScope.launch {
            // Initialize Stream client and join the call

            // Use the application parameter to access the application context
            val context = application.applicationContext

            // step1 - create a user.
            val user = User(
                id = userId, // any string
                name = "Tutorial" // name and image are used in the UI
            )

            // step2 - initialize StreamVideo. For a production app we recommend adding the client to your Application class or di module.
            val client = StreamVideoBuilder(
                context = context,
                apiKey = "mmhfdzb5evj2", // demo API key
                geo = GEO.GlobalEdgeNetwork,
                user = user,
                token = userToken,
            ).build()


            // step3 - join a call, which type is `default` and id is `123`.
            val call = client.call("default", callId)

            val result = call.join(create = true)

            _callToBeProvidedToVCS.value = call

            result.onError {
                Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
            }
        }
    }
}