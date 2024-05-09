package com.eidarulu.findme.data

data class TabsData(
    val title: String,
    val unreadCount: Int?
)

val tabs = listOf(
    TabsData(title = Tabs.CHATS.value, unreadCount = 7),
    TabsData(title = Tabs.FRIENDS.value, unreadCount = null)
)

enum class Tabs(val value: String) {
    CHATS("Chats"),
    FRIENDS("Friends")
}

const val INITIAL_SCREEN_INDEX = 0