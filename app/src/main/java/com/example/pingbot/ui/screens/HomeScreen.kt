package com.example.pingbot.ui.screens

import TopAppBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pingbot.R
import com.example.pingbot.ui.components.BottomBar
import com.example.pingbot.ui.components.DrawerMenu
import com.example.pingbot.ui.components.GameScore
import com.example.pingbot.ui.theme.BackgroundColor
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    navController: NavHostController
) {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    DrawerMenu(
        navController = navController,
        scope = scope,
        drawerState = drawerState
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    navController = navController,
                    onOpenDrawer = { scope.launch { drawerState.open() } },
                    showBackButton = false
                )
            },

            bottomBar = {
                BottomBar(navController)
            }
        ) { paddingValues ->
            // Tela Principal
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(BackgroundColor),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {

                    GameScore()

                    Spacer(modifier = Modifier.height(32.dp))

                    Image(
                        painter = painterResource(id = R.drawable.img_1),
                        contentDescription = "Logo Horizontal",
                        modifier = Modifier.size(300.dp)
                    )

                }
            }
        }
    }
}
