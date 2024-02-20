package com.example.findme

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.findme.ui.theme.AlegreyaFontFamily
import com.example.findme.ui.theme.AlegreyaSansFontFamily
import com.example.findme.components.CButton
import com.example.findme.components.DontHaveAccountRow

@Composable
fun WelcomeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.bg2),
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

        /// Content
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
                "FateDate",
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
                    navController.navigate("login")
                }
            )

            DontHaveAccountRow(
                onSignupTap = {
                    navController.navigate("signup")
                }
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(rememberNavController())
}