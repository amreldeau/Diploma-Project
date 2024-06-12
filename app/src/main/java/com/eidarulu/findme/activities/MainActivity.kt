package com.eidarulu.findme.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eidarulu.findme.main.NotificationMessage
import com.eidarulu.findme.navigation.AppNavigation
import com.eidarulu.findme.ui.login.LoginScreen
import com.eidarulu.findme.ui.signup.SignupScreen
import com.eidarulu.findme.ui.entry_point.SuccessScreen
import com.eidarulu.findme.ui.welcome.WelcomeScreen
import com.eidarulu.findme.ui.theme.FindMeTheme
import com.eidarulu.findme.viewmodels.FbViewModel
import com.eidarulu.findme.R
import com.google.firebase.auth.FirebaseAuth
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
    AppNavigation()
}