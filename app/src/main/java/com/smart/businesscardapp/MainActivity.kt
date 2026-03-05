package com.smart.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smart.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // 🔥 Profile Image
        Image(
            painter = painterResource(id = R.drawable.ma_image),
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(140.dp)
                .clip(CircleShape)
                .border(
                    width = 3.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = CircleShape
                ),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Name
        Text(
            text = "Azariah Enoch",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold
        )

        // Title
        Text(
            text = "Developer",
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(40.dp))

        // Contact Info
        ContactRow(info = "📞 +234 800 000 0000")
        ContactRow(info = "📧 Feddy@example.com")
        ContactRow(info = "🌐 www.Feddy.dev")
    }
}



@Composable
fun ContactRow(info: String) {
    Row(
        modifier = Modifier.padding(vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = info,
            fontSize = 16.sp
        )
    }
}