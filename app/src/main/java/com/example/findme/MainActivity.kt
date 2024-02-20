package com.example.findme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.findme.ui.theme.FindMeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FindMeTheme {
                /// Let just add navigation so users can go from one screen to another
                NavigationView()
            }
        }
    }
}

@Composable
fun NavigationView() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcome" ){
        // also pass navController to each screen so we can use navController in there
        composable("welcome"){ WelcomeScreen(navController)}
        composable("login"){ LoginScreen(navController)}
        composable("signup"){ SignupScreen(navController)}
    }

}