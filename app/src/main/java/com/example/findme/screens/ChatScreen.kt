package com.example.findme.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.findme.components.AppBar
import com.example.findme.components.Chats
import com.example.findme.components.Friends
import com.example.findme.components.Tabs
import com.example.findme.data.INITIAL_SCREEN_INDEX
import com.example.findme.data.tabs
import com.example.findme.ui.theme.AlegreyaFontFamily
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChatScreen() {

    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(
        initialPage = INITIAL_SCREEN_INDEX
    ) {
        tabs.size
    }

    Column {
        AppBar()
        Tabs(
            pagerState = pagerState,
            initialIndex = INITIAL_SCREEN_INDEX,
            onTabSelected = {selectedPage ->
                scope.launch {
                    pagerState.animateScrollToPage(selectedPage)
                }
            }
        )

        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            state = pagerState
        ) { page ->
            when(page) {
                0 -> Chats()
                1 -> Friends()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ChatScreenPreview() {
    ChatScreen()
}
