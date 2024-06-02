package com.example.findme.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.platform.LocalView
import com.example.findme.viewmodels.ThemeViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorScheme = darkColorScheme(
    primary = DarkGreen,
    secondary = DarkLightGreen,
    background = DarkGray,
    tertiary = DarkHighlightGreen
)

private val LightColorScheme = lightColorScheme(
    primary = Green,
    secondary = LightGreen,
    background = Color.White,
    tertiary = HighlightGreen
)

@Composable
fun FindMeTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (isDarkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        val systemUiController = rememberSystemUiController()
        val statusBarColor = if (isDarkTheme) {
            DarkGreen
        } else {
            Green
        }

        val navigationBarColor = if (isDarkTheme) {
            DarkGray
        } else {
            Color.White
        }

        SideEffect {
            systemUiController.setStatusBarColor(
                color = statusBarColor
            )
            systemUiController.setNavigationBarColor(
                color = navigationBarColor
            )
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}