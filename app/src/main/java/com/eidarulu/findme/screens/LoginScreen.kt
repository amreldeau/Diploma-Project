package com.eidarulu.findme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.eidarulu.findme.activities.DestinationScreen
import com.eidarulu.findme.R
import com.eidarulu.findme.components.CButton
import com.eidarulu.findme.components.CTextField
import com.eidarulu.findme.ui.theme.AlegreyaFontFamily
import com.eidarulu.findme.ui.theme.AlegreyaSansFontFamily
import com.eidarulu.findme.components.DontHaveAccountRow
import com.eidarulu.findme.viewmodels.FbViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    // changed to NavController from NavHostController
    navController: NavController,
    //from yt
    vm: FbViewModel,
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorE by remember { mutableStateOf(false) }
    var errorP by remember { mutableStateOf(false) }

    // we can copy and paste and do changes for signup screen
    Surface(
        color = Color(0xFF253334),
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier =  Modifier.fillMaxSize()){

            // Background Image
            Image(painter = painterResource(id = R.drawable.bg1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(190.dp)
                    .align(Alignment.BottomCenter)
            )

            // Content
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
            ) {

                // Logo
                Image(painter = painterResource(id = R.drawable.logo2),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 54.dp)
                        .height(100.dp)
                        .align(Alignment.Start)
                        .offset(x = (-35).dp),
                    colorFilter = ColorFilter.tint(Color.White)
                )

                Text(text = stringResource(id = R.string.app_name),
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontFamily = AlegreyaFontFamily,
                        fontWeight = FontWeight(500),
                        color = Color.White
                    ),
                    modifier = Modifier.align(Alignment.Start)
                )

                Text("Sign in now to explore, engage, and enjoy!",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = AlegreyaSansFontFamily,
                        color = Color(0xB2FFFFFF)
                    ),
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(bottom = 24.dp)
                )


                if (errorE) {
                    Text(
                        text = "Enter email",
                        color = Color.Red,
                        modifier = Modifier.padding(end = 100.dp)
                    )
                }
                CTextField(
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    hint = "Email",
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next
                    )
                )

                if (errorP) {
                    Text(
                        text = "Enter Password",
                        color = Color.Red,
                        modifier = Modifier.padding(end = 100.dp)
                    )
                }
                CTextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    hint = "Password",
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done,
                        keyboardType = KeyboardType.Password
                    )
                )

                Spacer(modifier = Modifier.height(24.dp))

                CButton(onClick = {
                    if (email.isNotEmpty()){
                        errorE = false
                        if (password.isNotEmpty()){
                            errorP = false
                            vm.login(email, password)
                        }
                        else {
                            errorP = true
                        }
                    }
                    else {
                        errorE = true
                    }
                },
                    text = "Sign In",
                )

                if (vm.signedIn.value) {
                    navController.navigate(DestinationScreen.Success.route)
                }
                vm.signedIn.value = false

                DontHaveAccountRow(
                    onSignupTap = {
                        navController.navigate("signup")
                    }
                )
            }
        }
    }
}