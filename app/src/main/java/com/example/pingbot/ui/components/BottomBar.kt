package com.example.pingbot.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.pingbot.ui.theme.SecondaryColor

@Composable
fun BottomBar(navController: NavController) {
    NavigationBar(
        containerColor = SecondaryColor
    ) {
        val items = listOf(
            Triple("home", "Home", Icons.Default.Home),
            Triple("queueUsers", "Fila", Icons.Default.Info),
            Triple("gamesList", "Games", Icons.Default.Face)
        )

        // Obtém a rota atual
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route

        items.forEach { (route, label, icon) ->
            NavigationBarItem(
                icon = {
                    Icon(
                        icon,
                        contentDescription = label
                    )
                },
                label = {
                    Text(label)
                },
                selected = currentRoute == route,
                onClick = {
                    if (currentRoute != route) {
                        navController.navigate(route)
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Cyan,
                    unselectedIconColor = Color.White,
                    selectedTextColor = Color.Cyan,
                    unselectedTextColor = Color.White,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}
