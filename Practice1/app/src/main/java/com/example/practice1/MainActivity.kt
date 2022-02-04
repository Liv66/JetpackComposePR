package com.example.practice1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(Message("Andorid", "JetpackCompose"))
        }
    }
}

data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    // Add padding around our message
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = "Contact",
            modifier = Modifier
                .size(40.dp) // 이미지 크기 설정
                .clip(CircleShape) // 이미지 shape 설정
        )

        Spacer(modifier = Modifier.width(8.dp)) // 너비 8dp짜리 빈 공간 생성

        Column {
            Text(text = msg.author)
            Spacer(modifier = Modifier.height(4.dp)) // 글자 사이에 높이 4dp 짜리 빈 공간 생성
            Text(text = msg.body)
        }
    }

}

@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard(msg = Message("Colleage", "Hey"))
}
