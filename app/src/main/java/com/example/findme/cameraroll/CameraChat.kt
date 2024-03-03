package com.example.findme.cameraroll

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CameraChat(){
    val (userName, setUserName) = remember { mutableStateOf("") }
    val (message, setMessage) = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally // Align items to the center
    ) {

        OutlinedTextField(
            value = userName,
            onValueChange = setUserName,
            label = { Text("User name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = message,
            onValueChange = setMessage,
            label = { Text("Type your message") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { /* Do something with the user name and message */ },
            modifier = Modifier.padding(top = 16.dp).
            fillMaxWidth().
            height(50.dp)
        ) {
            Text("SEND")
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun CamScreenPreview() {
    CameraChat()
}