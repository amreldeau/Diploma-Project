package com.example.findme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.findme.navigation.Screens
import com.example.findme.ui.theme.Lato
import com.example.findme.viewmodels.ThemeViewModel

@Composable
fun SettingsScreen(onBackPressed: () -> Unit, themeViewModel: ThemeViewModel = viewModel()) {
    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.size(47.dp))

            Row(
                modifier = Modifier.align(Alignment.Start),
                verticalAlignment = Alignment.CenterVertically

            ) {
                IconButton(onClick = onBackPressed) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
                Text(
                    text = "SETTINGS",
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 30.sp,
                        textAlign = TextAlign.Start, // Center align text
                        fontFamily = Lato,
                        fontWeight = FontWeight.Black
                    )
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { themeViewModel.toggleTheme() },
                modifier = Modifier
                    .width(280.dp)
                    .height(50.dp)
                    .shadow(elevation = 15.dp, shape = RoundedCornerShape(20.dp)),
                colors = ButtonDefaults.buttonColors(Color(0xFF59C9A5))
            ) {
                Text(
                    text = "CHANGE THEME",
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = Lato,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            Spacer(modifier = Modifier.size(30.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(280.dp)
                    .height(50.dp)
                    .shadow(elevation = 15.dp, shape = RoundedCornerShape(20.dp)),
                colors = ButtonDefaults.buttonColors(Color(0xFF59C9A5))
            ) {
                Text(
                    text = "SELECT LANGUAGE",
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = Lato,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

//@Preview(showBackground = true, widthDp = 320, heightDp = 640)
//@Composable
//fun SettingsScreenPreview(navController: NavController = rememberNavController()) {
//    SettingsScreen(
//        { navController.navigate(Screens.SettingsScreen.name) },
//        navController
//    )
//}
