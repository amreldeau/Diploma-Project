package com.example.findme.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.res.painterResource
import com.example.findme.screans.ProfileScreen
import com.example.findme.screans.CamScreen
import com.example.findme.screans.ChangeProfile1
import com.example.findme.screans.ChatScreen
import com.example.findme.screans.SettingsScreen

@Composable
fun HomeScreen() {
    // Define your HomeScreen here
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar{
                val navBackStackEntry = navController.currentBackStackEntryAsState().value
                val currentDestination = navBackStackEntry?.destination

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
    ) {paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.HomeScreen.name
        ){
            composable(route = Screens.HomeScreen.name){
                HomeScreen()
            }
            composable(route = Screens.CamScreen.name){
                CamScreen()
            }
            composable(route = Screens.ChatScreen.name){
                ChatScreen()
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
                ChangeProfile1(navController) {
                    navController.popBackStack()
                }
            }
            composable(route = Screens.ChangeProfile2.name) {
                ChangeProfile1(navController) {
                    navController.popBackStack()
                }
            }
            composable(route = Screens.ChangeProfile3.name) {
                ChangeProfile1(navController) {
                    navController.popBackStack()
                }
            }
        }
    }
}