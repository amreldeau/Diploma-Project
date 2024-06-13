package com.eidarulu.findme.ui.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.eidarulu.findme.R
import com.eidarulu.findme.components.CButton
import com.eidarulu.findme.components.DontHaveAccountRow
import com.eidarulu.findme.navigation.Screens
import com.eidarulu.findme.ui.theme.AlegreyaFontFamily
import com.eidarulu.findme.ui.theme.AlegreyaSansFontFamily

@Composable
fun WelcomeScreen(
    // changed to NavController from NavHostController
    navController: NavController,
    //from yt
    //vm: FbViewModel,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier.fillMaxSize()
    ) {

        // Background Image
        Image(
            painter = painterResource(id = R.drawable.bg3),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        // Overlay to enhance text visibility
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f)) // Adjust the alpha as needed
        )

        // Content
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ) {

            Spacer(modifier = Modifier.weight(1f))

            Image(
                painter = painterResource(id = R.drawable.logo2),
                contentDescription = null,
                modifier = Modifier
                    .width(320.dp)
                    .height(240.dp),
                contentScale = ContentScale.Fit,
                colorFilter = ColorFilter.tint(Color.White)
            )

            Text(
                text = stringResource(id = R.string.app_name),
                fontSize = 32.sp,
                fontFamily = AlegreyaFontFamily,
                fontWeight = FontWeight(700),
                color = Color.White
            )

            Text(
                "Connect with the World",
                textAlign = TextAlign.Center,
                fontFamily = AlegreyaSansFontFamily,
                fontSize = 18.sp,
                fontWeight = FontWeight(500),
                color = Color.White
            )

            Spacer(modifier = Modifier.weight(1f))


            CButton(text = "Sign In",
                onClick = {
                    navController.navigate(Screens.LoginScreen.name)
                }
            )

            DontHaveAccountRow(
                onSignupTap = {
                    navController.navigate(Screens.SignupScreen.name)
                }
            )
        }
    }
}

@Composable
@Preview(showBackground = true, widthDp = 320, heightDp = 640)
fun WelcomeScreenPreview() {
    WelcomeScreen(rememberNavController())
}