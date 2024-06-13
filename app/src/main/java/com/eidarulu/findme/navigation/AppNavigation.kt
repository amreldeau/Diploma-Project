package com.eidarulu.findme.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.eidarulu.findme.main.NotificationMessage
import com.eidarulu.findme.ui.profile.ProfileScreen
import com.eidarulu.findme.ui.videochat.VideoChatScreen
import com.eidarulu.findme.ui.change_profile_1.ChangeProfile1
import com.eidarulu.findme.ui.change_profile_2.ChangeProfile2
import com.eidarulu.findme.ui.change_profile_3.ChangeProfile3
import com.eidarulu.findme.ui.chat.ChatMessagesScreen
import com.eidarulu.findme.ui.chat_list.ChatScreen
import com.eidarulu.findme.ui.home.HomeScreen
import com.eidarulu.findme.ui.login.LoginScreen
import com.eidarulu.findme.ui.settings.SettingsScreen
import com.eidarulu.findme.ui.signup.SignupScreen
import com.eidarulu.findme.ui.welcome.WelcomeScreen
import com.eidarulu.findme.viewmodels.FbViewModel
import com.google.firebase.auth.FirebaseAuth

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun AppNavigation() {
    val vm = hiltViewModel<FbViewModel>()
    val navController = rememberNavController()

    val firebaseUser = FirebaseAuth.getInstance().currentUser
    val startingScreen =
        if (firebaseUser == null){
            Screens.WelcomeScreen.name
        }else{
            Screens.WelcomeScreen.name
        }

    NotificationMessage(vm)

    Scaffold(
        bottomBar = {
            val navBackStackEntry = navController.currentBackStackEntryAsState().value
            val currentDestination = navBackStackEntry?.destination
            val currentRoute = currentDestination?.route

            if (currentRoute !in listOf(Screens.WelcomeScreen.name, Screens.LoginScreen.name, Screens.SignupScreen.name)) {
                NavigationBar {
                    listOfNavItems.forEach { navItem: NavItem ->
                        NavigationBarItem(
                            selected = currentDestination?.hierarchy?.any { it.route == navItem.route } == true,
                            onClick = {
                                navController.navigate(navItem.route)
                            },
                            icon = {
                                Image(
                                    painter = painterResource(id = navItem.icon),
                                    contentDescription = null)
                            },
                            label = {
                                Text(
                                    navItem.label
                                )
                            }
                        )
                    }
                }
            }
        }
    ) {paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            NavHost(
                navController = navController,
                startDestination = startingScreen
            ) {
                composable(route = Screens.WelcomeScreen.name) {
                    WelcomeScreen(navController)
                }
                composable(route = Screens.LoginScreen.name){
                    LoginScreen(navController, vm)
                }
                composable(route = Screens.SignupScreen.name){
                    SignupScreen(navController, vm)
                }
                composable(route = Screens.HomeScreen.name) {
                    HomeScreen()
                }
                composable(route = Screens.VideoChatScreen.name) {
                    VideoChatScreen()
                }
                composable(route = Screens.ChatScreen.name) {
                    ChatScreen(navController)
                }
                composable(route = Screens.ProfileScreen.name) {
                    ProfileScreen(
                        { navController.navigate(Screens.SettingsScreen.name) },
                        navController
                    )
                }
                composable(route = Screens.SettingsScreen.name) {
                    SettingsScreen(
                        onBackPressed = {
                            navController.popBackStack()
                        }
                    )
                }
                composable(route = Screens.ChangeProfile1.name) {
                    ChangeProfile1(navController, { navController.popBackStack() })
                }
                composable(route = Screens.ChangeProfile2.name) {
                    ChangeProfile2(navController) {
                        navController.popBackStack()
                    }
                }
                composable(route = Screens.ChangeProfile3.name) {
                    ChangeProfile3(navController)
                }
                composable(route = "${Screens.ChatMessagesScreen.name}/{channelId}") { backStackEntry ->
                    val channelId = backStackEntry.arguments?.getString("channelId")
                    if (channelId != null) {
                        ChatMessagesScreen(channelId, navController)
                    }
                }
            }
        }
    }
}

@Composable
fun FullScreenContent(content: @Composable () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        content()
    }
}