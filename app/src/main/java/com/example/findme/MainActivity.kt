package com.example.findme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.findme.main.NotificationMessage
import com.example.findme.navigation.AppNavigation
import com.example.findme.ui.theme.FindMeTheme
import com.example.findme.viewmodels.FbViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = getColor(R.color.black)
            window.navigationBarColor = getColor(R.color.black)

            FindMeTheme {
                AuthenticationApp()
            }
        }
    }
}

sealed class DestinationScreen(val route: String) {
    object Main : DestinationScreen("main")
    object Signup : DestinationScreen("signup")
    object Login : DestinationScreen("login")
    object Success : DestinationScreen("success")
}

@Composable
fun AuthenticationApp(){
    val vm = hiltViewModel<FbViewModel>()
    val navController = rememberNavController()

    NotificationMessage(vm)

    NavHost(navController = navController, startDestination = DestinationScreen.Main.route) {
        composable(DestinationScreen.Main.route) {
            WelcomeScreen(navController)
        }
        composable(DestinationScreen.Signup.route) {
            SignupScreen(navController, vm)
        }
        composable(DestinationScreen.Login.route) {
            LoginScreen(navController, vm)
        }
        composable(DestinationScreen.Success.route) {
            SuccessScreen(navController, vm)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    AppNavigation()
}