package com.example.findme

sealed class NavItem(val route: String, val icon: Int) {
    object Search : NavItem("search", R.drawable.search)
    object Cam : NavItem("cam", R.drawable.cam)
    object Chat : NavItem("chat", R.drawable.chat)
    object Profile : NavItem("profile", R.drawable.profile)
}