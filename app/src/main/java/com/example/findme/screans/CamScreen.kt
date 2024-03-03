package com.example.findme.screans

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.findme.ui.theme.AlegreyaFontFamily
import com.example.findme.cameraroll.CameraPer

@Composable
fun CamScreen() {
    CameraPer()
}
@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun CamScreenPreview() {
    CamScreen()
}