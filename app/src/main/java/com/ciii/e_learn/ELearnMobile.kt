package com.ciii.e_learn

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CardMembership
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.*



@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ELearnApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    //sharedViewModel: SharedViewModel = hiltViewModel()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val routesWithBottomBar = listOf(
        Screen.Home.route,
        Screen.Cari.route,
        Screen.Sertifikat.route,
        Screen.Akun.route,
    )

    Scaffold(
        bottomBar = {
            if (currentRoute in routesWithBottomBar) {
                BottomBar(navController)
            }
        }
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Splash1.route,
            modifier = modifier.padding(contentPadding)
        ) {
            composable(Screen.Splash1.route) {
                SplashScreen(navController)
            }
            composable(Screen.Splash3.route) {
                SplashScreen3(navController)
            }
            composable(Screen.Welcome1.route) {
                WelcomeScreen(navController)
            }
            composable(Screen.Welcome2.route) {
                WelcomeScreen2(navController)
            }
            composable(Screen.Welcome3.route) {
                WelcomeScreen3(navController)
            }
            composable(Screen.SignIn.route) {
                SignInScreen(navController)
            }
            composable(Screen.SignUp1.route) {
                SignUpScreen(navController)
            }
            composable(Screen.SignUp2.route) {
                SignUp2Screen(navController)
            }
            composable(Screen.Home.route) {
                Home(navController)
            }
//            composable(Screen.Cari.route) {
//                SearchScreen(navController)
//            }
//            composable(Screen.Sertifikat.route) {
//                CertificateScreen(navController)
//            }
//            composable(Screen.Akun.route) {
//                AccountScreen(navController)
//            }
            // Tambah halaman lainnya sesuai kebutuhan
        }
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val purpleGradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF5B6DD9), Color(0xFF8A7FEF))
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val navigationItems = listOf(
        NavigationItem(
            title = "Beranda",
            icon = Icons.Default.Home,
            screen = Screen.Home
        ),
        NavigationItem(
            title = "Cari",
            icon = Icons.Default.Search,
            screen = Screen.Cari
        ),
        NavigationItem(
            title = "Sertifikat",
            icon = Icons.Default.CardMembership,
            screen = Screen.Sertifikat
        ),
        NavigationItem(
            title = "Akun",
            icon = Icons.Default.Person,
            screen = Screen.Akun
        ),
    )

    Surface(
        modifier = Modifier
            .padding(8.dp)
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
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            navigationItems.forEach { item ->
                val selected = currentRoute == item.screen.route
                val contentColor = if (selected) Color.White else Color.White.copy(alpha = 0.7f)

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .clickable {
                            if (currentRoute != item.screen.route) {
                                navController.navigate(item.screen.route) {
                                    launchSingleTop = true
                                    restoreState = true
                                    popUpTo(Screen.Home.route) {
                                        inclusive = false
                                    }
                                }
                            }
                        }
                ) {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        tint = contentColor,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = item.title,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = contentColor
                    )
                }
            }
        }
    }
}
