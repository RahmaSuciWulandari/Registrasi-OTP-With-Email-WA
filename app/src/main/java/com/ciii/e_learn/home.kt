package com.ciii.e_learn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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

//import coil.compose.rememberAsyncImagePainter


@Composable
fun Home(navController: NavController) {
    val purpleGradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF5B6DD9), Color(0xFF8A7FEF))
    )

    Scaffold (
        bottomBar = { BottomNavBar() },
        //backgroundColor = Color.Transparent,
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(purpleGradient)
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                // "Hi, User!" text
                Box(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 24.dp)
                ) {
                    Text(
                        text = "Hi, User!",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                }

                // White overlay card with rounded top corners
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .offset(y = 16.dp)
                        .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                        .background(Color.White)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 24.dp)
                    ) {
                        // Inner purple card with welcome message and avatars
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(30.dp))
                                .background(purpleGradient)
                                .padding(24.dp)
                        ) {
                            Column {
                                Text(
                                    text = "Selamat datang, User!",
                                    color = Color.White,
                                    fontSize = 22.sp,
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.SemiBold
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "Yuk belajar data science bareng E-Learn Academy :)",
                                    color = Color.White,
                                    fontSize = 14.sp
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    ProfileItem(
                                        imageUrl = "https://storage.googleapis.com/a1aa/image/c73679fd-d4a3-4b59-bd3a-879fa86b9643.jpg",
                                        title = "R for Data Science",
                                        name = "Rizky Pratama"
                                    )
                                    ProfileItem(
                                        imageUrl = "https://storage.googleapis.com/a1aa/image/5ff70468-ff56-43a3-c7cf-8835adbb7380.jpg",
                                        title = "Python for Data Science",
                                        name = "Fajar Nugroho"
                                    )
                                    ProfileItem(
                                        imageUrl = "https://storage.googleapis.com/a1aa/image/0c01a376-2744-46ee-1a09-9fe9d1c5799e.jpg",
                                        title = "AI for Data Science",
                                        name = "Fauzan Arifin, PhD"
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        // Button "Yuk, Mulai!"
                        Button(
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(Color(0xFF5B6DD9)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(40.dp),
                            shape = RoundedCornerShape(6.dp)
                        ) {
                            Text(
                                text = "Yuk, Mulai!",
                                color = Color.White,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        // Popular Course title
                        Text(
                            text = "Popular Course",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = Color.Black,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )

                        // Popular course card
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(1.dp, Color.Black, RoundedCornerShape(24.dp))
                                .clip(RoundedCornerShape(24.dp))
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.course),
                                    contentDescription = "Illustration of a cat wearing sunglasses, cartoon style",
                                    modifier = Modifier
                                        .size(width = 150.dp, height = 120.dp)
                                        .clip(RoundedCornerShape(12.dp)),
                                    contentScale = ContentScale.Crop
                                )
                                Spacer(modifier = Modifier.height(12.dp))
                                Text(
                                    text = "Guide to Learn R with E-Learn",
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileItem(imageUrl: String, title: String, name: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(80.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.oyen),
            contentDescription = "$title avatar",
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = title,
            fontSize = 10.sp,
            color = Color.White,
            textAlign = TextAlign.Center
        )
        Text(
            text = name,
            fontWeight = FontWeight.SemiBold,
            fontSize = 10.sp,
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun BottomNavBar() {
    val purpleGradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF5B6DD9), Color(0xFF8A7FEF))
    )
    Surface(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(brush = purpleGradient),
        color = Color.Transparent,
        shadowElevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavItem(icon = Icons.Default.Home, label = "Beranda", selected = true)
            BottomNavItem(icon = Icons.Default.Search, label = "Cari", selected = false)
            BottomNavItem(icon = Icons.Default.CardMembership, label = "Sertifikat", selected = false)
            BottomNavItem(icon = Icons.Default.Person, label = "Akun", selected = false)
        }
    }
}

@Composable
fun BottomNavItem(icon: androidx.compose.ui.graphics.vector.ImageVector, label: String, selected: Boolean) {
    val contentColor = if (selected) Color.White else Color.White.copy(alpha = 0.7f)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = contentColor,
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = label,
            fontSize = 10.sp,
            fontWeight = FontWeight.SemiBold,
            color = contentColor
        )
    }
}