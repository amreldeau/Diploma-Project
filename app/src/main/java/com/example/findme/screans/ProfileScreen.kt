package com.example.findme.screans

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.findme.R
import com.example.findme.ui.theme.Lato

@Composable
fun ProfileScreen() {

    Box(modifier =  Modifier.fillMaxSize()){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally // Align items to the center
        ) {
            Spacer(modifier = Modifier.size(20.dp))
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .border(
                        shape = CircleShape,
                        border = BorderStroke(2.dp, Color.White)
                    )
            )
            Spacer(modifier = Modifier.size(20.dp))
            Text(
                text = "USER NAME",
                color = Color.Black,
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center, // Center align text
                    fontFamily = Lato,
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(modifier = Modifier.size(20.dp))
            Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 5.dp, shape = RoundedCornerShape(10.dp)), // Add this line
            colors = ButtonDefaults.buttonColors(Color(0xFF59C9A5)) // Correct parameter name
            ) {
            Text(text = "SETTINGS")
            }

            Spacer(modifier = Modifier.size(20.dp))
            Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 5.dp, shape = RoundedCornerShape(10.dp)), // Add this line
            colors = ButtonDefaults.buttonColors(Color(0xFF59C9A5)) // Correct parameter name
            ) {
                Text(
                    text = "EDIT PROFILE"

                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}