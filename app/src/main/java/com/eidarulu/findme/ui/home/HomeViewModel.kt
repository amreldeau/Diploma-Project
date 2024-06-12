package com.eidarulu.findme.ui.home

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel(){
    val userCards = listOf("A", "B", "C")
    val count = userCards.size
}