package com.chinhdev.assignment_kot104

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dhnph34455.fpt.edu.asm_kotlin_ph34455.MyCart
import com.dhnph34455.fpt.edu.asm_kotlin_ph34455.R
import com.dhnph34455.fpt.edu.asm_kotlin_ph34455.WelcomeScreen
import com.dhnph34455.fpt.edu.asm_kotlin_ph34455.ui.theme.CheckOutSceen
import com.dhnph34455.fpt.edu.asm_kotlin_ph34455.ui.theme.LoginScreen
import com.dhnph34455.fpt.edu.asm_kotlin_ph34455.ui.theme.OderSuccess
import com.dhnph34455.fpt.edu.asm_kotlin_ph34455.ui.theme.ProductDetailScreen
import com.dhnph34455.fpt.edu.asm_kotlin_ph34455.ui.theme.ScreenHome

class MainActivity : ComponentActivity() {
    var showBottomNavBar = true

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()

            Scaffold(

            ) {
                NavHost(navController = navController, startDestination = "welcome") {
                    composable("welcome") { WelcomeScreen(navController = navController) }
                    composable("login") { LoginScreen(navController = navController) }
                    composable("home") { ScreenHome(navController = navController) }
                    composable("details") { ProductDetailScreen(navController = navController) }
                    composable("cart") { MyCart(navController = navController) }
                    composable("order") { CheckOutSceen(navController = navController) }
                    composable("sucssces") { OderSuccess(navController = navController) }
                }
            }
        }
    }


}


sealed class BottomNavItem(val route: String, val title: String, @DrawableRes val icon: Int) {
    object Home : BottomNavItem("home", "Home", R.drawable.ic_home)
    object Favorites : BottomNavItem("favorites", "Favorites", R.drawable.ic_maker)
    object Notification : BottomNavItem("profile", "Profile", R.drawable.ic_notification)
    object Profile : BottomNavItem("profile", "Profile", R.drawable.ic_person)
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Favorites,
        BottomNavItem.Notification,
        BottomNavItem.Profile
    )

    NavigationBar(containerColor = Color.White) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { screen ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = screen.icon),
                        contentDescription = screen.title,
                        modifier = Modifier.size(24.dp),
                    )
                },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        launchSingleTop = true
                        restoreState = true
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorResource(id = android.R.color.black),
                    unselectedIconColor = Color.Gray,
                )
            )
        }
    }
}





