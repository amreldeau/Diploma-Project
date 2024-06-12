package com.eidarulu.findme.ui.change_profile_1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.eidarulu.findme.navigation.Screens
import com.eidarulu.findme.ui.theme.Lato
import com.eidarulu.findme.ui.profile.ProfileViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChangeProfile1(
    navController: NavController,
    onBackPressed: () -> Unit,
    profileViewModel: ProfileViewModel = viewModel()
) {

    var birthday by remember { mutableStateOf("") }
    var bio by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

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

        OutlinedTextField(
            value = birthday,
            onValueChange = { birthday = it },
            label = {
                Text(
                        text = "Enter your birthday",
                        fontSize = 20.sp
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(40.dp),
            colors = androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Blue, // Customize the focused border color if needed
                unfocusedBorderColor = Color(0xFF59C9A5) // Customize the unfocused border color if needed
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = bio,
            onValueChange = { bio = it },
            label = {
                Text(
                        text = "Describe yourself (bio)",
                        fontSize = 20.sp
                    )
            },
            singleLine = true,
            shape = RoundedCornerShape(40.dp),
            colors = androidx.compose.material3.TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Blue, // Customize the focused border color if needed
                unfocusedBorderColor = Color(0xFF59C9A5) // Customize the unfocused border color if needed
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(errorMessage, color = MaterialTheme.colorScheme.error)

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            modifier = Modifier
                .width(280.dp)
                .height(50.dp)
                .shadow(elevation = 15.dp, shape = RoundedCornerShape(20.dp)), // Add this line
            colors = ButtonDefaults.buttonColors(Color(0xFF59C9A5)), // Correct parameter name
            onClick = {
                if (birthday.isNotEmpty() && bio.isNotEmpty()) {
                    profileViewModel.updateBirthday(birthday)
                    profileViewModel.updateBio(bio)
                    navController.navigate(Screens.ChangeProfile2.name)
                } else {
                    errorMessage = "Please fill in all fields"
                }
        }) {
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

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ChangeProfile1Preview() {
    ChangeProfile1(rememberNavController(), onBackPressed = {})
}