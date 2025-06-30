package com.ciii.e_learn

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AkunScreen(navController: NavController) {
    val buttonColor = Color(0xFF5F7DE8)
    val textColor = Color.Black

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 32.dp), // Tambah padding atas-bawah
        verticalArrangement = Arrangement.Top, // Ganti dari Center ke Top
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Ilustrasi
        Image(
            painter = painterResource(id = R.drawable.profil),
            contentDescription = "Ilustrasi profil",
            modifier = Modifier
                .size(150.dp)
                .padding(top = 24.dp),
            contentScale = ContentScale.Fit
        )

        // Logo
        Image(
            painter = painterResource(id = R.drawable.logoungu),
            contentDescription = "Logo E-Learn",
            modifier = Modifier
                .padding(top = 32.dp, bottom = 48.dp)
                .width(192.dp)
                .height(60.dp),
            contentScale = ContentScale.Fit
        )

        // Tombol Info Akun
        Button(
            onClick = { /* TODO: Handle Info Akun */ },
            colors = ButtonDefaults.buttonColors(containerColor = buttonColor, contentColor = textColor),
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(bottom = 16.dp)
        ) {
            Text(text = "Info Akun", fontSize = 16.sp)
        }

        Button(
            onClick = { /* TODO: Handle Keluar */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = buttonColor,
                contentColor = textColor
            ),
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(bottom = 32.dp)
        ) {
            Text(
                text = "Keluar",
                fontSize = 16.sp,
                color = textColor // Tambahkan ini eksplisit
            )
        }


        // Footer
        Text(
            text = "E-Learn Academy Version 1.0\nby Walid's Girl",
            color = textColor,
            fontSize = 12.sp,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(bottom = 32.dp)
                .widthIn(max = 320.dp)
        )
    }
}
