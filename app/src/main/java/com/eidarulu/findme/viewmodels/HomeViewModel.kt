package com.eidarulu.findme.viewmodels

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel(){
    val userCards = listOf("A", "B", "C")
    val count = userCards.size
}