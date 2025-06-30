package com.ciii.e_learn

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun Home(navController: NavController) {
    val purpleGradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF5B6DD9), Color(0xFF8A7FEF))
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(purpleGradient)
    ) {
        // "Hi, User!"
        Text(
            text = "Hi, User!",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(start = 16.dp, top = 24.dp, bottom = 24.dp)
        )

        // White content area
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color.White)
                .padding(16.dp)
        ) {
            // Welcome card
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
                            imageRes = R.drawable.oyen,
                            title = "R for Data Science",
                            name = "Rizky Pratama"
                        )
                        ProfileItem(
                            imageRes = R.drawable.oyen,
                            title = "Python for Data Science",
                            name = "Fajar Nugroho"
                        )
                        ProfileItem(
                            imageRes = R.drawable.oyen,
                            title = "AI for Data Science",
                            name = "Fauzan Arifin"
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Button "Yuk, Mulai!"
            Button(
                onClick = {navController.navigate(Screen.Cari.route)},
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

            // Course card
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.Black, RoundedCornerShape(24.dp))
                    .clip(RoundedCornerShape(24.dp))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(id = R.drawable.course),
                        contentDescription = "Course Image",
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

@Composable
fun ProfileItem(imageRes: Int, title: String, name: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(80.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
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
