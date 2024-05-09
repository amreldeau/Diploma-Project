package com.eidarulu.findme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eidarulu.findme.data.chatList
import com.eidarulu.findme.domain.ChatListDataObject
import com.eidarulu.findme.ui.theme.HighlightGreen

@Composable
fun Chats() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.Start
    ) {

        item {
            Spacer(modifier = Modifier.height(10.dp))
        }

        items(chatList) { chatData ->
            ChatListItem(chatData)
        }
    }
}

@Composable
fun ChatListItem(chatData: ChatListDataObject) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        UserImage(chatData.userImage)
        UserDetails(chatData)
    }
}

@Composable
fun UserDetails(chatData: ChatListDataObject) {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .padding(start = 16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        MessageHeader(chatData)
        MessageSubSection(chatData)
    }
}

@Composable
fun MessageSubSection(chatData: ChatListDataObject) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextComponent(
            value = chatData.message.content,
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier.weight(1f),
        )

        chatData.message.unreadCount?.also {
            CircularCount(
                unreadCount = it.toString(),
                backgroundColor = HighlightGreen,
                textColor = Color.White
            )
        }
    }
}

@Composable
fun MessageHeader(chatData: ChatListDataObject) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextComponent(
            modifier = Modifier.weight(1f),
            value = chatData.userName,
            fontSize = 18.sp,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold
        )
        TextComponent(
            value = chatData.message.timestamp,
            fontSize = 12.sp,
            color = if ((chatData.message.unreadCount ?: 0) > 0) HighlightGreen else Color.Gray,
            modifier = null,
            fontWeight = null
        )
    }
}

@Composable
fun TextComponent(
    value: String,
    fontSize: TextUnit,
    color: Color,
    modifier: Modifier?,
    fontWeight: FontWeight? = FontWeight.Normal
){
    if (modifier != null) {
        Text(
            modifier = modifier,
            text = value,
            style = TextStyle(
                fontSize = fontSize,
                fontWeight = fontWeight,
                color = color
            )
        )
    } else {
        Text(
            text = value,
            style = TextStyle(
                fontSize = fontSize,
                fontWeight = fontWeight,
                color = color
            )
        )
    }
}

@Composable
fun CircularCount(unreadCount: String, backgroundColor: Color, textColor: Color) {
    Text(
        text = unreadCount,
        modifier = Modifier
            .padding(4.dp)
            .size(16.dp)
            .clip(CircleShape)
            .background(backgroundColor),
        style = TextStyle(
            color = textColor,
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
    )
}

@Preview(showBackground = true)
@Composable
fun ChatsPreview() {
    Chats()
}