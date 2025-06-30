package com.ciii.e_learn

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun CertificateScreen(navController: NavController) {
    val gradientBackground = Brush.verticalGradient(
        colors = listOf(Color(0xFF6B7CE3), Color(0xFF6B4CA3))
    )

    Scaffold(
        containerColor = Color.Transparent
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
                .padding(16.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            CertificateCard()
        }
    }
}

@Composable
fun CertificateCard() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .widthIn(max = 400.dp)
            .padding(top = 64.dp)
            .clip(RoundedCornerShape(50.dp))
            .background(Color.White)
            .border(BorderStroke(1.dp, Color.Black), RoundedCornerShape(50.dp))
            .padding(vertical = 24.dp, horizontal = 24.dp)
    ) {
        Text(
            text = "Your Certificate",
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(30.dp))
                .background(Color(0xFF6B7CE3))
                .border(BorderStroke(1.dp, Color.Black), RoundedCornerShape(30.dp))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.course), // Ganti dengan nama file kamu
                    contentDescription = "Certificate image",
                    modifier = Modifier
                        .size(width = 240.dp, height = 160.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .border(BorderStroke(1.dp, Color.Black), RoundedCornerShape(30.dp)),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Guide to Learn R with E-Learn",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(
                            imageVector = Icons.Default.Download,
                            contentDescription = "Download certificate",
                            tint = Color.White
                        )
                    }
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(
                            imageVector = Icons.Default.Visibility,
                            contentDescription = "View certificate",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
}
