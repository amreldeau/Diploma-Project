package com.eidarulu.findme.ui.entry_point

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.eidarulu.findme.activities.MainScreen
import com.eidarulu.findme.viewmodels.FbViewModel

@Composable
fun SuccessScreen(navController: NavController, vm: FbViewModel) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        MainScreen()
    }
}