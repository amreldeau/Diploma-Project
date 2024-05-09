package com.eidarulu.findme.navigation

import com.eidarulu.findme.R

data class NavItem(
    val label: String,
    val icon: Int,
    val route: String
)

val listOfNavItems: List<NavItem> = listOf(
    NavItem(label = "Home", icon = R.drawable.search, route = Screens.HomeScreen.toString()),
    NavItem(label = "Video Chat", icon = R.drawable.cam, route = Screens.VideoChatScreen.toString()),
    NavItem(label = "Chat", icon =  R.drawable.chat, route = Screens.ChatScreen.toString()),
    NavItem(label = "Profile", icon = R.drawable.profile, route = Screens.ProfileScreen.toString())
)