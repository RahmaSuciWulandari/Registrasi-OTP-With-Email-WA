package com.ciii.e_learn

import android.annotation.SuppressLint
//import android.graphics.drawable.Animatable
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@SuppressLint("RememberReturnType")
@Composable
fun SplashScreen3(navController: NavController) {
    val scale = remember { Animatable(0f) }

    LaunchedEffect(true) {
        scale.animateTo(
            targetValue = 0.9f,
            animationSpec = tween(durationMillis = 800)
        )
        delay(2000L)
        navController.navigate("home") { // Ganti "home" dengan route tujuan kamu
            popUpTo("splash3") { inclusive = true } // Ganti "splash" dengan nama route splash
        }
    }


    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF736EFE), Color(0xFF5C3BE1))
                )
            )
            .scale(scale.value)
            .padding(16.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.logoputih),
                contentDescription = "Ilustrasi belajar",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(380.dp)
            )
        }
    }
}
