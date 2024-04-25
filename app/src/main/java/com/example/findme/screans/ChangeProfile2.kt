package com.example.findme.screans

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.findme.navigation.Screens
import com.example.findme.ui.theme.Lato

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("MutableCollectionMutableState")
@Composable
fun ChangeProfile2(
    navController: NavController,
    onBackPressed: () -> Unit
) {

    var errorMessage by remember { mutableStateOf("") }

    val interests = listOf("TikTok", "Spotify", "Sushi", "Self-care", "Gym", "Travel", "Reading", "Cooking")
    var selectedInterests by remember { mutableStateOf(listOf<String>()) }

    IconButton(onClick = onBackPressed) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            modifier = Modifier.padding(4.dp).size(40.dp),
            contentDescription = "Back",
            tint = Color.Black
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "CHOOSE YOUR INTERESTS",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
            color = Color.Black
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            TextField(
                value = "", // Placeholder for search
                onValueChange = {}, // Implement search logic here
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp)),
                singleLine = true,
                label = { Text("Search") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(interests) { interest ->
                    Text(
                        text = interest,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(if (selectedInterests.contains(interest)) Color.Green else Color.White)
                            .clickable {
                                selectedInterests = if (selectedInterests.contains(interest)) {
                                    selectedInterests - interest
                                } else {
                                    selectedInterests + interest
                                }
                            },
                        color = Color.Black
                    )
                }
            }

            Text(errorMessage, color = MaterialTheme.colorScheme.error)

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .width(280.dp)
                    .height(50.dp)
                    .shadow(elevation = 15.dp, shape = RoundedCornerShape(20.dp)), // Add this line
                colors = ButtonDefaults.buttonColors(Color(0xFF59C9A5)), // Correct parameter name
                onClick = {
                    if (selectedInterests.isNotEmpty()) {
                        navController.navigate(Screens.ChangeProfile3.name)
                        //onInterestsSelected(selectedInterests)
                    } else {
                        // Show a warning to the user
                        errorMessage = "Please choose at least one interest"
                    }
                },
            ) {
                Text(
                    "CONTINUE",
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center, // Center align text
                        fontFamily = Lato,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ChangeProfile2Preview() {
    ChangeProfile2(rememberNavController(), onBackPressed = {})
}