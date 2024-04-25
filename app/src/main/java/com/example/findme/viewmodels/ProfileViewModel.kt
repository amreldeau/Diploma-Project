package com.example.findme.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.findme.data.UserProfile
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class ProfileViewModel: ViewModel() {

    val state = mutableStateOf(UserProfile())

    init {
        getData()
        getCurrentUserDocumentId()
    }

    private fun getData() {
        viewModelScope.launch {
            state.value = getDataFromFireStore()
        }
    }

    fun getCurrentUserDocumentId(): String? {
        val currentUser = FirebaseAuth.getInstance().currentUser
        val uid = currentUser?.uid

        return uid
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