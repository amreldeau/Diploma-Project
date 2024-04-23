package com.example.findme.viewmodels

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.findme.data.UserProfile
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class ProfileViewModel: ViewModel() {

    val state = mutableStateOf(UserProfile())

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            state.value = getDataFromFireStore()
        }
    }
}


suspend fun getDataFromFireStore(): UserProfile {
    val db = FirebaseFirestore.getInstance()
    var userProfile = UserProfile()

    try {
        db.collection("users").get().await().map {
            userProfile = it.toObject(UserProfile::class.java)
        }
    } catch(e: FirebaseFirestoreException) {
        Log.d("error", "getDataFromFireStore: $e")
    }

    return userProfile
}