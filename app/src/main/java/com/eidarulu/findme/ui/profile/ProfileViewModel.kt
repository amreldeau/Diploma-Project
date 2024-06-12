package com.eidarulu.findme.ui.profile

import android.net.Uri
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eidarulu.findme.data.UserProfile
import com.eidarulu.findme.viewmodels.MyEventBus
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class ProfileViewModel: ViewModel() {

    init {
        viewModelScope.launch {
            MyEventBus.events.collect { fullName ->
                updateUsername(fullName)
            }
        }
    }

    val userProfile = mutableStateOf(UserProfile())
    val docId = getCurrentUserDocumentId()
    val db = FirebaseFirestore.getInstance()

    fun updateUsername(username: String) {
        userProfile.value = userProfile.value.copy(username = username)
    }

    fun updateProfilePictureUrl(profilePictureUrl: String) {
        userProfile.value = userProfile.value.copy(profile_picture = profilePictureUrl)
    }

    fun updateBirthday(birthday: String) {
        userProfile.value = userProfile.value.copy(birthday = birthday)
    }

    fun updateBio(bio: String) {
        userProfile.value = userProfile.value.copy(bio = bio)
    }

    fun updateCity(city: String) {
        userProfile.value = userProfile.value.copy(city = city)
    }

    fun updateReligion(religion: String) {
        userProfile.value = userProfile.value.copy(religion = religion)
    }

    fun updateGender(gender: String) {
        userProfile.value = userProfile.value.copy(gender = gender)
    }

    fun updateWork(work: String) {
        userProfile.value = userProfile.value.copy(work = work)
    }

    fun updateCompany(company: String) {
        userProfile.value = userProfile.value.copy(company = company)
    }


    fun updateProfilePicture(uri: Uri) {
        val riversRef = FirebaseStorage
            .getInstance()
            .getReference(
                "profile_picture/${FirebaseAuth.getInstance().currentUser?.uid.toString()}")
        val uploadTask = riversRef.putFile(uri)

        uploadTask.addOnFailureListener {
            // Handle unsuccessful uploads
            Log.e("Firebase", "Upload failed", it)
        }.addOnSuccessListener { taskSnapshot ->
            taskSnapshot.storage.downloadUrl.addOnSuccessListener { uri ->
                val url = uri.toString()
                Log.d("Firebase", "Upload succeeded, URL: $url")

                // Update the profile picture URL in the ViewModel
                updateProfilePictureUrl(url)

                val userDocument = db.collection("users").document(docId)

                userDocument.get().addOnSuccessListener { document ->
                    if (document.exists()) {
                        userDocument.update("profile_picture", url)
                            .addOnFailureListener { exception ->
                                Log.e("Firebase", "Failed to update Firestore", exception)
                            }
                    } else {
                        userDocument.set(mapOf("profile_picture" to url))
                            .addOnFailureListener { exception ->
                                Log.e("Firebase", "Failed to create document in Firestore", exception)
                            }
                    }
                }.addOnFailureListener { exception ->
                    Log.e("Firebase", "Failed to get document", exception)
                }
            }
        }
    }


    fun saveUserProfile() {
        db.collection("users")
            .document(docId)
            .set(userProfile.value)
            .addOnFailureListener { exception ->
                Log.e("Firebase", "Failed to save user profile", exception)
            }

        /*// Create a new user with a first and last name
        val user = hashMapOf(
            "username" to userProfile.value.username,
            "profile_picture" to userProfile.value.profile_picture,
            "birthday" to userProfile.value.birthday,
            "bio" to userProfile.value.bio,
            "city" to userProfile.value.city,
            "religion" to userProfile.value.religion,
            "gender" to userProfile.value.gender,
            "work" to userProfile.value.work,
            "company" to userProfile.value.company
        )

        // Add a new document with a generated ID
        FirebaseFirestore.getInstance().collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(ContentValues.TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(ContentValues.TAG, "Error adding document", e)
            }*/
    }

    init {
        getData()
        getCurrentUserDocumentId()
    }

    private fun getData() {
        viewModelScope.launch {
            userProfile.value = getDataFromFireStore()
        }
    }

    fun getCurrentUserDocumentId(): String {
        val currentUser = FirebaseAuth.getInstance().currentUser
        return currentUser?.uid ?: ""
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