package com.example.bussinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.example.bussinesscard.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { // Phải đặt @Composable bên trong setContent
            BusinessCardApp()
        }
    }
}

// Hàm chứa toàn bộ giao diện của ứng dụng
@Composable
fun BusinessCardApp() {
    MaterialTheme { // Thay BusinessCardTheme bằng MaterialTheme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            BusinessCard()
        }
    }
}


@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileSection()
        Spacer(modifier = Modifier.height(16.dp))
        ContactInfoSection()
    }
}

@Composable
fun ProfileSection() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.anh1),
            contentDescription = "Profile Picture",
            modifier = Modifier.size(100.dp)
        )
        Text(text = "LE QUANG THO", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = "Student", fontSize = 18.sp, color = Color.Gray)
    }
}

@Composable
fun ContactInfoSection() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        ContactInfoRow(icon = R.drawable.ic_phone, info = "0345759705")
        ContactInfoRow(icon = R.drawable.ic_email, info = "tholq.23ite@vku.udn..vn")
        ContactInfoRow(icon = R.drawable.ic_location, info = "QuangBinh, VietNam")
    }
}

@Composable
fun ContactInfoRow(icon: Int, info: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painterResource(id = icon), contentDescription = null, modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = info, fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardApp()
}
