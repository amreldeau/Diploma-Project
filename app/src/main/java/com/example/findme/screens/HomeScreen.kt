package com.example.findme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.findme.R

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_1),
            contentDescription = "User Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Image(
            painter = painterResource(id = R.drawable.img_2),
            contentDescription = "User Photo",
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.Center)
                .clip(CircleShape)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom
        ) {

            Text(
                text = "",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(16.dp, 0.dp, 8.dp, 4.dp),
                style = MaterialTheme.typography.bodyMedium
            )
            Row(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "location",
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = "user.location",
                    modifier = Modifier
                        .padding(4.dp, 0.dp, 0.dp, 0.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Row(
                modifier = Modifier.padding(start = 16.dp, top = 4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "gender",
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = "user.gender",
                    modifier = Modifier
                        .padding(4.dp, 0.dp, 0.dp, 16.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}