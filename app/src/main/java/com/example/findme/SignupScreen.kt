package com.example.findme

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.findme.components.CButton
import com.example.findme.components.CTextField
import com.example.findme.ui.theme.AlegreyaFontFamily
import com.example.findme.ui.theme.AlegreyaSansFontFamily

@Composable
fun SignupScreen(
    // changed to NavController from NavHostController
    navController: NavController,
    //from yt
    vm: FbViewModel,
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorE by remember { mutableStateOf(false) }
    var errorP by remember { mutableStateOf(false) }
    var plength by remember { mutableStateOf(false) }

    Surface(
        color = Color(0xFF253334),
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier =  Modifier.fillMaxSize()){

            /// Background Image
            Image(painter = painterResource(id = R.drawable.bg1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(190.dp)
                    .align(Alignment.BottomCenter)
            )

            // added from yt
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                if (vm.inProgress.value) {
                    CircularProgressIndicator()
                }
            }

            // Content
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
            ) {

                // Logo
                Image(
                    painter = painterResource(id = R.drawable.logo2),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 54.dp)
                        .height(100.dp)
                        .align(Alignment.Start)
                        .offset(x = (-35).dp),
                    colorFilter = ColorFilter.tint(Color.White)
                )

                Text(
                    text = stringResource(id = R.string.app_name),
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontFamily = AlegreyaFontFamily,
                        fontWeight = FontWeight(500),
                        color = Color.White
                    ),
                    modifier = Modifier.align(Alignment.Start)
                )

                Text(
                    text = "Sign up now to explore, engage, and enjoy!",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = AlegreyaSansFontFamily,
                        color = Color(0xB2FFFFFF)
                    ),
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(bottom = 24.dp)
                )


                CTextField(
                    hint = "Full Name", value = "", keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next
                    )
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
                if (plength) {
                    Text(
                        text = "Password must be at least 6 characters",
                        color = Color.Red,
                        modifier = Modifier.padding(end = 100.dp)
                    )
                }
                CTextField(
                    value = password,
                    onValueChange = {
                        password = it
                        plength = it.length < 6
                    },
                    hint = "Password",
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Password
                    )
                )

                Spacer(modifier = Modifier.height(24.dp))

                CButton(onClick = {
                    if (email.isNotEmpty()){
                        errorE = false
                        if (password.isNotEmpty()){
                            errorP = false
                            vm.onSignup(email, password)
                        }
                        else {
                            errorP = true
                        }
                    }
                    else {
                        errorE = true
                    }
                },
                    text = "Sign Up",
                )

                if (vm.signedIn.value) {
                    navController.navigate(DestinationScreen.Success.route)
                }
                vm.signedIn.value = false


                Row(
                    modifier = Modifier.padding(top=12.dp, bottom = 52.dp)
                ){
                    Text("Already have an account? ",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = AlegreyaSansFontFamily,
                            color = Color.White
                        )
                    )

                    Text("Sign In",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = AlegreyaSansFontFamily,
                            fontWeight = FontWeight(800),
                            color = Color.White
                        ),
                        modifier = Modifier.clickable {
                            navController.navigate("login")
                        }
                    )
                }
            }
        }
    }
}