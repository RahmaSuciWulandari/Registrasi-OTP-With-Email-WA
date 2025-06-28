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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun Searchpage(navController: NavController) {
    val gradientColors = listOf(Color(0xFF5F7DE8), Color(0xFF7B5DB8))
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Transparent
    ) {
        Box(
            modifier = Modifier
                .background(brush = Brush.verticalGradient(gradientColors))
                .fillMaxSize()
                .padding(vertical = 32.dp, horizontal = 20.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                SearchBar()
                Spacer(modifier = Modifier.height(32.dp))
                CatGrid()
            }
        }
    }
}

@Composable
fun SearchBar() {
    var textState by remember { mutableStateOf(TextFieldValue("")) }
    val focusManager = LocalFocusManager.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(50))
            .background(Color.White.copy(alpha = 0.3f)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BasicTextField(
            value = textState,
            onValueChange = { textState = it },
            singleLine = true,
            modifier = Modifier
                .weight(1f)
                .background(Color.White)
                .padding(start = 20.dp, top = 12.dp, bottom = 12.dp),
            textStyle = TextStyle(
                color = Color(0xFF4B5563),
                fontSize = 14.sp
            ),
            decorationBox = { innerTextField ->
                if (textState.text.isEmpty()) {
                    Text(
                        text = "Cari.......",
                        color = Color(0xFF9CA3AF),
                        fontSize = 14.sp
                    )
                }
                innerTextField()
            }
        )
        Box(
            modifier = Modifier
                .background(Color(0xFFAEB9F7), shape = CircleShape)
                .size(48.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun CatGrid() {
    val items = List(6) { it }
    val shape = RoundedCornerShape(24.dp)

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (rowIndex in 0 until 3) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                for (colIndex in 0 until 2) {
                    val index = rowIndex * 2 + colIndex
                    if (index < items.size) {
                        CatCard(imageRes = R.drawable.oyen, shape = shape)
                    } else {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Composable
fun CatCard(imageRes: Int, shape: RoundedCornerShape) {
    Column(
        modifier = Modifier
            //.weight(1f)
            .border(width = 2.dp, color = Color.Black, shape = shape)
            .clip(shape)
            .background(Color.White)
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Cartoon image of a cat wearing black sunglasses with a confident pose",
            modifier = Modifier
                .size(120.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Guide to Learn R with\nE-Learn",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 10.sp,
            textAlign = TextAlign.Center,
            lineHeight = 12.sp
        )
    }
}
