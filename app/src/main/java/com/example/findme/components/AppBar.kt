package com.example.findme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.findme.R
import com.example.findme.ui.theme.Lato

@Composable
fun AppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            style = TextStyle(
                fontSize = 25.sp, // 20
                fontWeight = FontWeight.SemiBold,
                fontFamily = Lato, //added
                color = MaterialTheme.colorScheme.tertiary
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        IconComponent(drawableId = R.drawable.ic_notifications)
    }
}

@Composable
fun IconComponent(drawableId: Int) {
    Icon(
        painter = painterResource(id = drawableId),
        contentDescription = "",
        tint = MaterialTheme.colorScheme.tertiary
    )
}

@Preview()
@Composable
fun AppBarPreview() {
    AppBar()
}