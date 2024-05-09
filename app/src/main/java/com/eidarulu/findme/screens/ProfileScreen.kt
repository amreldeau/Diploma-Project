package com.eidarulu.findme.screens

import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.eidarulu.findme.activities.DestinationScreen
import com.eidarulu.findme.components.AppBar
import com.eidarulu.findme.navigation.Screens
import com.eidarulu.findme.ui.theme.Lato
import com.eidarulu.findme.viewmodels.ProfileViewModel
import com.eidarulu.findme.widgets.ProfileImage
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


@Composable
fun ProfileScreen(
    onSettingsClicked: () -> Unit,
    navController: NavController,
    profileViewModel: ProfileViewModel = viewModel()
) {
    val getData = profileViewModel.userProfile.value

    var fullName: String by remember {
        mutableStateOf("")
    }
    var picUrl: String by remember {
        mutableStateOf("")
    }

    LaunchedEffect(Unit) {
        // Actions to perform when LaunchedEffect enters the Composition
        FirebaseFirestore.getInstance().collection("users")
            .document(FirebaseAuth.getInstance().currentUser?.uid.toString())
            .get()
            .addOnSuccessListener {

                fullName = it.get("username").toString()
                picUrl = it.get("profile_picture").toString()
            }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        AppBar()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 120.dp, end = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // PROFILE IMG
            ProfileImage(Uri.parse(picUrl)) {
                //by usin it (the local file path for image) update the profile image
                profileViewModel.updateProfilePicture(it)
            }

            Spacer(modifier = Modifier.size(20.dp))
            Text(
                text = getData.username,
                color = Color.Black,
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center, // Center align text
                    fontFamily = Lato,
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(modifier = Modifier.size(30.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .width(280.dp)
                    .height(50.dp)
                    .shadow(elevation = 15.dp, shape = RoundedCornerShape(20.dp)), // Add this line
                colors = ButtonDefaults.buttonColors(Color(0xFF59C9A5))
            ) {
                Text(
                    text = "View Profile",
                    color = Color.White,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center, // Center align text
                        fontFamily = Lato,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            // EDIT PROFILE BUTT
            Spacer(modifier = Modifier.size(20.dp))
            Button(
                onClick = { navController.navigate(Screens.ChangeProfile1.name) },
                modifier = Modifier
                    .width(280.dp)
                    .height(50.dp)
                    .shadow(elevation = 15.dp, shape = RoundedCornerShape(20.dp)), // Add this line
                colors = ButtonDefaults.buttonColors(Color(0xFF59C9A5)) // Correct parameter name
            )
            {
                //Button text
                Text(
                    text = "Edit Profile",
                    color = Color.White,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center, // Center align text
                        fontFamily = Lato,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            // SETTINGS BUTT
            Spacer(modifier = Modifier.size(20.dp))
            Button(
                onClick = onSettingsClicked,
                modifier = Modifier
                    .width(280.dp)
                    .height(50.dp)
                    .shadow(elevation = 15.dp, shape = RoundedCornerShape(20.dp)),
                colors = ButtonDefaults.buttonColors(Color(0xFF59C9A5)) // Correct parameter name
            )
            {
                //Button text
                Text(
                    text = "Settings",
                    color = Color.White,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center, // Center align text
                        fontFamily = Lato,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            // LOG OUT BUTT
            Spacer(modifier = Modifier.size(20.dp))
            Button(
                onClick = {
                    FirebaseAuth.getInstance().signOut()
                    navController.navigate(DestinationScreen.Main.route)
                },
                modifier = Modifier
                    .width(280.dp)
                    .height(50.dp)
                    .shadow(elevation = 15.dp, shape = RoundedCornerShape(20.dp)),
                colors = ButtonDefaults.buttonColors(Color(0xFF59C9A5))
            ) {
                Text(
                    text = "Log Out",
                    color = Color.White,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = Lato,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun ProfileScreenPreview() {
    val navController = rememberNavController()

    ProfileScreen(
        { navController.navigate(Screens.SettingsScreen.name) },
        rememberNavController()
    )
}