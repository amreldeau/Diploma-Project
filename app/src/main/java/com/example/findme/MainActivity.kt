package com.example.findme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.findme.main.NotificationMessage
import com.example.findme.ui.theme.FindMeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = getColor(R.color.black)
            window.navigationBarColor = getColor(R.color.black)

            FindMeTheme {
                /// Let just add navigation so users can go from one screen to another
                //NavigationView()

                AuthenticationApp()
            }
        }
    }
}

sealed class DestinationScreen(val route: String) {
    object Main: DestinationScreen("main")
    object Signup: DestinationScreen("signup")
    object Login: DestinationScreen("login")
    object Success: DestinationScreen("success")
}

@Composable
fun AuthenticationApp(){
    val vm = hiltViewModel<FbViewModel>()
    val navController = rememberNavController()

    NotificationMessage(vm)

    NavHost(navController = navController, startDestination = DestinationScreen.Main.route) {
        composable(DestinationScreen.Main.route) {
            WelcomeScreen(navController, vm)
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

//Deprecated composable func
/*
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
*/