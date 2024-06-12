package com.eidarulu.findme.ui.change_profile_3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
fun ChangeProfile3(
    navController: NavController,
    profileViewModel: ProfileViewModel = viewModel()
) {
    var city by remember { mutableStateOf("") }
    var religion by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var work by remember { mutableStateOf("") }
    var company by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "CHOOSE ADDITIONAL INFORMATION ",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
            textAlign = TextAlign.Center
        )

        OutlinedTextField(
            value = city,
            onValueChange = { city = it },
            label = { Text(
                text = "Your city...",
                fontSize = 20.sp
            )},
            singleLine = true,
            shape = RoundedCornerShape(40.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Blue, // Customize the focused border color if needed
                unfocusedBorderColor = Color(0xFF59C9A5) // Customize the unfocused border color if needed
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = religion,
            onValueChange = { religion = it },
            label = { Text(
                text = "Your religion...",
                fontSize = 20.sp
            )},
            singleLine = true,
            shape = RoundedCornerShape(40.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Blue, // Customize the focused border color if needed
                unfocusedBorderColor = Color(0xFF59C9A5) // Customize the unfocused border color if needed
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = gender,
            onValueChange = { gender = it },
            label = { Text(
                text = "Your gender...",
                fontSize = 20.sp
            )},
            singleLine = true,
            shape = RoundedCornerShape(40.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Blue, // Customize the focused border color if needed
                unfocusedBorderColor = Color(0xFF59C9A5) // Customize the unfocused border color if needed
            )
        )

        Spacer(modifier = Modifier.height(16.dp))


        OutlinedTextField(
            value = work,
            onValueChange = { work = it },
            label = { Text(
                text = "Your type of work...",
                fontSize = 20.sp
            )},
            singleLine = true,
            shape = RoundedCornerShape(40.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Blue, // Customize the focused border color if needed
                unfocusedBorderColor = Color(0xFF59C9A5) // Customize the unfocused border color if needed
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = company,
            onValueChange = { company = it },
            label = { Text(
                text = "Your working company...",
                fontSize = 20.sp
            )},
            singleLine = true,
            shape = RoundedCornerShape(40.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Blue, // Customize the focused border color if needed
                unfocusedBorderColor = Color(0xFF59C9A5) // Customize the unfocused border color if needed
            )
        )

        Spacer(modifier = Modifier.height(64.dp))

        Button(
            modifier = Modifier
                .width(280.dp)
                .height(50.dp)
                .shadow(elevation = 15.dp, shape = RoundedCornerShape(20.dp)), // Add this line
            colors = ButtonDefaults.buttonColors(Color(0xFF59C9A5)), // Correct parameter name
            onClick = {
                profileViewModel.updateCity(city)
                profileViewModel.updateReligion(religion)
                profileViewModel.updateGender(gender)
                profileViewModel.updateWork(work)
                profileViewModel.updateCompany(company)
                profileViewModel.saveUserProfile()
                navController.navigate(Screens.ProfileScreen.name)
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

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ChangeProfile3Preview() {
    ChangeProfile3(rememberNavController())
}