package com.example.findme.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.findme.R
import com.example.findme.main.NotificationMessage
import com.example.findme.navigation.AppNavigation
import com.example.findme.navigation.Screens
import com.example.findme.screens.LoginScreen
import com.example.findme.screens.SignupScreen
import com.example.findme.screens.SuccessScreen
import com.example.findme.screens.WelcomeScreen
import com.example.findme.ui.theme.FindMeTheme
import com.example.findme.viewmodels.FbViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import com.example.findme.viewmodels.ThemeViewModel
import androidx.compose.runtime.collectAsState

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = getColor(R.color.black)
            window.navigationBarColor = getColor(R.color.black)

            val themeViewModel: ThemeViewModel = hiltViewModel()

            FindMeTheme(isDarkTheme = themeViewModel.isDarkTheme.collectAsState().value) {
                AuthenticationApp(themeViewModel)
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
fun AuthenticationApp(themeViewModel: ThemeViewModel){
    val vm = hiltViewModel<FbViewModel>()
    val navController = rememberNavController()
    val themeViewModel: ThemeViewModel = hiltViewModel()

    val firebaseUser = FirebaseAuth.getInstance().currentUser
    val startingScreen =
        if (firebaseUser == null){
            DestinationScreen.Main.route
        }else{
            DestinationScreen.Success.route
        }

    NotificationMessage(vm)

    NavHost(navController = navController, startDestination = startingScreen) {
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
    val themeViewModel: ThemeViewModel = hiltViewModel()
    AppNavigation(themeViewModel)
}