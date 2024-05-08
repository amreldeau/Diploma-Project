package com.example.findme.screens

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.size.Size
import com.example.findme.R

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        EndlessHorizontalPager(
            items = listOf("A", "B", "C"),
            itemClicked = {
                /*when (clickedItem) {
                    "A" -> navController.navigate("screenA")
                    "B" -> navController.navigate("screenB")
                    "C" -> navController.navigate("screenC")
                }*/
            })
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EndlessHorizontalPager(
    items: List<String>,
    itemClicked: (String) -> Unit
) {
    val pageCount = Int.MAX_VALUE
    val pagerState = rememberPagerState(
        initialPage = pageCount / 2,
        pageCount = { pageCount },
    )

    HorizontalPager(
        modifier = Modifier
            .background(Color(0xff469597))
            .fillMaxSize()
            .clickable {
                val clickedItem = items[pagerState.settledPage % items.size]
                itemClicked(clickedItem)
            },
        state = pagerState
    ) { page ->
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = items[page % items.size],
                fontSize = 100.sp
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}