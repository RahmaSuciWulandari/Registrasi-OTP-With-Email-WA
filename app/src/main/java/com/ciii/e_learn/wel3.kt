package com.ciii.e_learn

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
//import com.uci.tajamentawai.navigation.Screen

@Composable
fun WelcomeScreen3(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF736EFE), Color(0xFF5C3BE1))
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            // .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Ilustrasi
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.6f),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.wel3),
                    contentDescription = "Ilustrasi belajar",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(380.dp)
                )
            }

            // Card Putih
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.3f),
                shape = RoundedCornerShape(topStart = 90.dp, topEnd = 90.dp), // Radius sedang
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 24.dp, vertical = 60.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Get the Certificate",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1F2937),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Buktikan kemampuanmu \ndengan certificate resmi",
                        fontSize = 14.sp,
                        color = Color(0xFF6B7280),
                        textAlign = TextAlign.Center,
                        lineHeight = 20.sp
                    )

                    Spacer(modifier = Modifier.height(40.dp))

                    // Indicator dot lebih dekat ke text
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    ) {
                        val dotActive = Color(0xFF6B7BFF)
                        val dotInactive = Color(0xFFC4C4C4)
                        listOf(dotInactive, dotInactive, dotActive).forEach {
                            Box(
                                modifier = Modifier
                                    .size(8.dp)
                                    .background(color = it, shape = RoundedCornerShape(50))
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(28.dp))

                    Button(
                        onClick = {navController.navigate(Screen.SignIn.route)},
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF6366F1)
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = "Next",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "Next",
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Column {
                        Text(
                            text = "Skip for now",
                            fontSize = 14.sp,
                            modifier = Modifier.clickable { navController.navigate(Screen.SignIn.route) },
                            color = Color(0xFF6B7280)
                        )
                    }
                }
            }
        }
    }
}

