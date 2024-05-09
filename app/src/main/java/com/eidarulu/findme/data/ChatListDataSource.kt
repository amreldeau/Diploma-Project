package com.eidarulu.findme.data

import com.eidarulu.findme.domain.ChatListDataObject
import com.eidarulu.findme.domain.Message
import com.eidarulu.findme.domain.MessageDeliveryStatus
import com.eidarulu.findme.domain.MessageType

val chatList = listOf<ChatListDataObject>(
    ChatListDataObject(
        chatId = 1,
        message = Message(
            content = "wtf?",
            timestamp = "15/04/2024 09:30 AM",
            type = MessageType.TEXT,
            deliveryStatus = MessageDeliveryStatus.PENDING
        ),
        userName = "Qasym-Jomart Tokayev"
    ),

    ChatListDataObject(
        chatId = 2,
        message = Message(
            content = "😂😂😂",
            timestamp = "15/04/2024 09:35 AM",
            type = MessageType.TEXT,
            deliveryStatus = MessageDeliveryStatus.DELIVERED,
            unreadCount = 5
        ),
        userName = "Ada Tyler"
    ),

    ChatListDataObject(
        chatId = 3,
        message = Message(
            content = "OMG, yes! 🌠",
            timestamp = "15/04/2024 10:05 AM",
            type = MessageType.TEXT,
            deliveryStatus = MessageDeliveryStatus.READ
        ),
        userName = "Emma Peters"
    ),

    ChatListDataObject(
        chatId = 4,
        message = Message(
            content = "Hey, wanna grab some pizza later?",
            timestamp = "15/04/2024 12:30 PM",
            type = MessageType.TEXT,
            deliveryStatus = MessageDeliveryStatus.READ
        ),
        userName = "Elon Musk"
    ),

    ChatListDataObject(
        chatId = 5,
        message = Message(
            content = "тема",
            timestamp = "15/04/2024 02:00 PM",
            type = MessageType.TEXT,
            deliveryStatus = MessageDeliveryStatus.DELIVERED,
            unreadCount = 3
        ),
        userName = "Atymtai Zhomart"
    ),

    ChatListDataObject(
        chatId = 6,
        message = Message(
            content = "These images could be key to understanding the structure of DNA!",
            timestamp = "15/04/2024 02:05 PM",
            type = MessageType.TEXT,
            deliveryStatus = MessageDeliveryStatus.READ
        ),
        userName = "Brandon Fosse"
    ),

    ChatListDataObject(
        chatId = 7,
        message = Message(
            content = "Good Morning",
            timestamp = "15/04/2024",
            type = MessageType.TEXT,
            deliveryStatus = MessageDeliveryStatus.READ
        ),
        userName = "Billie Eilish"
    ),

    ChatListDataObject(
        chatId = 8,
        message = Message(
            content = "I aced my exam! 😄",
            timestamp = "15/04/2024 03:00 PM",
            type = MessageType.TEXT,
            deliveryStatus = MessageDeliveryStatus.READ
        ),
        userName = "Chris Vazovski"
    ),

    ChatListDataObject(
        chatId = 9,
        message = Message(
            content = "checked out restaurant downtown?",
            timestamp = "15/04/2024 01:00 PM",
            type = MessageType.TEXT,
            deliveryStatus = MessageDeliveryStatus.PENDING
        ),
        userName = "Jessica Wilson"
    ),

    ChatListDataObject(
        chatId = 10,
        message = Message(
            content = "みなさん、明日の午前10時に会議があることをお知らせしたいと思います。みんなが出席することが重要です。よろしくお願いします！",
            timestamp = "15/04/2024 02:30 PM",
            type = MessageType.TEXT,
            deliveryStatus = MessageDeliveryStatus.READ
        ),
        userName = "Yuki Tanaka"
    ),

    ChatListDataObject(
        chatId = 11,
        message = Message(
            content = "ертеңгі кездесу туралы.",
            timestamp = "15/04/2024 10:00 AM",
            type = MessageType.TEXT,
            deliveryStatus = MessageDeliveryStatus.READ
        ),
        userName = "Alisher Nurmagambetov"
    ),

    ChatListDataObject(
        chatId = 12,
        message = Message(
            content = "Сәлем!",
            timestamp = "15/04/2024 03:30 PM",
            type = MessageType.TEXT,
            deliveryStatus = MessageDeliveryStatus.DELIVERED,
            unreadCount = 1
        ),
        userName = "Dana Kozhabekova"
    ),

    ChatListDataObject(
        chatId = 13,
        message = Message(
            content = "Yo dawg, just lettin' u know about the BBQ at my place this weekend. It's gonna be lit! Don't miss out!",
            timestamp = "15/04/2024 12:00 PM",
            type = MessageType.TEXT,
            deliveryStatus = MessageDeliveryStatus.DELIVERED,
            unreadCount = 1
        ),
        userName = "James Washington"
    )
)