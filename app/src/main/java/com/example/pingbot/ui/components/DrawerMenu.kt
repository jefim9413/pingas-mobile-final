package com.example.pingbot.ui.components

import androidx.compose.material3.DrawerState
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope

@Composable
fun DrawerMenu(
    navController: NavController,
    scope: CoroutineScope,
    drawerState: DrawerState,
    content: @Composable () -> Unit
) {


    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            MenuContent(
                navController = navController,
                drawerState = drawerState,
                scope = scope,
            )
        },
        content = {

            content()

        }
    )
}