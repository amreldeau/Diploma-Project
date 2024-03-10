package com.example.findme.cameraroll

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.navigation.compose.rememberNavController
import com.example.findme.R
import com.example.findme.cameraroll.CameraChat

@Composable
fun CameraPer() {

    val navController = rememberNavController()

    val context = LocalContext.current
    val hasPermission = remember {
        mutableStateOf(
            CAMERA_PERMISSIONS.all {
                ContextCompat.checkSelfPermission(
                    context,
                    it
                ) == PackageManager.PERMISSION_GRANTED
            }
        )
    }

    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        if (permissions.values.all { it }) {
            // All permissions are granted.
            hasPermission.value = true
        }
    }

    LaunchedEffect(requestPermissionLauncher) {
        if (!hasPermission.value) {
            requestPermissionLauncher.launch(CAMERA_PERMISSIONS)
        }
    }

    val controller = remember {
        LifecycleCameraController(context).apply {
            setEnabledUseCases(
                CameraController.IMAGE_CAPTURE or
                        CameraController.VIDEO_CAPTURE
            )
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CameraPreview(
            controller = controller,
            modifier = Modifier.fillMaxSize()
        )

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            IconButton(
                onClick = {
                    controller.cameraSelector =
                        if (controller.cameraSelector == CameraSelector.DEFAULT_BACK_CAMERA) {
                            CameraSelector.DEFAULT_FRONT_CAMERA
                        } else {
                            CameraSelector.DEFAULT_BACK_CAMERA
                        }
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "Switch Camera",
                    modifier = Modifier
                        .size(24.dp),
                    tint = Color.White
                )
            }

            IconButton(
                onClick = {
                    navController?.let {
                        it.navigate("CameraChat")
                    }
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.chat),
                    contentDescription = "Go to Chat",
                    modifier = Modifier
                        .size(24.dp),
                    tint = Color.White
                )
            }
        }
    }
}

private val CAMERA_PERMISSIONS = arrayOf(
    Manifest.permission.CAMERA,
    Manifest.permission.RECORD_AUDIO
)