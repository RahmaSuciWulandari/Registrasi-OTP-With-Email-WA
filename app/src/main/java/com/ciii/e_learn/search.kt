package com.ciii.e_learn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items


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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Searchpage(navController: NavController) {
    val gradientColors = listOf(Color(0xFF5F7DE8), Color(0xFF7B5DB8))
    //val gradientColors = listOf(Color(0xFF5F7DE8), Color(0xFF3B4FB1))

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Transparent
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 32.dp)
        ) {
            SearchBar()
            Spacer(modifier = Modifier.height(16.dp))
            // Scrollable grid section
            Box(modifier = Modifier.weight(1f)) {
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
            .background(Color.LightGray),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BasicTextField(
            value = textState,
            onValueChange = { textState = it },
            singleLine = true,
            modifier = Modifier
                .weight(1f)
                .background(Color.LightGray)
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
    val items = List(20) { it } // Ubah jumlah sesuai data kamu
    val shape = RoundedCornerShape(24.dp)

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        contentPadding = PaddingValues(bottom = 80.dp)
    ) {
        items(items) {
            CatCard(imageRes = R.drawable.course, shape = shape)
        }
    }
}

@Composable
fun CatCard(imageRes: Int, shape: RoundedCornerShape) {
    Column(
        modifier = Modifier
            //.weight(1f)
            .height(180.dp)
            .border(width = 2.dp, color = Color.Black, shape = shape)
            .clip(shape)
            .background(Color.White)
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Cartoon image of a cat",
            modifier = Modifier.size(100.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Guide to Learn R with\nE-Learn",
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black,
            fontSize = 10.sp,
            textAlign = TextAlign.Center,
            lineHeight = 12.sp
        )
    }
}
